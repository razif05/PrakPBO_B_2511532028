package Modul_1;

import java.util.ArrayList;

public class rekening {

	String nomorRekening;
	String namaPemilik;
	double saldo;
	
	public rekening(String nomor, String nama, double saldoAwal) {
		nomorRekening = nomor;
		namaPemilik = nama;
		saldo = saldoAwal;	
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
		System.out.println("Setor tunai Rp" + nominal + "berhasil. saldo saat ini Rp" + saldo);
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
				System.out.println("Saldo Anda saat ini : Rp" + saldo);
			}
		}
	}

}
