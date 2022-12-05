package ex07;

import java.util.ArrayList;
import java.util.Scanner;

public class Example5 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		
		String sel;
		String uname;
		String utel;
		String ujuso;
		
		
		int no;
		int sno;
		int dno;
		int uno;
		int menu;
		
		ArrayList<Address> array = new ArrayList<>();
		
		no = 10;
		Address a = new Address();
		a.setNo(no);
		a.setName("ȫ�浿");
		a.setTel("010-0001-0001");
		a.setJuso("��õ ���� �漭��");
		array.add(a);
		
		no = no + 1;
		a = new Address();
		a.setNo(no);
		a.setName("��û��");
		a.setTel("010-0002-0002");
		a.setJuso("���� ������ �б�����");
		array.add(a);
		
		no = no + 1;
		a = new Address();
		a.setNo(no);
		a.setName("ȫ�浿");
		a.setTel("010-0003-0003");
		a.setJuso("��õ ���� ��굿");
		array.add(a);
		
		boolean find = true;
		boolean run = true;
		
		while(run) {
			System.out.println("�ȳ��ϼ���. ����� ���� ���� �ý����Դϴ�. �Ʒ� �׸� �� �������ּ���.");
			System.out.println("------------------------------------------------");
			System.out.println("1.��� | 2.�˻� | 3.���� | 4.���� | 5.��� | 0.����");
			System.out.println("------------------------------------------------");
			System.out.print("�������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(menu) {
			case 1 :
				System.out.println("�ȳ��ϼ��� ����� ��� ���Դϴ�.");
				
				no = no + 1;
				a = new Address();
				System.out.println("��ȣ : " + no);
				a.setNo(no);
				
				System.out.print("�̸��� �Է����ּ��� : ");
				a.setName(sc.nextLine());
				
				System.out.print("��ȭ��ȣ�� �Է����ּ��� : ");
				a.setTel(sc.nextLine());
				
				System.out.print("�ּҸ� �Է����ּ��� : ");
				a.setJuso(sc.nextLine());
				array.add(a);
				
				System.out.println("��ϵ� ����� ����" + array.size() + "�Դϴ�.\n");
				break;
			case 2 :
				System.out.println("�ȳ��ϼ��� ����� ���� �˻� ���Դϴ�.");
				System.out.print("�˻��Ͻ� ��ȣ�� �Է����ּ��� : ");
				sno = sc.nextInt();
				System.out.println("");
				
				find = false;
				
				for(Address ad:array) {
					if(sno == ad.getNo()) {
						find = true;
						System.out.println("�̸� : " + ad.getName());
						System.out.println("��ȭ��ȣ : " + ad.getTel());
						System.out.println("�ּ� : " + ad.getJuso());
					}
				}
				
				if(find == false) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.");
				}
				System.out.println("");
				break;
			case 3: 
				System.out.println("�ȳ��ϼ���. ���� ���� ���Դϴ�.");
				System.out.print("�����Ͻ� ������� ��ȣ�� �Է����ּ���. : ");
				uno = sc.nextInt(); sc.nextLine();
				System.out.println("");
				
				find = false;
				
				for(Address ad:array) {
					if(uno == ad.getNo()) {
						find = true;
						
						System.out.print("���� �̸��� " + ad.getName() + " �Դϴ� �����Ͻ� �̸��� �Է����ּ��� : ");
						uname = sc.nextLine();
						
						System.out.print("���� ��ȭ��ȣ�� " + ad.getTel() + " �Դϴ� �����Ͻ� �̸��� �Է����ּ��� : ");
						utel = sc.nextLine();
						
						System.out.print("���� �ּҴ� " + ad.getJuso() + " �Դϴ� �����Ͻ� �̸��� �Է����ּ��� : ");
						ujuso = sc.nextLine();
						
						System.out.println("");
						
						System.out.println("�����Ͻ� �����Դϴ�.");
						System.out.println("�̸� : " + uname);
						System.out.println("��ȭ��ȣ : " + utel);
						System.out.println("�ּ� : " + ujuso);
						System.out.println("");
						
						System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y, �ƴϿ� : N)? : ");
						sel = sc.nextLine();
						System.out.println("");
						
						if(sel.equals("Y") || sel.equals("y")) {
							if(!uname.equals("")) {
								ad.setName(uname);
							}
							if(!utel.equals("")) {
								ad.setTel(utel);
							}
							if(!ujuso.equals("")) {
								ad.setJuso(ujuso);
							}
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
							break;
						}
						else if(sel.equals("N") || sel.equals("n")) {
							System.out.println("������ ����Ͽ����ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.\n");
				}
				break;
			case 4 : 
				System.out.println("�ȳ��ϼ���. ����� ���� ���Դϴ�.");
				System.out.print("�����Ͻ� ��ȣ�� �Է����ּ���. : ");
				dno = sc.nextInt(); sc.nextLine();
				System.out.println("");
				
				find = false;
				
				for(Address ad:array) {
					if(dno == ad.getNo()) {
						find = true;
						System.out.println("�̸� : " + ad.getName());
						System.out.println("��ȭ��ȣ : " + ad.getTel());
						System.out.println("�ּ� : " + ad.getJuso());
						System.out.println("");
						
						System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y, �ƴϿ� : N)?");
						sel = sc.nextLine();
						System.out.println("");
						
						if(sel.equals("Y") || sel.equals("y")) {
							array.remove(ad);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
							break;
						}
						else if(sel.equals("N") || sel.equals("n")) {
							System.out.println("������ ����Ͽ����ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.\n");
				}
				
				break;
			case 5 :
				System.out.println("�ȳ��ϼ���. ��� ���Դϴ�.");
				System.out.printf("��ȣ\t�̸�\t��ȭ��ȣ\t\t�ּ�\n");
				for(Address ad:array) {
					System.out.printf("%d\t%s\t%s\t%s\n", ad.getNo(), ad.getName(), ad.getTel(), ad.getJuso());
				}
				System.out.println("");
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �Է����ּ���.\n");
				break;
			}
		}
	}
}
