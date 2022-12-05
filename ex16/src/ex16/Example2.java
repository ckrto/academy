package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		TypeDAO dao = new TypeDAO();
		TypeVO vo = null;
		
		int menu;
		int code;
		
		String sel;
		String newCode;
		String maxCode;
		String tcode;
		String tname;
		String tdate;
		
		boolean success;
		boolean run = true;
		
		System.out.println("*************************** Ÿ �� �� �� �� �� ***************************");
		while(run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.Ÿ�Ե�� | 2.Ÿ�Ը�� | 3.Ÿ�Լ��� | 4.Ÿ�Ի��� | 5.Ÿ����ȸ | 0.����");
			System.out.println("--------------------------------------------------------------");
			menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("");
			
			switch(menu) {
			case 1 :
				maxCode = dao.getMaxCode();
				code = Integer.parseInt(maxCode.substring(1)) + 10;
				newCode = "T" + code;
				System.out.println("�����ڵ�� " + newCode);
				
				System.out.print("����Ͻ� ������ �̸��� �Է����ּ���. : ");
				tname = sc.nextLine();
				System.out.println("");
				
				System.out.print("����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
				sel = sc.nextLine();
				System.out.println("");
				
				if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
					vo = new TypeVO();
					vo.setTcode(newCode);
					vo.setTname(tname);
					dao.insert(vo);
					System.out.println("���ο� ������ ��ϵǾ����ϴ�.\n");
				} 
				else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
					System.out.println("����� ��ҵǾ����ϴ�.\n");
				} 
				else {
					System.out.println("�ٽ� �������ּ���.\n");
				}
				
				break;
			case 2 :
				ArrayList<TypeVO> array = dao.list();
				System.out.println("�����ڵ�\t��������\t���賯¥");
				for(TypeVO v : array) {
					System.out.printf("%s\t%s\t%s\n", v.getTcode(), v.getTname(), v.getTdate());
				}
				System.out.println("");
				break;
			case 3 :
				System.out.print("�����Ͻ� �����ڵ带 �Է����ּ���. : ");
				tcode = sc.nextLine();
				System.out.println("");
				
				vo = dao.read(tcode);
				
				if(vo.getTname() == null) {
					System.out.println("�˻��Ͻ� ���� ������ �������� �ʽ��ϴ�.\n");
				} else {
					System.out.println("�˻��Ͻ� " + tcode + "�� ���� ������ " + vo.getTname() + " �Դϴ�.");
					System.out.print("�����Ͻ� ������� �Է����ּ���. : ");
					tname = sc.nextLine();
					
					if(!tname.equals("")) {
						vo.setTname(tname);
					}
					System.out.println("");
					
					System.out.println(vo.getTname() + "�� �������� " + vo.getTdate() + " �Դϴ�.");
					System.out.print("�����Ͻ� ���� ��¥�� �Է����ּ���. : ");
					tdate = sc.nextLine();
					
					if(!tdate.equals("")) {
						vo.setTdate(tdate);
					}
					System.out.println("");
					
					System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
					sel = sc.nextLine();
					System.out.println("");
					
					if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
						dao.update(vo);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
						
					} else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
						System.out.println("������ ��ҵǾ����ϴ�.\n");
					} else {
						System.out.println("������ ��ҵǾ����ϴ�.\n");
					}
				}
				
				break;
			case 4 :
				System.out.print("�����Ͻ� ������ �ڵ带 �Է����ּ���. : ");
				tcode = sc.nextLine();
				System.out.println("");
				
				vo = dao.read(tcode);
				
				if(vo.getTname() == null) {
					System.out.println("�˻��Ͻ� �а��� �������� �ʽ��ϴ�.\n");
				} else {
					System.out.println("�˻��Ͻ� " + tcode + "�� �а� �̸��� " + vo.getTname() + " �Դϴ�.\n");
					System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
					sel = sc.nextLine();
					System.out.println("");
					
					if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
						success = dao.delete(tcode);
						if(success == true) {
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
						} else {
							System.out.println("�������̺��� ������̿��� ������ �� �����ϴ�.\n");
						}
					} else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
						System.out.println("������ ��ҵǾ����ϴ�.\n");
					} else {
						System.out.println("������ ��ҵǾ����ϴ�.\n");
					}
				}
				break;
			case 5 :
				System.out.print("��ȸ�Ͻ� ������ �ڵ带 �Է����ּ���. : ");
				tcode = sc.nextLine();
				vo = dao.read(tcode);
				System.out.println();
				
				if(vo.getTname() == null) {
					System.out.println("�˻��Ͻ� �а��� �������� �ʽ��ϴ�.\n");
				} else {
					System.out.println("�˻��Ͻ� " + tcode + "�� ���� ������ " + vo.getTname());
					System.out.println("�������� " + vo.getTdate() + " �Դϴ�.\n");
				}
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
