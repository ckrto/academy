package ex15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Example1.execute();

	}
	
	//�����Է¹ޱ�
	public static int input(String title) {
		Scanner s=new Scanner(System.in);
		String value="";
		boolean isNumber=false;
		do {
			System.out.print(title + ">");
			value=s.nextLine();
			isNumber=value.matches("-?\\d+(\\.\\d+)?");
			if(isNumber==false) System.out.println("���ڷ��Է��ϼ���!");
		}while(isNumber==false);
		
		return Integer.parseInt(value);
	}
}
