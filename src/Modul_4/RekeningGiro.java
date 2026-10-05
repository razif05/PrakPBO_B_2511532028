package Modul_4;

public class RekeningGiro extends rekening{
	private double batasOverdraft;
	
	public RekeningGiro(String nomor, String nama, double saldoAwal, String pinAwal, double batasOverdraft) {
		super(nomor, nama, saldoAwal, pinAwal);
		this.batasOverdraft = batasOverdraft;
	}
	
	public double getBatasOverdraft() {
		return batasOverdraft;
	}

}
