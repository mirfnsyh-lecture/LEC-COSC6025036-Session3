package entity;

public class Mahasiswa {

    private static final double MIN_PASS_GRADE = 3.00;
    private static final double MIN_IPK = 0.0;
    private static final double MAX_IPK = 4.0;

    private static final double MIN_DENGAN_PUJIAN_GRADE = 3.75;
    private static final double MIN_SANGAT_MEMUASKAN_GRADE = 3.50;
    private static final double MIN_MEMUASKAN_GRADE = 3.00;

    private String nama;
    private String nim;
    private String jurusan;
    private double ipk;

    public Mahasiswa(String nama, String nim, String jurusan, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.ipk = ipk;
    }

    public void tampilkanInfo(boolean isShowStatus, boolean isShowPredicate) {
        System.out.println("============================");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Jurusan: " + jurusan);
        System.out.println("IPK: " + ipk);

        if (isShowStatus) {
            System.out.println("Status: " + cekKelulusan());
        }

        if (isShowPredicate) {
            System.out.println("Predikat: " + hitungPredikat());
        }
        System.out.println("============================");
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public void updateIpk(double ipkBaru) {
        if (ipkBaru < MIN_IPK || ipkBaru > MAX_IPK) {
            throw new IllegalArgumentException("IPK harus antara " + MIN_IPK + " dan " + MAX_IPK);
        }

        setIpk(ipkBaru);
    }

    public String cekKelulusan() {
        return getIpk() >= MIN_PASS_GRADE ? "Lulus" : "Belum Lulus";
    }

    public String hitungPredikat() {
        if (getIpk() >= MIN_DENGAN_PUJIAN_GRADE) {
            return "Dengan Pujian";
        } else if (getIpk() >= MIN_SANGAT_MEMUASKAN_GRADE) {
            return "Sangat Memuaskan";
        } else if (getIpk() >= MIN_MEMUASKAN_GRADE) {
            return "Memuaskan";
        } else {
            return "Perlu Perbaikan";
        }
    }
}
