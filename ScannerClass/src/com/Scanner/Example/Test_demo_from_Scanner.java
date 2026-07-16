package com.Scanner.Example;
import java.net.URI;
import java.util.Scanner;

public class Test_demo_from_Scanner {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your name: ");
//		String value=input.next();
//		System.out.println(value);
		
		
		// first line method
		String firstinital=input.nextLine();
		String lastintial=input.nextLine();
		System.out.println("First name: "+firstinital+" last name: "+lastintial);
		// next intger
		System.out.println("Enter your house number: ");
		int num=input.nextInt();
		System.out.println("House number: "+num);
	}
}
