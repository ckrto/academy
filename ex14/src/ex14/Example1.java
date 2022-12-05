package ex14;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		CampDAO cdao = new CampDAO();
		TypeDAO tdao = new TypeDAO();
		FacilDAO fdao = new FacilDAO();
		CampVO vo = null;
		
		int menu;
		int code;
		int newCode;
		
		boolean run = true;
		
		while(run) {
			System.out.println("-------------------------------------------------------------------");
			System.out.println("1.ķ������ | 2.ķ������ȸ | 3.ķ������ | 4.�ü������� | 5.�������� | 0.����");
			System.out.println("-------------------------------------------------------------------");
			menu = Input.input("������ �۾��� �������ּ��� : ");
			System.out.println("");
			
			switch(menu) {
			case 1 :
				newCode = cdao.getLastCode() + 100;
				vo = new CampVO();
				
				System.out.println("ķ���� �ڵ�� " +  newCode + " �Դϴ�.");
				vo.setCode(newCode);
				
				System.out.print("ķ���� �̸��� �Է����ּ���. : ");
				vo.setName(sc.nextLine());
				
				System.out.print("ķ������ �ּҸ� �Է����ּ���. : ");
				vo.setAddress(sc.nextLine());
				
				System.out.println("");
				
				cdao.insert(vo);
				
				System.out.println("���ο� ķ������ ��ϵǾ����ϴ�.\n");
				break;
			case 2 :
				code = Input.input("��ȸ�� �ڵ带 �Է����ּ���. : ");
				vo = cdao.read(code);
				if(vo.getName() == null) {
					System.out.println("�˻��� �ڵ��� ķ������ �������� �ʽ��ϴ�.");
				} else {
					System.out.println("ķ�����̸� : " + vo.getName());
					System.out.println("ķ�����ּ� : " + vo.getAddress());
					ArrayList<String> tarray = tdao.list(code);
					System.out.print("ķ���� Type :");
					if(tarray.size() == 0) {
						System.out.print(" ����");
					}
					for(String t : tarray) {
						System.out.printf(" %s |" ,t);
					}
					System.out.println("");
					ArrayList<String> farray = fdao.list(code);
					System.out.print("ķ���� �ü��� :");
					if(farray.size() == 0) {
						System.out.print(" ����");
					}
					for(String f : farray) {
						System.out.printf(" %s |", f);
					}
				}
				System.out.println("\n");
				break;
			case 3 : 
				System.out.println("------------------------");
				System.out.println("�ڵ�\tķ�����̸�\tķ�����ּ�");
				System.out.println("------------------------");
				ArrayList<CampVO> carray = cdao.list();
				for(CampVO c : carray) {
					System.out.printf("%d\t%s\t%s\n", c.getCode(), c.getName(), c.getAddress());
					ArrayList<String> tarray = tdao.list(c.getCode());
					System.out.print("ķ���� Type :");
					if(tarray.size() == 0) {
						System.out.print(" ����");
					}
					for(String t : tarray) {
						System.out.printf(" %s |" ,t);
					}
					System.out.println("");
					ArrayList<String> farray = fdao.list(c.getCode());
					System.out.print("ķ���� �ü��� :");
					if(farray.size() == 0) {
						System.out.print(" ����");
					}
					for(String f : farray) {
						System.out.printf(" %s |", f);
					}
					System.out.println("\n--------------------------");
				}
				System.out.println("");
				
				System.out.println("��ϵ� ķ���� ���� " + carray.size() + "�� �Դϴ�.\n");
				break;
			case 4 :
				Example2.execute();
				break;
			case 5 :
				Example3.execute();
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���\n");
				break;
			}
		}
	}
}
