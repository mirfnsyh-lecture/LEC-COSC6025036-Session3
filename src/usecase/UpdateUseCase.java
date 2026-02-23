package usecase;

import entity.Mahasiswa;
import infrastructure.CsvHelper;

import java.util.List;
import java.util.Scanner;

public class UpdateUseCase {
    public void doUpdate() {
        try {
            CsvHelper csvHelper = new CsvHelper();

            List<Mahasiswa> mahasiswaList = csvHelper.readCSV();
            if (mahasiswaList.isEmpty()) {
                throw new Exception("Data Mahasiswa kosong");
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan NIM mahasiswa yang ingin diupdate: ");
            String nimRequest = scanner.nextLine().trim();

            Mahasiswa m = null;
            for (Mahasiswa mahasiswa : mahasiswaList) {
                if (mahasiswa.getNim().equals(nimRequest)) {
                    m = mahasiswa;
                    break;
                }
            }

            if (m == null) {
                System.err.println("Mahasiswa dengan NIM " + nimRequest + " tidak ditemukan.");
                return;
            }

            System.out.print("=== Mahasiswa "+ m.getNim() +" - " + m.getNama() + " berhasil ditemukan. ===\n");
            System.out.print("Masukkan IPK baru: ");
            double ipkBaru = Double.parseDouble(scanner.nextLine().trim());

            m.updateIpk(ipkBaru);
            csvHelper.writeCSV(mahasiswaList);

            System.out.println("Data " + m.getNama() +" berhasil diperbarui!\n");
            System.out.println("=== Data Mahasiswa ===");
            m.tampilkanInfo(true, false);
        } catch (Exception e) {
            System.err.println("[Error] " + e.getMessage());
        }
    }
}
