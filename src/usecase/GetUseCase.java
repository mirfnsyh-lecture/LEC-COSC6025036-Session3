package usecase;

import entity.Mahasiswa;
import infrastructure.CsvHelper;

import java.util.List;

public class GetUseCase {
    public void getList() {
        try {
            List<Mahasiswa> mahasiswaList = new CsvHelper().readCSV();
            if (mahasiswaList.isEmpty()) {
                throw new Exception("Data Mahasiswa kosong");
            }

            System.out.println("=== Data Mahasiswa ===");
            for (Mahasiswa m : mahasiswaList) {
                m.tampilkanInfo(false, false);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void getListWithPredicate() {
        try {
            List<Mahasiswa> mahasiswaList = new CsvHelper().readCSV();
            if (mahasiswaList.isEmpty()) {
                throw new Exception("Data Mahasiswa kosong");
            }

            System.out.println("=== Data Mahasiswa dengan Predikat ===");
            for (Mahasiswa m : mahasiswaList) {
                m.tampilkanInfo(true, true);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
