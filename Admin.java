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
    public void tambahLagu(Lagu[] playlist, Lagu lagu, int index) {
        if (index >= 0 && index < playlist.length) {
            playlist[index] = lagu;
            System.out.println("Lagu berhasil ditambahkan.");
        } else {
            System.out.println("Posisi penyimpanan tidak valid.");
        }
    }
}