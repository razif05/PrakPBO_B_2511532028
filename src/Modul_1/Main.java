package Modul_1;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<rekening> akunSaya = new ArrayList<>();
		rekening akunAktif = null;
		boolean isRunning = true;
		
		System.out.println("=== SISTEM PERBANKAN MINI ===");
		
		while (isRunning) {
			System.out.println("\n Menu Utama :");
			System.out.println("1. Buka Rekening Baru");
			System.out.println("2. Setor Tunai");
			System.out.println("3. Tarik TUnai");
			System.out.println("4. Cek Informasi Rekening");
			System.out.println("5. Ganti Akun");
			System.out.println("0. Keluar");
			System.out.print("Pilih Menu : ");
			
			int pilihan = input.nextInt();
			int noAkun = 0;
			input.nextLine();
			
			switch (pilihan) {
				case 1 :
					System.out.print("Masukkan No Rekening :");
					String no = input.nextLine();
					System.out.print("Masukkan Nama Pemilik : ");
					String nama = input.nextLine();
					System.out.print("Masukkan Saldo Awal : ");
					double saldo = input.nextDouble();
					
					akunSaya.add(new rekening(no,nama,saldo));
					akunAktif = akunSaya.get(noAkun);
					break;
				
				case 2:
					if (akunAktif == null) {
						System.out.println("Error : Mohon maaf, Anda belum memiliki nomor rekening!");
					} else {
						System.out.print("Masukkan nominal setor : ");
						double setor = input.nextDouble();
						akunAktif.setorTunai(setor);
					}
					break;
					
				case 3:
					if (akunAktif == null) {
						System.out.println("Error : Mohon maaf, Anda belum memiliki nomor rekening!");
					} else {
						System.out.print("Masukkan saldo yang di tarik : Rp");
						double nominal = input.nextDouble();
						akunAktif.tarikTunai(nominal);
					}
					break;
					
				case 4:
					if (akunAktif == null) {
						System.out.println("Error: Anda belum membuka rekening!");
					} else {
						akunAktif.cekInformasi();
					}
					break;
					
				case 5:
					System.out.print("Akun saat ini : " + akunAktif.getNama() + " - " + akunAktif.getNoRek()+ "\n");
					System.out.println("---------Daftar Akun---------");
					for (int i = 0; i < akunSaya.size(); i++) {
						System.out.print((i+1) + ". Nama Pemilik Akun	: " + akunSaya.get(i).namaPemilik + " - Nomor Rekening : " + akunSaya.get(i).getNoRek());
						System.out.println();
					}	
					System.out.print("Pilih Akun :");
					int pilihAkun = input.nextInt() - 1;
					noAkun = pilihAkun;
					akunAktif = akunAktif.gantiAkun(akunSaya, pilihAkun);
					break;
					
				case 0:
					isRunning =false;
					System.out.println("Sistem ditutup. Terimakasih");
					break;
					
				default:
					System.out.println("Pilihan tidak valid");
				
			}
		}

	}

}
