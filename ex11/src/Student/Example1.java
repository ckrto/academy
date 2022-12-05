package Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		StudentDAO dao = new StudentDAOImpl();
		StudentVO vo = null;
		
		int sno;
		int dno;
		int uno;
		int menu;
		
		boolean run = true;
		
		while(run) {
			System.out.println("�ȳ��ϼ��� �л����� �ý����Դϴ�.");
			System.out.println("--------------------------------------------------");
			System.out.println("1.��� | 2.��� | 3.�˻� | 4.���� | 5.���� | 0.����");
			System.out.println("--------------------------------------------------");
			System.out.print("������ �۾��� �������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			
			switch(menu) {
			case 1 : 
				int newCode = dao.getCode() + 100;
				vo = new StudentVO();
				
				System.out.println("������ ��ȣ�� " + newCode + " �Դϴ�.");
				vo.setNo(newCode);
				
				System.out.print("�̸��� �Է����ּ���. : ");
				vo.setName(sc.nextLine());
				
				System.out.print("��ȭ��ȣ�� �Է����ּ���. : ");
				vo.setTel(sc.nextLine());
				
				System.out.print("�ּҸ� �Է����ּ���. : ");
				vo.setAddress(sc.nextLine());
				
				dao.insert(vo);
				System.out.println("����� �Ϸ�Ǿ����ϴ�.\n");
				break;
			case 2 :
				ArrayList<StudentVO> array = dao.list();
				for(StudentVO v : array) {
					System.out.printf("%d\t%s\t%s\t%s\n", v.getNo(), v.getName(), v.getTel(), v.getAddress());
				}
				System.out.println("");
				
				System.out.println("��ü������ ���� : " + array.size() + "\n");
				break;
			case 3 :
				System.out.print("�˻��� ��ȣ�� �Է����ּ���. : ");
				sno = sc.nextInt(); sc.nextLine();
				
				vo = dao.read(sno);
				
				if(vo.getName() == null) {
					System.out.println("�˻��� �л��� �������� �ʽ��ϴ�.\n");
				}
				else {
					System.out.println(vo.toString());
				}
				System.out.println("");
				break;
			case 4 :
				System.out.print("�����Ͻ� ��ȣ�� �Է����ּ���. : ");
				uno = sc.nextInt(); sc.nextLine();
				vo = dao.read(uno);
				System.out.println("");
				
				if(vo.getName() == null) {
					System.out.println("�����Ͻ� �л��� �������� �ʽ��ϴ�.\n");
				}
				else {
					StudentVO v = new StudentVO();
					v.setNo(uno);
					System.out.print("���� �̸��� " + vo.getName() + " �Դϴ�. �����Ͻ� �̸��� �Է����ּ���. : ");
					String name = sc.nextLine();
					System.out.print("���� ��ȭ��ȣ�� " + vo.getTel() + " �Դϴ�. �����Ͻ� ��ȭ��ȣ�� �Է����ּ���. : ");
					String tel = sc.nextLine();
					System.out.print("���� �̸��� " + vo.getAddress() + " �Դϴ�. �����Ͻ� �ּҸ� �Է����ּ���. : ");
					String address = sc.nextLine();
					
					if(!name.equals("")) {
						vo.setName(name);
					}
					
					if(!tel.equals("")) {
						vo.setTel(tel);
					}
					
					if(!address.equals("")) {
						vo.setAddress(address);
					}
					
					dao.update(vo);
					System.out.println(vo.getName() + "���� ������ ������ �Ϸ�Ǿ����ϴ�.");
				}
				break;
			case 5 :
				System.out.print("������ ��ȣ�� �Է����ּ���. : ");
				dno = sc.nextInt(); sc.nextLine();
				vo = dao.read(dno);
				if(vo.getName() == null) {
					System.out.println("������ �л��� �������� �ʽ��ϴ�.\n");
				}
				else {
					dao.delete(dno);
					System.out.println(vo.getName() + "��(��) ������ �Ϸ�Ǿ����ϴ�.\n");
				}
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
