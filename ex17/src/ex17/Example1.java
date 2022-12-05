package ex17;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		FacilityDAO fdao = new FacilityDAO();
		CampDAO cdao = new CampDAO();
		
		int menu;
		
		String code;
		String sel;
		String fcode;
		String fname;
		String newCode;
		
		boolean success = false;
		boolean run = true;
		
		while(run) {
			System.out.println("************************* �ü��� ���� *************************");
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.��� | 2.��� | 3.���� | 4.���(ķ����) | 5.����(ķ����) | 0.����");
			System.out.println("-----------------------------------------------------------");
			menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("");
			
			switch(menu) {
			case 1 :
				newCode = fdao.getMaxCode();
				
				System.out.println("����Ͻ� �ü����� �ڵ�� " + newCode + " �Դϴ�.\n");
				System.out.print("�ü����� �̸��� �Է����ּ���. : ");
				fname = sc.nextLine();
				System.out.println("");
				
				if(fname.equals("")) {
					System.out.println("����� ����մϴ�.\n");
					break;
				}
				fdao.insert(newCode, fname);
				System.out.println("���ο� �ü����� ��ϵǾ����ϴ�.\n");
				break;
			case 2 : 
				ArrayList<FacilityVO> farray = fdao.list();
				System.out.println("�ü����ڵ�\t�ü����̸�");
				for(FacilityVO f : farray) {
					System.out.printf("%s\t%s\n", f.getFcode(), f.getFname());
				}
				System.out.println("");
				break;
			case 3 :
				System.out.print("������ �ü����� �ڵ带 �Է����ּ���. : ");
				fcode = sc.nextLine();
				System.out.println("");
				
				if(fcode.equals("")) {
					System.out.println("������ ����߽��ϴ�.\n");
				}
				
				FacilityVO vo = fdao.read(fcode);
				if(vo.getFname() == null) {
					System.out.println("�ش� �ü����� �������� �ʽ��ϴ�.");
					break;
				}
				
				System.out.println("�ü����� �̸��� " + vo.getFname() + " �Դϴ�.\n");
				System.out.println("");
				
				System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
				sel = sc.nextLine();
				System.out.println("");
				
				if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
					success = fdao.delete(fcode);
					if(success == true) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
					} else {
						System.out.println("�� �ü����� ������� ķ������ �ֽ��ϴ�.\n");
					}
				} else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
				} else {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
	
				}
				System.out.println("");
				break;
			case 4 :
				System.out.print("ķ���� �ڵ带 �Է����ּ���. : ");
				code = sc.nextLine();
				System.out.println("");
				
				if(code.equals("")) {
					System.out.println("�ü��� ����� ����մϴ�.\n");
					break;
				}
				
				CampVO cvo = cdao.read(code);
				if(cvo.getCname() == null) {
					System.out.println("�ش�Ǵ� ķ������ �������� �ʽ��ϴ�.\n");
					break;
				}
				
				System.out.printf("%s(%s)\n", cvo.getCname(), cvo.getAdress());
				System.out.println("");
				
				System.out.println("��ϵ� �ü��� ����Դϴ�.");
				System.out.println("----------------------------------------------");
				farray = fdao.list(code);
				for(FacilityVO f : farray) {
					System.out.printf("%s:%s | ", f.getFcode(), f.getFname());
				}
				System.out.println("\n");
				System.out.println("����� �ȵ� �ü��� ����Դϴ�.");
				System.out.println("----------------------------------------------");
				ArrayList<FacilityVO> allArray = fdao.list();
				for(FacilityVO a : allArray) {
					boolean find = false;
					for(FacilityVO f : farray) {
						if(a.getFcode().equals(f.getFcode()))
						{
							find = true;
						}
					}
					
					if(find == false) {
						System.out.printf("%s:%s | ", a.getFcode(), a.getFname());
					}
				}
				System.out.println("\n----------------------------------------------\n");
				
				System.out.print("����Ͻ� �ü����� �������ּ���. : ");
				fcode = sc.nextLine();
				System.out.println("");
				
				if(fcode.equals("")) {
					System.out.println("�ü��� ����� ����մϴ�.\n");
					break;
				}
				
				FacilityVO fvo = fdao.read(fcode);
				if(fvo.getFname() == null) {
					System.out.println("�ü����� ã�� �� �����ϴ�.\n");
					break;
				}
				
				fvo = fdao.read(code, fcode);
				if(fvo.getFname() == null) {
					fvo = new FacilityVO();
					fvo.setCode(code);
					fvo.setFcode(fcode);
					fdao.insert(fvo);
					System.out.println("���ο� �ü����� ��ϵǾ����ϴ�.\n");
				} else {
					System.out.println(fvo.getFname() + " �ü����� �̹� ��ϵǾ��ֽ��ϴ�.\n");
				}
				
				break;
			case 5 :
				System.out.print("ķ���� �ڵ带 �Է����ּ���. : ");
				code = sc.nextLine();
				System.out.println("");
				if(code.equals("")) {
					System.out.println("�ü��� ������ ����մϴ�.\n");
					break;
				}
				cvo = cdao.read(code);
				if(cvo.getCname() == null) {
					System.out.println("�ش�Ǵ� ķ������ �������� �ʽ��ϴ�.\n");
					break;
				}
				System.out.printf("%s(%s)\n", cvo.getCname(), cvo.getAdress());
				System.out.println("");
				
				farray = fdao.list(code);
				System.out.println("��ϵ� �ü��� ����Դϴ�.");
				System.out.println("----------------------------------------------");
				for(FacilityVO f : farray) {
					System.out.printf("%s:%s | ", f.getFcode(), f.getFname());
				}
				
				System.out.println("\n----------------------------------------------");
				do {
					System.out.print("\n�����Ͻ� �ü��� �ڵ带 �Է����ּ���. : ");
					fcode = sc.nextLine();
					System.out.println("");
					
					if(fcode.equals("")) {
						System.out.println("�ü��� ������ ����մϴ�.\n");
						break;
					}
					fvo = fdao.read(fcode);
					if(fvo.getFname() == null) {
						System.out.println("�ش� �ü����� �����ϴ�.\n");
					} else {
						fdao.delete(code, fcode);
						System.out.println(fvo.getFname() + " �ü����� �����Ǿ����ϴ�.");
					}
				} while(true);
				
				break;
			case 0 :
				run = false;
				System.out.println("���θ޴��� ���ư��ϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���\n");
				break;
			
			}
		}
	}
}
