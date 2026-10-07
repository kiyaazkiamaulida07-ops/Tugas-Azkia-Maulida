public class RekeningBank {
    // Atribut (Enkapsulasi dengan 'private')
    private String noRekening;
    private String namaPemilik;
    private double saldo;

    // Static Variable untuk menghitung total rekening yang dibuat
    public static int totalRekening = 0;

    // Constructor dengan Validasi
    public RekeningBank(String noRekening, String namaPemilik, double saldoAwal) {
        this.noRekening = noRekening;
        this.namaPemilik = namaPemilik;

        // Validasi Saldo Awal Minimal Rp 50.000
        if (saldoAwal >= 50000) {
            this.saldo = saldoAwal;
        } else {
            System.out.println("[ERROR] Saldo awal untuk " + namaPemilik + " kurang dari Rp 50.000! Saldo di-set ke 0.");
            this.saldo = 0;
        }

        // Menambah jumlah total rekening yang dibuat
        totalRekening++;
    }

    // Getter untuk Saldo
    public double getSaldo() {
        return this.saldo;
    }

    // Setter untuk Saldo dengan Validasi
    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("[ERROR] Saldo tidak boleh negatif!");
        }
    }

    // Getter untuk Nama Pemilik & No Rekening (Opsional tapi berguna)
    public String getNamaPemilik() {
        return this.namaPemilik;
    }

    public String getNoRekening() {
        return this.noRekening;
    }

    // Method Bisnis: Transfer antar Rekening
    public void transfer(double nominal, RekeningBank tujuan) {
        if (nominal <= 0) {
            System.out.println("[ERROR] Nominal transfer harus lebih dari 0!");
            return;
        }

        if (this.saldo >= nominal) {
            this.saldo -= nominal;
            tujuan.saldo += nominal;
            System.out.println("Transfer berhasil! Rp " + nominal + " dikirim dari " + this.namaPemilik + " ke " + tujuan.getNamaPemilik());
        } else {
            System.out.println("[ERROR] Transfer Gagal! Saldo " + this.namaPemilik + " tidak mencukupi. (Saldo saat ini: Rp " + this.saldo + ")");
        }
    }
}