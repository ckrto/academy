package ex06;

import java.util.ArrayList;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Car>  cars = new ArrayList<>();
		
		Car car = new Car("���", "K7", 250);
		cars.add(car);
		
		car = new Car("���", "K5", 200);
		cars.add(car);
		
		String company;
		String model;
		String smodel;
		String dmodel;
		String umodel;
		String ncompany;
		String nmodel;
		String sel;
		String nmaxSpeed;
		
		int maxSpeed;
		int menu;
		
		boolean find = false;
		boolean run = true;
		
		System.out.println("�ȳ��ϼ��� �ڵ��� ���� �ý����Դϴ�.");
		
		while(run) {
			System.out.println("�Ʒ��� �׸��� �Ѱ����� �������ּ���.");
			System.out.println("-------------------------------");
			System.out.println("1.��� | 2.�˻� | 3.��� | 4.���� | 5.���� | 0.����");
			System.out.println("-------------------------------");
			System.out.print("������ �׸� : ");
			menu = sc.nextInt(); sc.nextLine();
			
			System.out.println("");
			
			switch(menu) {
			case 1 :
				System.out.print("ȸ����� �Է����ּ��� : ");
				company = sc.next(); sc.nextLine();
				
				System.out.print("�𵨸��� �Է����ּ��� : ");
				model = sc.next(); sc.nextLine();
				
				System.out.print("�ڵ����� �ִ� �ӵ��� �Է����ּ��� : ");
				maxSpeed = sc.nextInt(); sc.nextLine();
				
				car = new Car(company, model, maxSpeed);
				cars.add(car);
				
				System.out.println("��ϵ� ������ ���� " + cars.size() + " �Դϴ�. \n");
				break;
			case 2 :
				System.out.print("�˻��ϰ� ������ �𵨸��� �Է��ϼ��� : ");
				smodel = sc.next(); sc.nextLine();
				
				for(Car c:cars) {
					if(smodel.equals(c.model)) {
						find = true;
						c.infoPrint();
						System.out.println("");
					}
				}
				if(find == false) {
					System.out.println("��ϵ� ������ �ƴմϴ�.");
				}
				break;
			case 3 :
				System.out.println("ȸ���\t�𵨸�\t�ִ�ӵ�\t");
				for(Car c:cars) {
					System.out.println(c.company + "\t" + c.model + "\t" + c.maxSpeed + "\t");
				}
				System.out.println("");
				break;
			case 4 :
				System.out.print("������ ������ �𵨸��� �Է����ּ���. : ");
				dmodel = sc.next(); sc.nextLine();
				
				for(Car c:cars) {
					if(dmodel.equals(c.model)) {
						find = true;
						c.infoPrint();
						
						System.out.print("���� �����Ͻ� �ǰ���(�� : Y, �ƴϿ� : N)? : ");
						sel = sc.next(); sc.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							cars.remove(c);
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
			case 5 :
				System.out.print("������ ������ �𵨸��� �Է����ּ���. : ");
				umodel = sc.next(); sc.nextLine();
				
				for(Car c:cars) {
					if(umodel.equals(c.model)) {
						find = true;
						System.out.print("ȸ��� : " + c.company + "��(��) �������� ��ġ�ǰǰ���? : ");
						ncompany = sc.nextLine();
						
						System.out.print("�� : " + c.model + "��(��) �������� ��ġ�ǰǰ���? : ");
						nmodel = sc.nextLine();
						
						System.out.print("�ִ�ӵ� : " + c.maxSpeed + "��(��) �������� ��ġ�ǰǰ���? : ");
						nmaxSpeed = sc.nextLine();
						
						System.out.println("ȸ�� : " + ncompany);
						System.out.println("�� : " + nmodel);
						System.out.println("�ִ�ӵ� : " + nmaxSpeed);
						System.out.println("");
						System.out.print("���� ������ �����Ͻǰǰ��� (�� : Y , �ƴϿ� : N)? : ");
						sel = sc.next(); sc.nextLine();
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							if(!ncompany.equals("")) {
								c.company = ncompany;
							}
							if(!nmodel.equals("")) { 
								c.model = nmodel;
							}
							if(!nmaxSpeed.equals("")) {
								c.maxSpeed = Integer.parseInt(nmaxSpeed);
							}
							System.out.println("");
							c.infoPrint();
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
				System.out.println("�޴��� �ٽ� �������ּ���.\n");
				break;
			}
		}
	}
}
