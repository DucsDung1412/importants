package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class testDate {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		
		Date d = new Date(System.currentTimeMillis());
		System.out.println(d); //Thay doi theo ngay tren may tinh
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("dd/MM/yyyy");
		String sa = sdf.format(d);
		System.out.println(sa);
	}
}
