package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();
		StudentVO vo = null;
		DeptDAO ddao = new DeptDAO();
		
		int menu;
		int newNo;
		
		String sel;
		String maxNo;
		String sno;
		String sname;
		String dcode;
		
		boolean success;
		boolean isFind = false;
		boolean run = true;
		
		System.out.println("*************************** �� ��  �� �� ***************************");
		
		while(run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.�л���� | 2.�л���� | 3.�л����� | 4.�л����� | 5.�л���ȸ | 0.����");
			System.out.println("--------------------------------------------------------------");
			menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("");
			
			switch(menu) {
			case 1 :
				maxNo = dao.maxNo();
				newNo = Integer.parseInt(maxNo) + 100;
				System.out.println("������ �й��� " + newNo + "�� �Դϴ�.\n");
				
				do {
					System.out.print("�̸��� �Է����ּ���. : ");
					sname = sc.nextLine();
					System.out.println("");
					
					if(sname.equals("")) {
						System.out.println("�̸��� �Է��ϼ���!");
					}
				} while(sname.equals(""));
				
				ArrayList<DeptVO> darray = ddao.list();
				for(DeptVO v : darray) {
					System.out.printf("%s : %s | ", v.getDcode(), v.getDname());
				}
				System.out.println("");
				
				do {
					System.out.print("�а� �ڵ带 �������ּ���. : ");
					dcode = sc.nextLine();
					System.out.println("");
					
					DeptVO v = ddao.read(dcode);
					if(v.getDname() != null) {
						isFind = true;
					}
					if(isFind == false) {
						System.out.println("�ش� �а��ڵ带 ���� �а��� �������� �ʽ��ϴ�.\n");
					}
				} while(isFind == false);
				
				vo = new StudentVO();
				vo.setSno(String.valueOf(newNo));
				vo.setSname(sname);
				vo.setDcode(dcode);
				dao.insert(vo);
				
				System.out.println("���ο� �л��� ��ϵǾ����ϴ�.\n");
				
				break;
			case 2 :
				ArrayList<StudentVO> array = dao.list();
				System.out.println("�й�\t�̸�\t�а��ڵ�(�а�)");
				for(StudentVO v : array) {
					System.out.printf("%s\t%s\t%s(%s)\n", v.getSno(), v.getSname(), v.getDcode(), v.getDname());
				}
				System.out.println("");
				break;
			case 3 :
				System.out.print("�����Ͻ� �л��� �й��� �Է����ּ���. : ");
				sno = sc.nextLine();
				if(sno.equals("")) {
					System.out.println("������ ����մϴ�.\n");
					break;
				}
				System.out.println("");
				
				vo = dao.read(sno);
				
				if(vo.getSname() == null) {
					System.out.println("�˻��Ͻ� �й��� ���� �л��� ���������ʽ��ϴ�.\n");
					break;
				}
				
				System.out.println("�˻��Ͻ� �л��� �̸��� " + vo.getSname() + "�Դϴ�.");
				System.out.print("�����Ͻ� �̸��� �Է����ּ���. : ");
				sname = sc.nextLine();
				
				if(!sname.equals("")) {
					vo.setSname(sname);
				}
				System.out.println("");
				
				darray = ddao.list();
				for(DeptVO v : darray) {
					System.out.printf("%s : %s | ", v.getDcode(), v.getDname());
				}
				System.out.println("");
				
				isFind = false;
				do {
					System.out.printf("���� �а��ڵ�� �а��� %s(%s) �Դϴ�. ������ �а��ڵ带 �Է����ּ���. : ",vo.getDcode(), vo.getDname());
					dcode = sc.nextLine();
					if(dcode.equals("")) {
						break;
					}
					System.out.println("");
					DeptVO dvo = ddao.read(dcode);
					if(dvo.getDname() != null) {
						isFind = true;
					}
					if(isFind == false) {
						System.out.println("�ش��а��� �����ϴ�.\n");
					}
				} while(isFind == false);
				
				if(!dcode.equals("")) {
					vo.setDcode(dcode);
				}
				
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
				
				System.out.println("");
				break;
			case 4 :
				System.out.print("�����Ͻ� �л��� �й��� �Է����ּ���. : ");
				sno = sc.nextLine();
				if(sno.equals("")) {
					System.out.println("������ ����մϴ�.\n");
					break;
				}
				System.out.println("");
				
				vo = dao.read(sno);
				if(vo.getSname() == null) {
					System.out.println("�ش� �л��� �������� �ʽ��ϴ�.\n");
					break;
				}
				System.out.printf("%s(%s)\n", vo.getSname(), vo.getDname());
				
				System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
				sel = sc.nextLine();
				System.out.println("");
				
				if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
					success = dao.delete(sno);
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
				break;
			case 5:
				System.out.print("��ȸ�Ͻ� �л��� �й��� �Է����ּ���. : ");
				sno = sc.nextLine();
				vo = dao.read(sno);
				System.out.println("");
				
				if(vo.getSname() == null) {
					System.out.println("�˻��Ͻ� �й��� ���� �л��� ���������ʽ��ϴ�.\n");
					break;
				}
				System.out.println("�˻��Ͻ� �л��� �̸��� " + vo.getSname());
				System.out.printf("�а��ڵ�� �а��� %s(%s) �Դϴ�.\n", vo.getDcode(), vo.getDname());
				System.out.println("");
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
