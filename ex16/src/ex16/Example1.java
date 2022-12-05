package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		DeptDAO dao = new DeptDAO();
		DeptVO vo = null;
		
		int menu;
		int code;
		
		String sel;
		String dcode;
		String dname;
		String uname;
		String maxCode;
		String newCode;
		
		boolean success;
		boolean run = true;
		
		System.out.println("*************************** �� �� �� �� �� �� ***************************");
		while(run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.�ڵ��� | 2.�ڵ��� | 3.�ڵ���� | 4.�ڵ���� | 5.�ڵ���ȸ | 0.����");
			System.out.println("--------------------------------------------------------------");
			menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("");
			switch(menu) {
			case 1 :
				maxCode = dao.getMaxCode();
				code = Integer.parseInt(maxCode.substring(1)) + 10;
				
				newCode = "D" + code;
				System.out.println("�а��ڵ�� " + newCode);
				
				System.out.print("�а� �̸��� �Է����ּ���. : ");
				dname = sc.nextLine();
				System.out.println("");
				
				System.out.print("����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
				sel = sc.nextLine();
				System.out.println("");
				
				if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
					vo = new DeptVO();
					vo.setDcode(newCode);
					vo.setDname(dname);
					dao.insert(vo);
					System.out.println("���ο� �а��� ��ϵǾ����ϴ�.\n");
				} 
				else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
					System.out.println("����� ��ҵǾ����ϴ�.\n");
				} 
				else {
					System.out.println("�ٽ� �������ּ���.\n");
				}
				
				break;
			case 2 :
				ArrayList<DeptVO> array=dao.list();
				System.out.println("�а��ڵ�\t�а���");
				for(DeptVO v:array) {
					System.out.printf("%s\t%s\n",v.getDcode(),
										v.getDname());
				}
				
				System.out.println("");
				break;
			case 3 :
				System.out.print("�����Ͻ� �а��ڵ带 �Է����ּ���. : ");
				dcode = sc.nextLine();
				System.out.println("");
				
				vo = dao.read(dcode);
				
				if(vo.getDname() == null) {
					System.out.println("�˻��Ͻ� �а��� �������� �ʽ��ϴ�.\n");
				} else {
					System.out.println("�˻��Ͻ� " + dcode + "�� �а� �̸��� " + vo.getDname() + " �Դϴ�.\n");
					System.out.print("�����Ͻ� �а����� �Է����ּ���. : ");
					uname = sc.nextLine();
					System.out.println("");
					
					System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
					sel = sc.nextLine();
					System.out.println("");
					
					if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
						vo = new DeptVO();
						vo.setDcode(dcode);
						vo.setDname(uname);
						dao.update(vo);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
						
					} else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
						System.out.println("������ ��ҵǾ����ϴ�.\n");
					} else {
						System.out.println("�ٽ� �������ּ���.\n");
					}
				}
				
				break;
			case 4 :
				System.out.print("�����Ͻ� �а��ڵ带 �Է����ּ���. : ");
				dcode = sc.nextLine();
				System.out.println("");
				
				vo = dao.read(dcode);
				
				if(vo.getDname() == null) {
					System.out.println("�˻��Ͻ� �а��� �������� �ʽ��ϴ�.\n");
				} else {
					System.out.println("�˻��Ͻ� " + dcode + "�� �а� �̸��� " + vo.getDname() + " �Դϴ�.\n");
					System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
					sel = sc.nextLine();
					System.out.println("");
					
					if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
						success = dao.delete(dcode);
						if(success == true) {
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
						} else {
							System.out.println("�� �а��� �л��� �ֽ��ϴ�.\n");
						}
					} else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
						System.out.println("������ ��ҵǾ����ϴ�.\n");
					} else {
						System.out.println("�ٽ� �������ּ���.\n");
					}
				}
				break;
			case 5 :
				System.out.print("��ȸ�Ͻ� �а��ڵ带 �Է����ּ���. : ");
				dcode = sc.nextLine();
				vo = dao.read(dcode);
				System.out.println();
				
				if(vo.getDname() == null) {
					System.out.println("�˻��Ͻ� �а��� �������� �ʽ��ϴ�.\n");
					break;
				} else {
					System.out.println("�˻��Ͻ� " + dcode + "�� �а� �̸��� " + vo.getDname() + " �Դϴ�.\n");
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
