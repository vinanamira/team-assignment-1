public class Admin extends User {

    public Admin(String nama) {
        super(nama);
    }

    // Override method dari User
    @Override
    public void tampilkanAkses() {
        System.out.println("Admin dapat menambahkan lagu dan melihat playlist.");
    }

    // Menambahkan lagu ke array playlist
    // Menambahkan lagu ke array playlist — otomatis pada posisi pertama kosong
    public void tambahLagu(Lagu[] playlist, Lagu lagu) {
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] == null) {
                playlist[i] = lagu;
                System.out.println("Lagu \"" + lagu.getJudul() + "\" berhasil ditambahkan pada posisi " + i + ".");
                return;
            }
        }
        System.out.println("Playlist penuh. Tidak dapat menambahkan lagu.");
    }
    // Menampilkan daftar lagu (Admin juga dapat melihat playlist)
    public void lihatDaftarLagu(Lagu[] playlist) {
        System.out.println("\n=== DAFTAR LAGU ===");
        for (Lagu lagu : playlist) {
            if (lagu != null) {
                lagu.tampilkanInfo();
                System.out.println("------------------");
            }
        }
    }
}