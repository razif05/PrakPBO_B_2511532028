package Modul_5;

public class RekeningGiro extends rekening{
	private double batasOverdraft;
	
	public RekeningGiro(String nomor, String nama, double saldoAwal, String pinAwal, double batasOverdraft) {
		super(nomor, nama, saldoAwal, pinAwal);
		this.batasOverdraft = batasOverdraft;
	}
	
	@Override
	public boolean tarikTunai(double nominal) {
		if(saldo <= 10000) {
			System.out.println("Gagal: saldo harus lebih dari 10000!");
			return false;
		} else if(nominal <= 0) {
			System.out.println("Gagal: nominal harus lebih dari 0!");
			return false;
		} else if(nominal > (saldo + batasOverdraft)) {
			System.out.println("Transaksi Gagal: Melebihi batas overdraft! Maksimal penarikan: Rp" 
		+ (saldo + batasOverdraft));
			return false;
		} else {
			saldo -= nominal;
			
			String idTrx = "TRX-G-" + System.currentTimeMillis();
			transaksi trxBaru = new transaksi(idTrx, "Debit Giro", nominal);
			riwayatTransaksi.add(trxBaru);
				
			System.out.println("Tarik tunai Giro Rp" + nominal + " berhasil. Saldo saat ini Rp" + saldo);
			return true;
		}
	}
	
	public double getBatasOverdraft() {
		return batasOverdraft;
	}

}
