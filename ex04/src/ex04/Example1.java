package ex04;

import java.util.Scanner;

public class Example1 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in); // �Է¹ޱ� ���� ����ϴ� Ŭ����
		
		String name; // �Է¹��� �̸��� �����ϱ� ���� name�̶�� string ���� ����
		String grade = ""; // ������ �����ϱ� ���� grade��� string ���� ����
		int kor = 0; // ���� ������ �����ϱ� ���� kor��� int ���� ���� �ʱⰪ�� 0���� ����
		int eng = 0; // ���� ������ �����ϱ� ���� kor��� int ���� ���� �ʱⰪ�� 0���� ����
		int mat = 0; // ���� ������ �����ϱ� ���� kor��� int ���� ���� �ʱⰪ�� 0���� ����
		int tot; // ���� ���� ���� ������ ���� �����ϱ� ���� int ���� ���� 
		double avg; // ���� ���� ���� ������ ���� ����� �����ϱ� ���� double ���� ����
		
		System.out.println("�ȳ��ϼ���. �������� �ý����Դϴ�.");
		System.out.println("********** ����ǥ **********\n");
		
		int sel; // ���α׷� ���� �� ���Ḧ ���� int ���� ����
		boolean run = true; // �ݺ����� ���� �� ���Ḧ ���� boolean ���� ����
		
		while(run) { // �ټ��� ���� �Է¹ް� �����ϱ� ���� while �ݺ��� ����
		
			System.out.print("����� 0, ����Ͻ÷��� 1�� �Է����ּ���. : "); // sel���� �Է¹ޱ� ���� ��¹�
			sel = sc.nextInt(); // ���� �� ����� ���� �Է¹޴� ����
			
			// ���α׷� ���� �� ������ ���� ���� if ���ǹ� ����
			if(sel == 0) { // ���α׷� ���� �� ���� ���� 0�� �� �Ʒ��� �ڵ� ����
				System.out.println("���α׷��� �����մϴ�."); // ���α׷� ���� �� ���� ���� 0�� �� ����ϴ� ��¹�
				run = false; // boolean�� ������ false�� �ٲ� �ݺ��� ����
			}
			else { // ���α׷� ���� �� ���� ���� 0�� �ƴ� �� �Ʒ��� �ڵ� ����

				System.out.print("�̸��� �Է����ּ��� : "); // name���� ����ڿ��� �Է¹ޱ� ���� ��¹�
				name = sc.next(); // ����ڿ��� �Է¹��� �̸��� name�� ����
		
				System.out.print("���� ������ �Է����ּ��� : "); // kor���� ����ڿ��� �Է¹ޱ� ���� ��¹�
				kor = sc.nextInt(); // ����ڿ��� �Է¹��� �̸��� kor�� ����
			
				System.out.print("���� ������ �Է����ּ��� : "); // eng���� ����ڿ��� �Է¹ޱ� ���� ��¹�
				eng = sc.nextInt(); // ����ڿ��� �Է¹��� �̸��� eng�� ����
				
				System.out.print("���� ������ �Է����ּ��� : "); // mat���� ����ڿ��� �Է¹ޱ� ���� ��¹�
				mat = sc.nextInt(); // ����ڿ��� �Է¹��� �̸��� mat�� ����
				
				System.out.println("----------------------------");
				
				tot = kor + eng + mat; // ������ ���ϱ� ���� ������ ����� kor, eng, mat�� ���� ��� ����
				System.out.println("������ : " + tot + "�� �Դϴ�."); // ����� tot ���� ���
				
				avg = tot / (double)3; // ����� ���ϱ� ���� ������ ����� ������ ������ ����ŭ ����
				System.out.println("����� : " + avg + "�� �Դϴ�."); // ����� avg ���� ���
				
				// ����� ���ϱ� ���� if ���ǹ� ����
				if(avg >= 95) { // 95�� �̻��϶� grade ��� ������ A+�� ����
					grade = "A+";
				}
				else if(avg >= 90) { // 95�� �̻��϶� grade ��� ������ A�� ����
					grade = "A";
				}
				else if(avg >= 85) { // 95�� �̻��϶� grade ��� ������ B+�� ����
					grade = "B+";
				}
				else if(avg >= 80) { // 95�� �̻��϶� grade ��� ������ B�� ����
					grade = "B";
				}
				else if(avg >= 75) { // 95�� �̻��϶� grade ��� ������ C+�� ����
					grade = "C+";
				}
				else if(avg >= 70) { // 95�� �̻��϶� grade ��� ������ C�� ����
					grade = "C";
				}
				else if(avg >= 65) { // 95�� �̻��϶� grade ��� ������ D+�� ����
					grade = "D+";
				}
				else if(avg >= 60) { // 95�� �̻��϶� grade ��� ������ D�� ����
					grade = "D";
				}
				else {
					grade = "F"; // 95�� �̻��϶� grade ��� ������ F�� ����
				}
				System.out.println("����� : " + grade + " �Դϴ�."); // ���� ���ǹ����� ����� grade ����� ���� ���
			}
		}	
	}
}

