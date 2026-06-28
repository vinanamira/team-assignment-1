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
            System.out.println("\nPlaylist penuh!");
            return;
        }

        System.out.print("Masukkan judul lagu : ");
        String judul = scan.nextLine();

        System.out.print("Masukkan artis      : ");
        String artis = scan.nextLine();

        System.out.print("Masukkan durasi (menit): ");

        double durasi;

        try {
            durasi = Double.parseDouble(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Durasi tidak valid.");
            return;
        }

        playlist[jumlahLagu] = new Lagu(judul, artis, durasi);
        jumlahLagu++;

        System.out.println("\nLagu berhasil ditambahkan!");
    }

    // TRAVERSAL- Menampilkan seluruh lagu
    public void tampilkanSemuaLagu() {

        if (jumlahLagu == 0) {
            System.out.println("\nPlaylist masih kosong.");
            return;
        }

        System.out.println("\n=== DAFTAR LAGU ===");

        for (int i = 0; i < jumlahLagu; i++) {
            System.out.print((i + 1) + ". ");
            playlist[i].tampilkanInfo();
        }
    }

    // Searching - Linear Search berdasarkan judul
    public void cariLagu(Scanner scan) {

        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }

        System.out.print("Masukkan judul lagu yang dicari : ");
        String judul = scan.nextLine();

        for (int i = 0; i < jumlahLagu; i++) {

            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {

                System.out.println("\nLagu ditemukan:");
                playlist[i].tampilkanInfo();
                return;

            }

        }

        System.out.println("Lagu tidak ditemukan.");
    }

    // Deletion - Menghapus lagu berdasarkan judul
    public void hapusLagu(Scanner scan) {

        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }

        System.out.print("Masukkan judul lagu yang akan dihapus : ");
        String judul = scan.nextLine();

        int index = -1;

        // Linear Search

        for (int i = 0; i < jumlahLagu; i++) {

            if (playlist[i].getJudul().equalsIgnoreCase(judul)) {

                index = i;
                break;

            }

        }

        if (index == -1) {

            System.out.println("Lagu tidak ditemukan.");
            return;

        }

        // Geser elemen array ke kiri

        for (int i = index; i < jumlahLagu - 1; i++) {

            playlist[i] = playlist[i + 1];

        }

        playlist[jumlahLagu - 1] = null;
        jumlahLagu--;

        System.out.println("Lagu berhasil dihapus.");
    }

    // Sorting berdasarkan durasi (Bubble Sort)
    public void urutkanLaguBerdasarkanDurasi() {

        if (jumlahLagu == 0) {
            System.out.println("Playlist masih kosong.");
            return;
        }

        System.out.println("\n=== Sebelum Sorting ===");
        tampilkanSemuaLagu();

        for (int i = 0; i < jumlahLagu - 1; i++) {

            for (int j = 0; j < jumlahLagu - i - 1; j++) {

                if (playlist[j].getDurasi() > playlist[j + 1].getDurasi()) {

                    Lagu temp = playlist[j];
                    playlist[j] = playlist[j + 1];
                    playlist[j + 1] = temp;

                }

            }

        }

        System.out.println("\n=== Setelah Sorting (Ascending) ===");
        tampilkanSemuaLagu();

    }

    // MENU UTAMA
        public static void main(String[] args) {

        PlaylistArray pa = new PlaylistArray();
        Scanner scan = new Scanner(System.in);

        int pilihan;

        do {

            System.out.println("\n==============================");
            System.out.println("=== MENU PLAYLIST MUSIK ===");
            System.out.println("==============================");
            System.out.println("1. Tampilkan semua lagu");
            System.out.println("2. Tambah lagu baru");
            System.out.println("3. Hapus lagu berdasarkan judul");
            System.out.println("4. Cari lagu berdasarkan judul");
            System.out.println("5. Urutkan berdasarkan durasi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu : ");
            try {
                pilihan = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                pilihan = 0;
            }

            switch (pilihan) {

                case 1:
                    pa.tampilkanSemuaLagu();
                    break;

                case 2:
                    pa.tambahLagu(scan);
                    break;

                case 3:
                    pa.hapusLagu(scan);
                    break;

                case 4:
                    pa.cariLagu(scan);
                    break;

                case 5:
                    pa.urutkanLaguBerdasarkanDurasi();
                    break;

                case 6:
                    System.out.println("\nTerima kasih telah menggunakan Playlist Musik.");
                    break;

                default:
                    System.out.println("\nMenu tidak tersedia.");
            }

        } while (pilihan != 6);

        scan.close();
    }
}
