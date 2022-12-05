package Sale;

import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		SaleDAO dao = new SaleDAO();
		SaleVO vo = null;
		
		int menu;
		int sno;
		int dno;
		int uno;
		String price;
		String qnt;
		
		String name;
		
		
		boolean run = true;
		
		while(run) {
			System.out.println("�ȳ��ϼ��� ������� �ý����Դϴ�.");
			System.out.println("--------------------------------------------------");
			System.out.println("1.��� | 2.��� | 3.�˻� | 4.���� | 5.���� | 0.����");
			System.out.println("--------------------------------------------------");
			System.out.print("������ �۾��� �������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			
			switch(menu) {
			case 1 :
				int newNo = dao.getNo() + 100;
				vo = new SaleVO();
				System.out.println("��ǰ��ȣ�� " + newNo + " �Դϴ�.");
				vo.setNo(newNo);
				System.out.print("����Ͻ� ��ǰ�� �̸��� �Է����ּ���. : ");
				vo.setName(sc.nextLine());
				System.out.print("����Ͻ� ��ǰ�� �ܰ��� �Է����ּ���. : ");
				vo.setPrice(sc.nextInt()); sc.nextLine();
				System.out.print("����Ͻ� ��ǰ�� �Ǹ� ������ �Է����ּ���. : ");
				vo.setQnt(sc.nextInt()); sc.nextLine();
				dao.insert(vo);
				System.out.println("���ο� ��ǰ�� ��ϵǾ����ϴ�.\n");
				break;
			case 2 :
				for(SaleVO v:dao.list()) {
					System.out.println(v.toString());
				}
				System.out.println("");
				break;
			case 3 :
				System.out.print("�˻��� ��ǰ�� ��ȣ�� �Է����ּ���. : ");
				sno = sc.nextInt(); sc.nextLine();
				
				vo = dao.read(sno);
				if(vo.getName() == null) {
					System.out.println("�˻��� ��ǰ�� �������� �ʽ��ϴ�.");
				}
				else {
					System.out.println(vo.toString());
				}
				System.out.println("");
				break;
			case 4 : 
				System.out.print("�����Ͻ� ��ǰ�� ��ȣ�� �Է����ּ���. : ");
				uno = sc.nextInt(); sc.nextLine();
				vo = dao.read(uno);
				if(vo.getName() == null) {
					System.out.println("������ ��ǰ�� �������� �ʽ��ϴ�.");
				}
				else {
					SaleVO v = new SaleVO();
					v.setNo(uno);
					System.out.print("���� �̸��� " + vo.getName() + " �Դϴ�. �����Ͻ� ��ǰ���� �Է����ּ���. : ");
					name = sc.nextLine();
					System.out.print("���� �Ǹ� �ܰ��� " + vo.getPrice() + " �Դϴ�. �����Ͻ� �Ǹ� �ܰ��� �Է����ּ���. : ");
					price = sc.nextLine();
					System.out.print("���� �Ǹ� ������ " + vo.getQnt() + " �Դϴ�. �����Ͻ� �Ǹ� ������ �Է����ּ���. : ");
					qnt = sc.nextLine();
					
					if(!name.equals("")) {
						vo.setName(name);
					}
					if(!price.equals("")) {
						vo.setPrice(Integer.parseInt(price));
					}
					if(!qnt.equals("")) {
						vo.setQnt(Integer.parseInt(qnt));
					}
					dao.update(vo);
					System.out.println("��ǰ�� ������ �����Ǿ����ϴ�.");
				}
				
				System.out.println("");
				break;
			case 5 : 
				System.out.print("������ ��ǰ�� ��ȣ�� �Է����ּ���. : ");
				dno = sc.nextInt(); sc.nextLine();
				vo = dao.read(dno);
				if(vo.getName() == null) {
					System.out.println("������ ��ǰ�� �������� �ʽ��ϴ�.");
				}
				else {
					dao.delete(dno);
					System.out.println(vo.getName() + "�� ������ �Ϸ�Ǿ����ϴ�.");
				}
				
				System.out.println("");
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
