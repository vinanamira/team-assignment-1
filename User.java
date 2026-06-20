public class User {
    private String nama;

    public User(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method untuk polymorphism
    public void tampilkanAkses() {
        System.out.println("User memiliki akses dasar.");
    }
}