package ex03;

import java.util.Scanner;

public class Repeat {
	public static void execute() {
		// �ݺ��� (for)
		System.out.println("---------- �ݺ��� (for) ----------");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ȳ��ϼ���. n ~ 100������ ���ڸ� ���ϴ� �ý����Դϴ�.");
		System.out.println("1 ~ 100������ ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		int sum = 0;
		for(int i = num; i <= 100; i++) {
			sum += i; 
		}
		System.out.println(num + " ~ 100������ �� = " + sum);
		
		int tot = 0;
		for(int i = 2; i <= 100; i=i+2) {
			tot += i; 
		}
		System.out.println("2 ~ 100������ ¦���� �� = " + tot);
		
		tot = 0;
		for(int i = 1; i <= 100; i = i+2) {
			tot += i;
		}
		System.out.println("1 ~ 100������ Ȧ���� �� = " + tot + "\n");
		
		// �ݺ��� (while)
		System.out.println("---------- �ݺ��� (while) ----------");
		
		int i = 1;
		sum = 0;
		while(i <= 100) {
			sum = sum + i;
			i = i + 1;
		}
		System.out.println("1 ~ 100������ �� = " + sum);
		
		sum = 0;
		i = 2;
		while(i <= 100) {
			sum = sum + i;
			i = i + 2;
		}
		System.out.println("2 ~ 100������ ¦���� �� = " + sum);
		
		sum = 0;
		i = 1;
		while(i <= 100) {
			sum = sum + i;
			i = i + 2;
		}
		System.out.println("1 ~ 100������ Ȧ���� �� = " + sum);
	}	
}