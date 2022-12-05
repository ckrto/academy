package ex06;

import java.util.ArrayList;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Grade> grades = new ArrayList<>();
		
		String name;
		String nname;
		String dname;
		String uname;
		String kor;
		String eng;
		String mat;
		String sel;
		
		int menu;
		
		boolean find = false;
		boolean run = true;
		
		Grade grade = new Grade("ȫ�浿", 99, 95, 97);
		grades.add(grade);
		
		grade = new Grade("��û��", 89, 88, 79);
		grades.add(grade);
		
		System.out.println("�ȳ��ϼ��� ���� ���� �ý����Դϴ�.");
		
		while(run) {
			System.out.println("�Ʒ��� �׸� �� �Ѱ����� �������ּ���.");
			System.out.println("-------------------------------");
			System.out.println("1.��� | 2.�˻� | 3.��� | 4.���� | 5.���� | 0.����");
			System.out.println("-------------------------------");
			System.out.print("������ �׸� : ");
			menu = sc.nextInt(); sc.nextLine();
			
			System.out.println("");
			
			switch(menu) {
			case 1 :
				System.out.println("�ȳ��ϼ���. ����� ��� ���Դϴ�.");
				System.out.print("�̸��� �Է����ּ��� : ");
				name = sc.nextLine();
				
				System.out.print("���� ������ �Է����ּ���. : ");
				kor = sc.nextLine();
				
				System.out.print("���� ������ �Է����ּ���. : ");
				eng = sc.nextLine();
				
				System.out.print("���� ������ �Է����ּ���. : ");
				mat = sc.nextLine();
				
				grade = new Grade(name, Integer.parseInt(kor), Integer.parseInt(eng), Integer.parseInt(mat));
				grades.add(grade);
				
				System.out.println("��ϵ� ������� ���� " + grades.size() + "�� �Դϴ�. \n");
				break;
			case 2 :
				find = false;
				System.out.println("�ȳ��ϼ���. ����� �˻� ���Դϴ�.");
				System.out.println("�ȳ��ϼ���. ����� �˻� ���Դϴ�.");
				System.out.print("�˻��Ͻ� ������� �̸��� �Է��ϼ��� : ");
				nname = sc.next(); sc.nextLine();
				
				for(Grade g:grades) {
					if(nname.equals(g.name)) {
						find = true;
						g.print();
						System.out.println("");
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.");
				}
				break;
			case 3 : 
				System.out.println("�̸�\t����\t����\t����\t����\t���");
				for(Grade g:grades) {
					g.printList();
				}
				System.out.println("");
				break;
			case 4 :
				find = false;
				System.out.print("������ �̸��� �Է����ּ��� : ");
				dname = sc.nextLine();
				System.out.println("");
				
				for(Grade g:grades) {
					if(dname.equals(g.name)) {
						find = true;
						g.print();
						System.out.println("");
						System.out.print("��¥�� �����Ͻǰǰ���(�� : Y, �ƴϿ� : N)?");
						sel = sc.nextLine();
						
						if(sel.equals("Y") || sel.equals("y")) {
							grades.remove(g);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
							break;
						}
						if(sel.equals("N") || sel.equals("n")) {
							System.out.println("������ ����߽��ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.\n");
				}
				break;
			case 5 :
				find = false;
				System.out.print("�����Ͻ� �̸��� �Է����ּ��� : ");
				uname = sc.nextLine();
				for(Grade g:grades) {
					if(uname.equals(g.name)) {
						find = true;
						
						System.out.print("������� �̸��� " + g.name + " �Դϴ�. �����Ͻ� �̸��� �Է����ּ��� : ");
						name = sc.nextLine();
						
						System.out.print(g.name + "���� ���� ������ " + g.kor + " �Դϴ�. �����Ͻ� ���� ������ �Է����ּ��� : ");
						kor = sc.nextLine();
						
						System.out.print(g.name + "���� ���� ������ " + g.eng + " �Դϴ�. �����Ͻ� ���� ������ �Է����ּ��� : ");
						eng = sc.nextLine();
						
						System.out.print(g.name + "���� ���� ������ " + g.mat + " �Դϴ�. �����Ͻ� ���� ������ �Է����ּ��� : ");
						mat = sc.nextLine();
						
						System.out.print("�����Ͻðڽ��ϱ�(�� : Y, �ƴϿ� : N)?");
						sel = sc.nextLine();
						
						System.out.println("");
						
						if(sel.equals("Y") || sel.equals("y")) {
							if(!name.equals("")) {
								g.name = name;
							}
							if(!kor.equals("")) {
								g.kor = Integer.parseInt(kor);
							}
							if(!eng.equals("")) {
								g.eng = Integer.parseInt(eng);
							}
							if(!mat.equals("")) {
								g.mat = Integer.parseInt(mat);
							}
							
							System.out.println("------���� ���------");
							g.print();
							System.out.println("������ �Ϸ�Ǿ����ϴ�.");
							System.out.println("");
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.\n");
				}
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���.");
				break;
			}
		}
	}
}
