package ex10;

import java.util.ArrayList;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		AccountVO vo = null;
		AccountDAO dao = new AccountDAO();
		ArrayList<AccountVO> array = dao.list();
		
		int menu;
		int no = 400;
		int ino;
		int eno;
		int amount;
		
		String sno;
		
		boolean run = true;
		
		while(run) {
			System.out.println("---------------------------------------------------");
			System.out.println("1.���»��� | 2.�ܾ���ȸ | 3.�Ա� | 4.��� | 5.���¸�� | 0.����");
			System.out.println("---------------------------------------------------");
			System.out.print("������ �۾��� �������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			
			System.out.println("");
			
			switch(menu) {
			case 1 :
				vo = new AccountVO();
				
				System.out.println("������ ���¹�ȣ�� " + no + " �Դϴ�.");
				vo.setNo(no);
				System.out.print("�̸��� �Է����ּ��� : ");
				vo.setName(sc.nextLine());
				System.out.print("�ʱ� �Աݾ��� �Է����ּ���. : ");
				vo.setBalance(Integer.parseInt(sc.nextLine()));
				
				dao.insert(vo, array);
				
				System.out.println("���°� ��ϵǾ����ϴ�.\n");
				break;
			case 2 :
				System.out.print("��ȸ�Ͻ� ���¹�ȣ�� �Է����ּ��� : ");
				sno = sc.nextLine();
				System.out.println("");
				vo = dao.read(Integer.parseInt(sno), array);
				
				if(vo.getName() == null) {
					System.out.println("��ϵ������� ���¹�ȣ�Դϴ�.");
				}
				else {
					System.out.println("�����ָ� : " + vo.getName());
					System.out.println("�ܾ� : " + vo.getBalance());
				}
				
				System.out.println("");
				break;
			case 3 : 
				System.out.print("�Ա��� �����Ͻ� ���¹�ȣ�� �Է����ּ��� : ");
				ino = sc.nextInt(); sc.nextLine();
				vo = dao.read(ino, array);
				
				if(vo.getName() == null) {
					System.out.println("�ش���°� �������� �ʽ��ϴ�.");
				}
				else {
					System.out.print("�Ա��� �ݾ��� �Է����ּ��� : ");
					amount = sc.nextInt(); sc.nextLine();
					dao.trade(ino, amount, array);
					System.out.println("");
					
					System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.\n");
					
					vo = dao.read(ino, array);
					System.out.println("���� �ܾ��� " + vo.getBalance() + "�� �Դϴ�.\n");
				}
				break;
			case 4 :
				System.out.print("����� �����Ͻ� ���¹�ȣ�� �Է����ּ��� : ");
				eno = sc.nextInt(); sc.nextLine();
				vo = dao.read(eno, array);
				
				if(vo.getName() == null) {
					System.out.println("�ش���°� �������� �ʽ��ϴ�.");
				}
				else {
					System.out.print("����� �ݾ��� �Է����ּ��� : ");
					amount = sc.nextInt(); sc.nextLine();
					
					if(amount > vo.getBalance()) {
						System.out.println("���¿� �����ܾ׺��� ����Ϸ��� �Ͻô� �ݾ��� �� �����ϴ�.\n");
					}
					else {
						dao.trade(eno, -amount, array);
						System.out.println("");
						
						System.out.println("����� �Ϸ�Ǿ����ϴ�.\n");
						
						vo = dao.read(eno, array);
						System.out.println("���� �ܾ��� " + vo.getBalance() + "�� �Դϴ�.\n");
					}
				}
				break;
			case 5 :
				for(AccountVO v:array) {
					System.out.println(v.toString());
				}
				System.out.println("");
				System.out.println("��ϵ� ��ü ������ ���� " + array.size() + "�� �Դϴ�.\n");
				break;
			case 0 : 
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���.\n");
				break;
			}
			
		}
		
	}
}
