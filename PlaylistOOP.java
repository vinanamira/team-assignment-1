/*
Nama Kelompok 2:
1. AHMAD WIDAD IZZUDDIN - 2902795331
2. ELVIA DESTIANI - 2902801265
3. MUHAMMAD ZIKRI - 2902794266
4. TIARA ANDINA DALIMUNTHE - 2902772063
5. VINA NAMIRA ANDRINA ANDIDI - 2902789202

Tugas Kelompok 1
Introduction to OOP & Data Structures
*/

public class PlaylistOOP {

    public static void main(String[] args) {

        // Array untuk menyimpan objek Lagu
        Lagu[] playlist = new Lagu[10];

        // Membuat objek Admin dan Member
        Admin admin = new Admin("Andi");
        Member member = new Member("Budi");

        /*
         * Menampilkan hak akses masing-masing user
         * (Polymorphism)
         */
        System.out.println("=== HAK AKSES ===");
        admin.tampilkanAkses();
        member.tampilkanAkses();

        /*
         * Admin menambahkan lagu ke playlist
         */
        admin.tambahLagu(
            playlist,
            new Lagu("Hati-Hati di Jalan", "Tulus", 4.2),
            0
        );

        admin.tambahLagu(
            playlist,
            new Lagu("Monokrom", "Tulus", 3.5),
            1
        );

        admin.tambahLagu(
            playlist,
            new Lagu("Rumah Ke Rumah", "Hindia", 4.8),
            2
        );

        /*
         * Member melihat seluruh lagu
         */
        member.lihatDaftarLagu(playlist);

        /*
         * Member mencari lagu berdasarkan judul
         */
        member.cariLagu(playlist, "Monokrom");

        /*
         * Member menghitung rata-rata durasi lagu dalam playlist
         */
        member.hitungRataRataDurasi(playlist);
    }
}