package ex16;

import java.util.Scanner;

public class Input {
	public static int input(String title) {
		Scanner s=new Scanner(System.in);
		String value="";
		boolean isNumber=false;
		do {
			System.out.print(title);
			value=s.nextLine();
			isNumber=value.matches("-?\\d+(\\.\\d+)?");
			if(isNumber==false) System.out.println("���ڷ��Է��ϼ���!");
		}while(isNumber==false);
		
		return Integer.parseInt(value);
	}
}
