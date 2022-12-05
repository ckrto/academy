package ex05;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		DecimalFormat df = new DecimalFormat("###.00");
		Scanner sc = new Scanner(System.in);
		
		String[] name = new String[100];
		String[] sub = {"����", "����", "����"};
		String search = "";
		String subject = "";
		int[] kor = new int[100];
		int[] eng = new int[100];
		int[] mat = new int[100];
		int cnt = 0;
		int tot = 0;
		int sel = 0;
		double avg;
		boolean run = true;
		boolean searchCheck = false;
		boolean subjectCheck = false;
		
		while(run) {
			
			System.out.println("�ȳ��ϼ��� ���� ���� �ý��� �Դϴ�. �Ʒ��� �۾��� �� ���Ͻô� �۾��� �������ּ���");
			System.out.println("---------------------------------------------------");
			System.out.println("1.�����Է� | 2.�����˻� | 3.�������� | 4.����ǥ��� | 0.����");
			System.out.println("---------------------------------------------------");
			System.out.print("������ �۾� : ");
			sel = sc.nextInt();
			System.out.print("\n");
			
			
			
			switch(sel) {
			case 1 :
				System.out.print("�Է��� �л� ���� �Է����ּ��� : ");
				cnt = sc.nextInt();
				
				for(int i = 0; i < cnt; i++) {
					System.out.print("�̸��� �Է����ּ��� : ");
					name[i] = sc.next();
				}
				System.out.print("\n");
			
				for(int i = 0; i < cnt; i++) {
					System.out.print(name[i] + "�� ���� ������ �Է����ּ��� : ");
					kor[i] = sc.nextInt();
				}
				System.out.print("\n");
			
				for(int i = 0; i < cnt; i++) {
					System.out.print(name[i] + "�� ���� ������ �Է����ּ��� : ");
					eng[i] = sc.nextInt();
				}
				System.out.print("\n");
			
				for(int i = 0; i < cnt; i++) {
					System.out.print(name[i] + "�� ���� ������ �Է����ּ��� : ");
					mat[i] = sc.nextInt();
				}
				System.out.print("\n");
				break;
				
			case 2 : 
				System.out.print("�̸��� �Է����ּ��� : ");
				search = sc.next();
				System.out.print("\n");
				
				for(int i = 0; i < cnt; i++) {
					if(search.equals(name[i])) {
						searchCheck = true;
						
						System.out.print("�˻��Ͻ� ������ �̸��� �Է����ּ��� : ");
						subject = sc.next();
						
						if(subject.equals(sub[0])) {
							subjectCheck = true;
							System.out.println(search +"���� " + sub[0] + " ������ " + kor[i] + "�Դϴ�." + "\n");
						}
						else if(subject.equals(sub[1])) {
							subjectCheck = true;
							System.out.println(search +"���� " + sub[1] + " ������ " + eng[i] + "�Դϴ�." + "\n");
						}
						else if(subject.equals(sub[2])) {
							subjectCheck = true;
							System.out.println(search +"���� " + sub[2] + " ������ " + mat[i] + "�Դϴ�." + "\n");
						}
					}
					else if(!search.equals(name[i]) && !subject.equals(sub[i])) {
						searchCheck = false;
					}
				}
				if(searchCheck == false) {	
					System.out.println("�׷� �̸��� �������� �ʽ��ϴ�.\n");
				}
				break;
				
			case 3:
				System.out.print("�̸��� �Է����ּ��� : ");
				search = sc.next();
				System.out.print("������ �����Ͻ� ������ �Է����ּ��� : ");
				subject = sc.next();
				
				for(int i = 0; i < cnt; i++) {
					if(search.equals(name[i])) {
						searchCheck = true;
						if(subject.equals(sub[0])) {
							subjectCheck = true;
							System.out.print(name[i] + "���� �����Ͻ� ���� ������ �Է����ּ��� : \n");
							kor[i] = sc.nextInt();
							System.out.println(search +"���� �����Ͻ� " + sub[0] + " ������ " + kor[i] + "�Դϴ�." + "\n");
						}
						else if(subject.equals(sub[1])) {
							subjectCheck = true;
							System.out.print(name[i] + "���� �����Ͻ� ���� ������ �Է����ּ��� : ");
							eng[i] = sc.nextInt();
							System.out.println(search +"���� �����Ͻ� " + sub[1] + " ������ " + eng[i] + "�Դϴ�." + "\n");
						}
						else if(subject.equals(sub[2])) {
							subjectCheck = true;
							System.out.print(name[i] + "���� �����Ͻ� ���� ������ �Է����ּ��� : ");
							mat[i] = sc.nextInt();
							System.out.println(search +"���� �����Ͻ�" + sub[2] + " ������ " + mat[i] + "�Դϴ�." + "\n");
						}
					}
					else if(!search.equals(name[i]) && !subject.equals(sub[i])) {
						searchCheck = false;
					}
				}
				if(searchCheck == false) {	
					System.out.println("�׷� �̸��� �������� �ʽ��ϴ�.\n");
				}
				break;
				
			case 4 : 
				System.out.print("�̸��� �Է����ּ��� : ");
				search = sc.next();
				System.out.print("\n");
				
				for(int i = 0; i < cnt; i++) {
					if(search.equals(name[i])) {
						tot = kor[i] + eng[i] + mat[i];
						avg = tot / (double) 3;
						
						System.out.println(search + " ���� ���� ����ǥ�� �Ʒ��� �����ϴ�.");
						System.out.println("�̸�\t����\t����\t����\t����\t���");
						
						System.out.print(name[i] + "\t");
						System.out.print(kor[i] + "\t");
						System.out.print(eng[i] + "\t");
						System.out.print(mat[i] + "\t");
						System.out.print(tot + "\t");
						System.out.println(df.format(avg) + "\n");
					}
					else if(!search.equals(name[i]) && !subject.equals(sub[i])) {
						searchCheck = false;
					}
				}
				if(searchCheck == false) {	
					System.out.println("�׷� �̸��� �������� �ʽ��ϴ�.\n");
				}
				break;
				
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
				
			default :
				System.out.println("�޴��� �ٽ� �������ּ���.\n");
			}
		}
	}
}
