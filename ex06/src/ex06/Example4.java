package ex06;

import java.util.ArrayList;
import java.util.Scanner;

public class Example4 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> products = new ArrayList<>();
		
		String name;
		String sname;
		String dname;
		String nname;
		String uname;
		String price;
		String nprice;
		String qnt;
		String nqnt;
		String sel;
		
		Product product = new Product("��Ź��", 500000, 50);
		products.add(product);
		
		product = new Product("�����", 900000, 20);
		products.add(product);
		
		product = new Product("��ǳ��", 50000, 100);
		products.add(product);
		
		int menu;
		
		boolean find = false;
		boolean run = true;
		
		System.out.println("�ȳ��ϼ���. ��ǰ���� �ý����Դϴ�.");
		
		while(run) {
			System.out.println("�Ʒ��� �׸� �� �Ѱ����� �������ּ���.");
			System.out.println("-------------------------------");
			System.out.println("1.��� | 2.�˻� | 3.��� | 4.���� | 5.���� | 0.����");
			System.out.println("-------------------------------");
			System.out.print("������ �׸� : ");
			menu = sc.nextInt(); sc.nextLine();
	
			System.out.println("");
			switch(menu) {
			case 1 :
				System.out.println("�ȳ��ϼ���. ��ǰ ��� ���Դϴ�.");
				System.out.print("�̸��� �Է����ּ��� : ");
				name = sc.nextLine();
				
				System.out.print("��ǰ �ܰ��� �Է����ּ���. : ");
				price = sc.nextLine();
				
				System.out.print("�Ǹ� ������ �Է����ּ���. : ");
				qnt = sc.nextLine();
				
				product = new Product(name, Integer.parseInt(price), Integer.parseInt(qnt));
				products.add(product);
				
				System.out.println("��ϵ� ��ǰ�� ���� " + products.size() + "�� �Դϴ�. \n");
				
				break;
			case 2 :
				find = false;
				
				System.out.print("�˻��Ͻ� ��ǰ�� ��ǰ���� �Է��ϼ��� : ");
				sname = sc.next(); sc.nextLine();
				
				for(Product p:products) {
					if(sname.equals(p.name)) {
						find = true;
						p.print();
						System.out.println("");
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ��ǰ�� �ƴմϴ�.");
				}
				break;
			case 3 :
				System.out.println("��ǰ��\t��ǰ�ܰ�\t\t\t�Ǹż���\t\t\t�Ǹű��\t\t\t\t���");
				for(Product p:products) {
					p.printList();
				}
				System.out.println("");
				break;
			case 4 : 
				System.out.print("������ ��ǰ�� ��ǰ���� �Է����ּ���. : ");
				dname = sc.next(); sc.nextLine();
				
				for(Product p:products) {
					if(dname.equals(p.name)) {
						find = true;
						p.print();
						
						System.out.print("���� �����Ͻ� �ǰ���(�� : Y, �ƴϿ� : N)? : ");
						sel = sc.next(); sc.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							products.remove(p);
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
							break;
						}
						else if (sel.equals("N") || sel.equals("n") || sel.equals("��")) {
							System.out.println("����Ͽ����ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ��ǰ�� �ƴմϴ�.");
				}
				break;
			case 5 :
				System.out.print("������ ��ǰ�� ��ǰ���� �Է����ּ���. : ");
				uname = sc.next(); sc.nextLine();
				
				for(Product p:products) {
					if(uname.equals(p.name)) {
						find = true;
						System.out.print("��ǰ�� : " + p.name + "��(��) �������� ��ġ�ǰǰ���? : ");
						name = sc.nextLine();
						
						System.out.print("��ǰ�ܰ� : " + p.price + "��(��) �������� ��ġ�ǰǰ���? : ");
						price = sc.nextLine();
						
						System.out.print("�Ǹż��� : " + p.qnt + "��(��) �������� ��ġ�ǰǰ���? : ");
						qnt = sc.nextLine();
						
						System.out.println("��ǰ�� : " + name);
						System.out.println("��ǰ�ܰ� : " + price);
						System.out.println("�Ǹż��� : " + qnt);
						System.out.println("");
						System.out.print("���� ������ �����Ͻǰǰ��� (�� : Y , �ƴϿ� : N)? : ");
						sel = sc.next(); sc.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							if(!name.equals("")) {
								p.name = name;
							}
							if(!price.equals("")) { 
								p.price = Integer.parseInt(price);
							}
							if(!qnt.equals("")) {
								p.qnt = Integer.parseInt(qnt);
							}
							System.out.println("");
							p.print();
							System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
							break;
						}
						else if (sel.equals("N") || sel.equals("n") || sel.equals("��")) {
							System.out.println("����Ͽ����ϴ�.\n");
							break;
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ������ �ƴմϴ�.");
				}
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���.");
				break;
			}
		}
	}
}
