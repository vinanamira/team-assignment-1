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

import java.util.Scanner;

public class PlaylistOOP {

    public static void main(String[] args) {
        Lagu[] playlist = new Lagu[10];
        Scanner scan = new Scanner(System.in);

        // Tambahkan 3 lagu default pada awal program
        Admin admin = new Admin("Andi");
        admin.tambahLagu(playlist, new Lagu("Hati-Hati di Jalan", "Tulus", 4.2));
        admin.tambahLagu(playlist, new Lagu("Monokrom", "Tulus", 3.5));
        admin.tambahLagu(playlist, new Lagu("Rumah Ke Rumah", "Hindia", 4.8));

        boolean keluarProgram = false;
        while (!keluarProgram) {
            System.out.println("\nPilih peran:\n1. Admin\n2. Member\n3. Keluar Program");
            System.out.print("Masukkan pilihan (1/2/3): ");
            String pilihan = scan.nextLine().trim();

            switch (pilihan) {
                case "1": {
                    System.out.println("Login sebagai Admin: " + admin.getNama());
                    admin.tampilkanAkses();

                    boolean kembali = false;
                    while (!kembali) {
                        System.out.println("\n=== Menu Admin ===");
                           System.out.println("1. Tambah lagu");
                           System.out.println("2. Hapus lagu berdasarkan judul");
                           System.out.println("3. Lihat daftar lagu");
                           System.out.println("4. Kembali ke pemilihan user");
                        System.out.print("Pilih: ");
                        String opsi = scan.nextLine().trim();

                        switch (opsi) {
                                case "1":
                                boolean adaSlot = false;
                                for (Lagu l : playlist) {
                                    if (l == null) { adaSlot = true; break; }
                                }
                                if (!adaSlot) {
                                    System.out.println("Playlist penuh. Tidak bisa menambahkan lagu.");
                                    break;
                                }

                                String opsinxt = "y";
                                while ("y".equalsIgnoreCase(opsinxt)) {
                                    System.out.print("Judul: ");
                                    String judul = scan.nextLine().trim();
                                    System.out.print("Artis: ");
                                    String artis = scan.nextLine().trim();
                                    double durasi = 0;
                                    try {
                                        System.out.print("Durasi (menit): ");
                                        durasi = Double.parseDouble(scan.nextLine().trim());
                                    } catch (Exception e) {
                                        System.out.println("Input durasi tidak valid. Batalkan penambahan.");
                                        break;
                                    }

                                    admin.tambahLagu(playlist, new Lagu(judul, artis, durasi));

                                    System.out.print("Tambah lagi? (y/n): ");
                                    opsinxt = scan.nextLine().trim();

                                    boolean masihKosong = false;
                                    for (Lagu l : playlist) {
                                        if (l == null) { masihKosong = true; break; }
                                    }
                                    if (!masihKosong) {
                                        System.out.println("Playlist sekarang penuh.");
                                        break;
                                    }
                                }
                                break;

                                case "2":
                                    System.out.print("Masukkan judul lagu yang ingin dihapus: ");
                                    String judulHapus = scan.nextLine().trim();
                                    admin.hapusLagu(playlist, judulHapus);
                                    break;

                                case "3":
                                    admin.lihatDaftarLagu(playlist);
                                    break;

                                case "4":
                                    kembali = true;
                                    break;

                            default:
                                System.out.println("Pilihan tidak dikenal.");
                        }

                    }
                    break;
                }

                case "2": {
                    Member member = new Member("Budi");
                    System.out.println("Login sebagai Member: " + member.getNama());
                    member.tampilkanAkses();

                    boolean kembali = false;
                    while (!kembali) {
                        System.out.println("\n=== Menu Member ===");
                        System.out.println("1. Lihat daftar lagu");
                        System.out.println("2. Cari lagu berdasarkan judul");
                        System.out.println("3. Hitung rata-rata durasi");
                        System.out.println("4. Kembali ke pemilihan user");
                        System.out.print("Pilih: ");
                        String opsi = scan.nextLine().trim();

                        switch (opsi) {
                            case "1":
                                member.lihatDaftarLagu(playlist);
                                break;
                            case "2":
                                System.out.print("Masukkan judul lagu yang dicari: ");
                                String judulCari = scan.nextLine().trim();
                                member.cariLagu(playlist, judulCari);
                                break;
                            case "3":
                                member.hitungRataRataDurasi(playlist);
                                break;
                            case "4":
                                kembali = true;
                                break;
                            default:
                                System.out.println("Pilihan tidak dikenal.");
                        }
                    }
                    break;
                }

                case "3":
                    keluarProgram = true;
                    break;

                default:
                    System.out.println("Pilihan tidak dikenal. Coba lagi.");
            }
        }

        scan.close();
        System.out.println("Program selesai.");
    }
}