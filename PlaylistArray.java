/*
Nama Kelompok 2:
1. AHMAD WIDAD IZZUDDIN - 2902795331
2. ELVIA DESTIANI - 2902801265
3. MUHAMMAD ZIKRI - 2902794266
4. TIARA ANDINA DALIMUNTHE - 2902772063
5. VINA NAMIRA ANDRINA ANDIDI - 2902789202

Tugas Kelompok 2 
Arrays and its operations
*/

import java.util.Scanner;

public class PlaylistArray {

    // Kapasitas maksimum playlist (sesuai instruksi: maks. 10 lagu)
    private static final int MAKS_LAGU = 10;

    // Array statis penyimpan objek Lagu
    private Lagu[] playlist = new Lagu[MAKS_LAGU];

    // Penanda banyaknya lagu yang sudah terisi pada array
    private int jumlahLagu = 0;

    // Menambahkan lagu ke playlist — cek penuh dulu sebelum meminta input
    public void tambahLagu(Scanner scan) {
        if (jumlahLagu >= MAKS_LAGU) {
            System.out.println("Playlist penuh. Tidak bisa menambahkan lagu.");
            return;
        }

        System.out.print("Masukkan judul lagu  : ");
        String judul = scan.nextLine().trim();
        System.out.print("Masukkan artis       : ");
        String artis = scan.nextLine().trim();

        double durasi;
        try {
            System.out.print("Masukkan durasi (menit): ");
            durasi = Double.parseDouble(scan.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Input durasi tidak valid. Penambahan dibatalkan.");
            return;
        }

        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
        jumlahLagu++;
        System.out.println("Lagu berhasil ditambahkan!");
    }

    // Menampilkan ringkas isi playlist 
    public void tampilkanRingkas() {
        System.out.println("\nDaftar lagu saat ini (" + jumlahLagu + "/" + MAKS_LAGU + "):");
        for (int i = 0; i < jumlahLagu; i++) {
            Lagu l = playlist[i];
            System.out.println((i + 1) + ". " + l.getJudul() + " - " + l.getArtis() + " (" + l.getDurasi() + " menit)");
        }
    }

    public static void main(String[] args) {
        PlaylistArray pa = new PlaylistArray();
        Scanner scan = new Scanner(System.in);

        String lanjut = "y";
        while ("y".equalsIgnoreCase(lanjut)) {
            pa.tambahLagu(scan);
            pa.tampilkanRingkas();
            System.out.print("\nTambah lagi? (y/n): ");
            lanjut = scan.nextLine().trim();
        }

        scan.close();
        System.out.println("Demo selesai.");
    }
}
