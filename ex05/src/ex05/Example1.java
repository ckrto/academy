package ex05;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		String name1 = "ȫ�浿";
		String name2 = "ȫ�浿";
		
		if(name1 == name2) {
			System.out.println("����� �ּҰ� ����.");
		} 
		else {
			System.out.println("����� �ּҰ� ���� �ʴ�.");
		}
		
		if(name1.equals(name2)) {
			System.out.println("����� ���� ����.");
		}
		else {
			System.out.println("����� ���� ���� �ʴ�.");
		}
		
		String name3 = "ȫ�浿";
		String name4 = "ȫ�浿";
		
		if(name3 == name4) {
			System.out.println("����� �ּҰ� ����.");
		} 
		else {
			System.out.println("����� �ּҰ� ���� �ʴ�.");
		}
		
		if(name3.equals(name4)) {
			System.out.println("����� ���� ����.");
		}
		else {
			System.out.println("����� ���� ���� �ʴ�.");
		}
	}
}
