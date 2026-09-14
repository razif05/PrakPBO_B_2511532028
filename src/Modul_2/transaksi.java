package Modul_2;

public class transaksi {
	String idTransaksi;
	String jenis;
	double nominal;
	
	// constructor
	public transaksi(String id, String jenis, double nominal) {
		this.idTransaksi = id;
		this.jenis = jenis;
		this.nominal = nominal;
	}
	
	public String getId() {return this.idTransaksi;}
	public double getNominal() {return this.nominal;}
	
	public void cetakDetail() {
		System.out.println("ID : " + idTransaksi + " | Jenis : " + jenis + " | Nominal : Rp" + nominal);
	}
	
	public void totalTrx(String idTransaksi) {
		
	}
	

}
