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

    // Hapus lagu berdasarkan judul dan geser elemen agar rapi
    public boolean hapusLagu(Lagu[] playlist, String judul) {
        if (judul == null || judul.trim().isEmpty()) return false;
        int foundIdx = -1;
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i] != null && playlist[i].getJudul().equalsIgnoreCase(judul.trim())) {
                foundIdx = i;
                break;
            }
        }
        if (foundIdx == -1) {
            System.out.println("Lagu dengan judul \"" + judul + "\" tidak ditemukan.");
            return false;
        }

        // Geser left semua elemen setelah foundIdx
        for (int i = foundIdx; i < playlist.length - 1; i++) {
            playlist[i] = playlist[i + 1];
        }
        // Kosongkan slot terakhir
        playlist[playlist.length - 1] = null;
        System.out.println("Lagu \"" + judul + "\" berhasil dihapus.");
        return true;
    }
}