package hcmus.edu.vn.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import hcmus.edu.vn.io.SerializeFileFactory;
import hcmus.edu.vn.model.KhachHang;

public class TestKhachHang {
	static ArrayList<KhachHang>dsKH = new ArrayList<KhachHang>();
	public static void menu()
	{
		System.out.println("1.Nhap Khach Hang moi");
		System.out.println("2.Xuat Khach Hang");
		System.out.println("3.Tim Kiem Khach Hang");
		System.out.println("4.Sap Xep Khach Hang");
		System.out.println("5.Luu Khach Hang");
		System.out.println("6.Doc Khach Hang");
		System.out.println("7.Thong Ke Theo Nha Mang");
		System.out.println("8.Thoat");
		int chon=0;
		System.out.println("Chon 1 chuc nang: ");
		chon = new Scanner(System.in).nextInt();
		switch(chon)
		{
		case 1:
			xuLyNhap();
			break;
		case 2:
			xuLyXuat();
			break;
		case 3:
			xuLyTim();
			break;
		case 4:
			xuLySapXep();
			break;
		case 5:
			xuLyLuu();
			break;
		case 6:
			xuLyDoc();
			break;
		case 7:
			xuLyThongKe();
			break;
		case 8:
			xuLyThoat();
			break;
		default:
			
			break;	
		}
	}
	private static void xuLyThoat() {
		System.out.println("Cam on ban da su dung!");
		System.exit(0);
	}
	private static void xuLyThongKe() {
		int n=0;
		for(KhachHang kh: dsKH)
		{
			if(kh.getPhone().startsWith("098"))
			{
				n++;
			}
		}
		System.out.println("Có "+n+" khách hàng Viettel");		
	}
	private static void xuLyDoc() {
		dsKH=SerializeFileFactory.docFile("D:\\dulieukhachhang.txt");
		System.out.println("Da doc file thanh cong!");
	}
	private static void xuLyLuu() {
		boolean kt=SerializeFileFactory.luuFile(dsKH, "D:\\dulieukhachhang.txt");
		if(kt==true)
		{
			System.out.println("Da luu file thanh cong!");
		}
		else
		{
			System.out.println("Luu file that bai!");
		}
	}
	private static void xuLySapXep() {
		Collections.sort(dsKH);
		System.out.println("Đã sắp xếp số điện thoại xong rồi");	
	}
	private static void xuLyTim() {
		String phone="090";
		System.out.println("===============================");
		System.out.println("Khách hàng có đầu số 090:");
		System.out.println("Mã\tTên\tPhone");
		for(KhachHang kh: dsKH)
		{
			if(kh.getPhone().startsWith(phone))
			{
				System.out.println(kh);
			}
		}
		System.out.println("===============================");		
	}
	private static void xuLyXuat() {
		System.out.println("====================================");
		System.out.println("Ma\tTen\tPhone");
		for(KhachHang kh:dsKH)
			{
				System.out.println(kh);
			}
		System.out.println("====================================");
	}
	private static void xuLyNhap() {
		KhachHang kh = new KhachHang();
		System.out.println("Moi ban nhap ma: ");
		int ma = new Scanner(System.in).nextInt();
		System.out.println("Moi ban nhao ten: ");
		String ten = new Scanner(System.in).nextLine();
		System.out.println("Moi ban nhao so phone: ");
		String phone = new Scanner(System.in).nextLine();

		kh.setMa(ma);
		kh.setTen(ten);
		kh.setPhone(phone);
		
		dsKH.add(kh);
	}
	public static void main(String[] args) {
		while(true)
		{
			menu();
		}
	}

}
