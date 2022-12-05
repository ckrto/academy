package ex17;

import java.util.ArrayList;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		TypeDAO tdao = new TypeDAO();
		TypeVO tvo = null;
		CampDAO cdao = new CampDAO();
		CampVO cvo = null;
		
		int menu;
		int qnt;
		
		String code;
		String sel;
		String newCode;
		String tname;
		String tcode;
		
		boolean find = false;
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
				newCode = tdao.getMaxCode();
				
				System.out.println("����Ͻ� �ü����� �ڵ�� " + newCode + " �Դϴ�.\n");
				System.out.print("�ü����� �̸��� �Է����ּ���. : ");
				tname = sc.nextLine();
				System.out.println("");
				
				if(tname.equals("")) {
					System.out.println("����� ����մϴ�.\n");
					break;
				}
				tdao.insert(newCode, tname);
				System.out.println("���ο� �ü����� ��ϵǾ����ϴ�.\n");
				break;
			case 2 :
				for(TypeVO t : tdao.list()) {
					System.out.printf("%s\t%s\n",t.getTcode(), t.getTname());
				}
				System.out.println("");
				break;
			case 3 :
				System.out.print("������ �ü����� �ڵ带 �Է����ּ���. : ");
				tcode = sc.nextLine();
				System.out.println("");
				
				if(tcode.equals("")) {
					System.out.println("������ ����߽��ϴ�.\n");
				}
				
				TypeVO vo = tdao.read(tcode);
				if(vo.getTname() == null) {
					System.out.println("������ �ڵ尡 �����ϴ�.\n");
					break;
				}
				
				System.out.println("���� �̸��� " + vo.getTname() + " �Դϴ�.\n");
				System.out.println("");
				
				System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
				sel = sc.nextLine();
				System.out.println("");
				
				if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
					success = tdao.delete(tcode);
					if(success == true) {
						System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
					} else {
						System.out.println("�� ������ ������� ķ������ �ֽ��ϴ�.\n");
					}
				} else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
				} else {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
	
				}
				System.out.println("");
				break;
			case 4 :
				System.out.print("����� ������ ķ������ �ڵ带 �Է����ּ���. : ");
				code = sc.nextLine();
				System.out.println("");
				if(code.equals("")) {
					System.out.println("��������� ����մϴ�.\n");
					break;
				}
				cvo = cdao.read(code);
				if(cvo.getCname() == null) {
					System.out.println("ķ������ �������� �ʽ��ϴ�.");
					break;
				}
				System.out.printf("%s(%s) \n", cvo.getCname(), cvo.getAdress());
				System.out.println("");
				
				ArrayList<TypeVO> tarray = tdao.list(code);
				System.out.print("��ϵ� ���� ��Ȳ : ");
				for(TypeVO t : tarray) {
					System.out.printf("%s(%s) | ", t.getTcode(), t.getTname());
				}
				System.out.println("\n------------------------------------------------");
				
				System.out.print("��ϵ��� ���� ���� ��Ȳ : ");
				ArrayList<TypeVO> aarray = tdao.list();
				for(TypeVO a : aarray) {
					TypeVO v = tdao.read(code, a.getTcode());
					if(v.getTname() == null) {
						System.out.printf("%s(%s) | ", a.getTcode(), a.getTname());
					}
				}
				System.out.println("\n------------------------------------------------");
				
				do {
					System.out.print("����Ͻ� �����ڵ带 �Է����ּ���. : ");
					tcode = sc.nextLine();
					if(tcode.equals("")) {
						break;
					}
					tvo = tdao.read(tcode);
					if(tvo.getTname() == null) {
						System.out.println("���� �����ڵ��Դϴ�.\n");
					} else {
						tvo = tdao.read(code, tcode);
						if(tvo.getTname() == null) {
							
							break;
						} else {
							System.out.println("�̹� ��ϵ� �����Դϴ�.");
						}
					}
				} while(true);
				
				System.out.print("������ �Է����ּ���. : ");
				qnt = sc.nextInt(); sc.nextLine();
				tvo = new TypeVO();
				tvo.setCode(code);
				tvo.setTcode(tcode);
				tvo.setQnt(qnt);
				tdao.insert(tvo);
				System.out.println("���ο� ������ ��ϵǾ����ϴ�.\n");
				
				System.out.println("");
				break;
			case 5 :
				
				System.out.print("����� ������ ķ������ �ڵ带 �Է����ּ���. : ");
				code = sc.nextLine();
				System.out.println("");
				if(code.equals("")) {
					System.out.println("��������� ����մϴ�.\n");
					break;
				}
				cvo = cdao.read(code);
				if(cvo.getCname() == null) {
					System.out.println("ķ������ �������� �ʽ��ϴ�.");
					break;
				}
				System.out.printf("%s(%s) \n", cvo.getCname(), cvo.getAdress());
				System.out.println("");
				
				tarray = tdao.list(code);
				System.out.print("��ϵ� ���� ��Ȳ : ");
				for(TypeVO t : tarray) {
					System.out.printf("%s(%s) | ", t.getTcode(), t.getTname());
				}
				System.out.println("\n------------------------------------------------");
				
				do {
					System.out.print("�����Ͻ� �����ڵ带 �Է����ּ���. : ");
					tcode = sc.nextLine();
					System.out.println("");
					
					if(tcode.equals("")) {
						break;
					}
					tvo = tdao.read(code, tcode);
					if(tvo.getTname() == null) {
						System.out.println("������ ������ �����ϴ�.\n");
						break;
					} else {
						tdao.delete(code, tcode);
						System.out.println("�����Ǿ����ϴ�.\n");
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
