package ex03;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ȳ��ϼ��� �������� �ý����Դϴ�.\n");
		
		System.out.println("���� ������ �Է����ּ���.");
		int kor = sc.nextInt();
		
		System.out.println("���� ������ �Է����ּ���.");
		int eng = sc.nextInt();
		
		System.out.println("���� ������ �Է����ּ���.");
		int mat = sc.nextInt();
		
		double avg = (kor + mat + eng) / 3.;
		
		System.out.println("---------------------------------");
		System.out.println("����� : " + avg + " �Դϴ�.");
		
		if(avg >= 95) {
			System.out.println("����� : A+ �Դϴ�.");
			System.out.println("�Ϻ��մϴ�!!");
		}
		else if(avg >= 90) {
			System.out.println("����� : A �Դϴ�.");
			System.out.println("�Ǹ��մϴ�!!");
		}
		else if(avg >= 85) {
			System.out.println("����� : B+ �Դϴ�.");
			System.out.println("����մϴ�!!");
		}
		else if(avg >= 80) {
			System.out.println("����� : B �Դϴ�.");
			System.out.println("���߽��ϴ�!!");
		}
		else if(avg >= 75) {
			System.out.println("����� : C+ �Դϴ�.");
			System.out.println("�ƽ����ϴ� ������ּ���!!");
		}
		else if(avg >= 70) {
			System.out.println("����� : C �Դϴ�.");
			System.out.println("�� ������ּ���!!");
		}
		else if(avg >= 65) {
			System.out.println("����� : D+ �Դϴ�.");
			System.out.println("������ ������ Ȯ���� ���ּ���!!");
		}
		else if(avg >= 60) {
			System.out.println("����� : D �Դϴ�.");
			System.out.println("���ʸ� �ٽ� �ѹ� �����ּ���!!");
		}
		else {
			System.out.println("����� : F �Դϴ�.");
			System.out.println("����� �� ���� ����� ���ּ���!!");
		}		
	}
}
