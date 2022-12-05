package ex14;

import java.util.ArrayList;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		CampVO vo = null;
		CampDAO cdao = new CampDAO();
		FacilDAO fdao = new FacilDAO();
		
		String[] facility = {"ȭ���", "����", "��������", "������", "������", "������"};
		
		int menu;
		int sel;
		
		boolean isFind = false;
		boolean run = true;

		while(run) {
			System.out.println("\n-----------------------------------");
			System.out.println("1.�ü������ | 2.�ü������� | 0.���޴�");
			System.out.println("-----------------------------------");
			menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("");
			
			switch(menu) {
			case 1 :
				int code = Input.input("ķ���� ��ȣ�� �Է����ּ���. : ");
				vo = cdao.read(code);
				if(vo.getName() == null) {
					System.out.println("�ش�ķ������ �����ϴ�.\n");
					break;
				}
				System.out.println("ķ���� �̸� : " + vo.getName());
				System.out.println("-----------------------------------");
				
				ArrayList<String> farray = fdao.list(code);
				ArrayList<String> check = new ArrayList<>();
				
				for(int i = 0; i < facility.length; i++) {	
					isFind = false;
					
					for(String f : farray) {
						if(facility[i].equals(f)) {
							isFind = true;
						}	
					}
					if(isFind == true) {
						check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s(%s)\n", i, facility[i], check.get(i));
				}
				System.out.println("---------------------------------------------");
				
				sel = Input.input("\n�߰��Ͻ� �ü��� �������ּ���. : ");
				System.out.println("");
				
				if(check.get(sel).equals("O")) {
					System.out.println("�̹� ��ϵ� �ü����Դϴ�.\n");
					break;
				}
				
				fdao.insert(code, facility[sel]);
				
				System.out.println(facility[sel] + "��(��) ��ϵǾ����ϴ�.");
				break;
			case 2 : 
				code = Input.input("ķ���� ��ȣ�� �Է����ּ���. : ");
				
				vo = cdao.read(code);
				
				if(vo.getName() == null) {
					System.out.println("�ش�ķ������ �����ϴ�.\n");
					break;
				}
				System.out.println("ķ���� �̸� : " + vo.getName());
				System.out.println("-----------------------------------");
				
				farray = fdao.list(code);
				check = new ArrayList<>();
				
				for(int i = 0; i < facility.length; i++) {	
					isFind = false;
					
					for(String f : farray) {
						if(facility[i].equals(f)) {
							isFind = true;
						}						
					}
					if(isFind == true) {
						check.add("O");
					} else {
						check.add("X");
					}
					System.out.printf("[%d] %s(%s)\n", i, facility[i], check.get(i));
					
				}
				System.out.println("---------------------------------------------");

				sel = Input.input("\n�����Ͻ� �ü��� �������ּ���. : ");
				if(check.get(sel).equals("X")) {
					System.out.println("��ϵ� �ü����� �ƴմϴ�.");
					break;
				}
				fdao.delect(code, facility[sel]);
				
				System.out.println(facility[sel] + "��(��) �����Ǿ����ϴ�.");
				
				System.out.println("");
				break;
			case 0 :
				run = false;
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���\n");
				break;
			}
			
		}
	}
}
