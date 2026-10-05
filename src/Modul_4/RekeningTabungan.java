package Modul_4;

public class RekeningTabungan extends rekening {

	private double sukuBunga;
	
	public RekeningTabungan(String nomor, String nama, double saldoAwal, String pinAwal, double sukuBunga) {
		
		super(nomor, nama, saldoAwal, pinAwal);
		this.sukuBunga = sukuBunga;
	}


	public void tambahBungaAkhirBulan() {
		double nominalBunga = saldo * (sukuBunga / 100);
		saldo += nominalBunga;
	
		String idTrx = "TRX-B-" + System.currentTimeMillis();
		riwayatTransaksi.add(new transaksi(idTrx, "Bunga", nominalBunga));
		
		System.out.println("Bunga " + sukuBunga + "% berhasil ditambahkan: Rp" + nominalBunga);
	}
	
}