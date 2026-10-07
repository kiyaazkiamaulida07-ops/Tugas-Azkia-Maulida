public class MainBank {
    public static void main(String[] args) {
        System.out.println("=== SISTEM INFORMASI REKENING BANK ===");

        // 1. Buat 2 Objek Rekening
        RekeningBank rek1 = new RekeningBank("101", "Budi", 500000);
        RekeningBank rek2 = new RekeningBank("102", "Siti", 200000);

        System.out.println("\n--- Saldo Awal ---");
        System.out.println("Saldo " + rek1.getNamaPemilik() + ": Rp " + rek1.getSaldo());
        System.out.println("Saldo " + rek2.getNamaPemilik() + ": Rp " + rek2.getSaldo());

        // 2. Akses Static Variable totalRekening
        System.out.println("\nTotal rekening terdaftar saat ini: " + RekeningBank.totalRekening);

        // 3. Skenario Sukses: Transfer dari rek1 (Budi) ke rek2 (Siti)
        System.out.println("\n--- Percobaan Transfer Berhasil ---");
        rek1.transfer(150000, rek2);

        // Cetak Saldo Akhir
        System.out.println("\n--- Saldo Setelah Transfer ---");
        System.out.println("Saldo " + rek1.getNamaPemilik() + ": Rp " + rek1.getSaldo());
        System.out.println("Saldo " + rek2.getNamaPemilik() + ": Rp " + rek2.getSaldo());

        // 4. Skenario Validasi Error: Transfer Melebihi Saldo
        System.out.println("\n--- Percobaan Transfer Melebihi Saldo (Validasi Error) ---");
        rek1.transfer(1000000, rek2); // Mengirim Rp 1.000.000 padahal saldo Budi sisa 350.000

        // Cetak Saldo Akhir Setelah Percobaan Gagal
        System.out.println("\n--- Saldo Akhir ---");
        System.out.println("Saldo " + rek1.getNamaPemilik() + ": Rp " + rek1.getSaldo());
        System.out.println("Saldo " + rek2.getNamaPemilik() + ": Rp " + rek2.getSaldo());
    }
}