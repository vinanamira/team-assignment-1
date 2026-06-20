public class Member extends User {
   public Member(String var1) {
      super(var1);
   }

   public void tampilkanAkses() {
      System.out.println("Member dapat melihat dan mencari lagu.");
   }

   public void lihatDaftarLagu(Lagu[] var1) {
      System.out.println("\n=== DAFTAR LAGU ===");

      for (Lagu var5 : var1) {
         if (var5 != null) {
            var5.tampilkanInfo();
            System.out.println("------------------");
         }
      }
   }

   public void cariLagu(Lagu[] var1, String var2) {
      boolean var3 = false;

      for (Lagu var7 : var1) {
         if (var7 != null && var7.getJudul().equalsIgnoreCase(var2)) {
            System.out.println("\nLagu ditemukan:");
            var7.tampilkanInfo();
            var3 = true;
            break;
         }
      }

      if (!var3) {
         System.out.println("\nLagu tidak ditemukan.");
      }
   }

   // Menghitung rata-rata durasi lagu dalam playlist
   public void hitungRataRataDurasi(Lagu[] playlist) {
      double totalDurasi = 0;
      int jumlahLagu = 0;

      for (Lagu lagu : playlist) {
         if (lagu != null) {
            totalDurasi += lagu.getDurasi();
            jumlahLagu++;
         }
      }

      if (jumlahLagu > 0) {
         double rataRata = totalDurasi / jumlahLagu;
         System.out.println("\nRata-rata durasi lagu: " + rataRata + " menit");
      } else {
         System.out.println("\nPlaylist kosong.");
      }
   }
}