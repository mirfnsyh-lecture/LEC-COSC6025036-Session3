package infrastructure;

import entity.Mahasiswa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {
    private static final String CSV_PATH = "data/mahasiswa.csv";

    public List<Mahasiswa> readCSV() throws Exception {
        List<Mahasiswa> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_PATH))) {
            String line;
            boolean header = true;

            while ((line = br.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                line = line.trim();
                if (line.isEmpty()) continue;

                String[] column = line.split(",");
                if (column.length < 4) continue;

                String nama = column[0].trim();
                String nim = column[1].trim();
                String jurusan = column[2].trim();
                double ipk = Double.parseDouble(column[3].trim());

                result.add(new Mahasiswa(nama, nim, jurusan, ipk));
            }
        } catch (IOException e) {
            throw new Exception("[Error] Saat membaca file: " + e.getMessage());
        } catch (NumberFormatException e) {
            throw new Exception("[Error] Format IPK di CSV: " + e.getMessage());
        }

        return result;
    }

    public void writeCSV(List<Mahasiswa> list) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_PATH))) {
            bw.write("nama,nim,jurusan,ipk");
            bw.newLine();

            for (Mahasiswa m : list) {
                bw.write(m.getNama() + "," + m.getNim() + "," + m.getJurusan() + "," + m.getIpk());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new Exception("Gagal menulis file: " + e.getMessage());
        }
    }
}
