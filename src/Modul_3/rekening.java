package Modul_3;

import java.util.ArrayList;

public class rekening {
	private String nomorRekening;
	private String namaPemilik;
	private double totalSetor;
	private double totalTarik;
	private double saldo;
	private String pinbaru;
	private String pinLama;
	
	ArrayList<transaksi> riwayatTransaksi;
	
	
	public rekening(String nomor, String nama, double saldoAwal, String pinAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;	
		
		if (pinAwal.length() == 6) {
			this.pinbaru = pinAwal;
			this.pinLama = pinAwal;
		} else {
			System.out.println("Peringatan: PIN harus berisikan 6 digit! menggunakan PIN default 123456");
			this.pinbaru = "123456";
		}
		
		this.riwayatTransaksi = new ArrayList<>();
		
		System.out.println("Rekening atas nama : " + namaPemilik + " Berhasil dibuat dengan saldo Rp" + saldo);
	}
	
	public String getNoRek() {return nomorRekening;}
	public String getNama() {return namaPemilik;}
		
	public rekening gantiAkun(ArrayList<rekening> daftar, int index) {
		if (index >= 0 && index < daftar.size()) {
            System.out.println("Berhasil pindah ke akun: " + daftar.get(index).getNama());
            return daftar.get(index);
        } else {
            System.out.println("Gagal: akun tidak ditemukan!");
            return null;
        }
	}
	
	public void setorTunai(double nominal) {
		if (nominal > 0) {
			saldo += nominal;
			String idTrx = "TRX-S-" + System.currentTimeMillis();
			transaksi trxBaru = new transaksi(idTrx, "Kredit", nominal);
			riwayatTransaksi.add(trxBaru);
			
			System.out.println("Setor tunai Rp" + nominal + " berhasil. saldo saat ini Rp" + saldo);
		} else {
			System.out.println("Gagal: nominal setor harus lebih dari 0!");
		}
	}
	
	public void cekInformasi() {
		System.out.println("--- INFO REKENING ---");
		System.out.println("No. Rekening	: " + nomorRekening);
		System.out.println("Nama Pemilik	: " + namaPemilik);
		System.out.println("Saldo Akhir	: Rp" + saldo);
		System.out.println("---------------------");
	}
	
	public void tarikTunai(double nominal) {
		if (saldo <= 10000) {
			System.out.println("Saldo Anda tidak mencukupi untuk menarik tunai anda!");
		} else {
			if (nominal >= saldo) {
				System.out.println("Saldo Anda tidak Cukup!");
			} else {
				saldo -= nominal;
				String idTrx = "TRX-T-" + System.currentTimeMillis();
				transaksi trxBaru = new transaksi(idTrx, "Dedit", nominal);
				riwayatTransaksi.add(trxBaru);
				
				System.out.println("Saldo Anda saat ini : Rp" + saldo);
			}
		}
	}
	
	public void totalTrx() {
		for(int i = 0; i < riwayatTransaksi.size(); i++) {
			riwayatTransaksi.get(i).getId();
			if(riwayatTransaksi.get(i).getId().contains("TRX-S")) {
				this.totalSetor += riwayatTransaksi.get(i).getNominal();
			} else {
				this.totalTarik += riwayatTransaksi.get(i).getNominal();
			}
			System.out.println("Total Setor : " + totalSetor);
			System.out.println("Total Tarik : " + totalTarik);
		}	
	}
	
	public void cetakMutasi() {
		System.out.println("-------Riwayat Transaksi-------");
		int start = 0;
		if (riwayatTransaksi.size() > 3)
			start = riwayatTransaksi.size() - 3;
		
		for (int i = start; i < riwayatTransaksi.size(); i++)
			riwayatTransaksi.get(i).cetakDetail();
	}
	
	public boolean otentikasi(String inputPin) {
		return this.pinbaru.equals(inputPin);
	}
	
	public void gantiPIN(String PIN) {
		this.pinLama = pinbaru;
		if(PIN.equals(pinLama)) {
			System.out.println("PIN sudah di pernah di pake!");
		} else {
			this.pinbaru = PIN;
		}
	}

}
