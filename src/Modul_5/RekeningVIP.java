package Modul_5;

public class RekeningVIP extends rekening {
	private double bonus;
	
	public RekeningVIP(String no, String nama, double saldoAwal, String pinAwal) {
		super(no, nama, saldoAwal, pinAwal);
		this.bonus = 100000;
		this.saldo += bonus;
	}

}
