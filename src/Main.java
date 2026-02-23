import java.util.Scanner;

import usecase.GetUseCase;
import usecase.UpdateUseCase;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            boolean isRun = true;

            while (isRun) {
                System.out.println("\n=== MAIN MENU ===");
                System.out.println("1. Show Data Mahasiswa (Pembuatan Class dan Object)");
                System.out.println("2. Update IPK Mahasiswa (Menerapkan Enkapsulasi dan Method)");
                System.out.println("3. Show Data Mahasiswa with Predicate (Menentukan Predikat Akademik)");
                System.out.println("0. Shutdown");
                System.out.print("Pilih opsi (0-3): ");

                int selected = input.nextInt();
                switch (selected) {
                    case 1:
                        new GetUseCase().getList();
                        break;
                    case 2:
                        new UpdateUseCase().doUpdate();
                        break;
                    case 3:
                        new GetUseCase().getListWithPredicate();
                        break;
                    case 0:
                        isRun = false;
                        System.out.println("Graceful Shutdown ...");

                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }

            input.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
