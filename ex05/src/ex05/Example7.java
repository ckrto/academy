package ex05;

import java.util.ArrayList;
import java.util.Scanner;

public class Example7 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Address> array = new ArrayList<>();
		String sname;
		int sel;
		
		boolean find = false;
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.�ּҵ�� | 2.�ּҰ˻� | 3.�ּҸ�� | 0. ����");
			System.out.println("-----------------------------------------");
			System.out.print("������ �۾��� �������ּ��� : ");
			sel = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(sel)	{
			case 1 :
				Address juso = new Address();
				
				System.out.print("�̸��� �Է����ּ��� : ");
				juso.name = sc.next(); sc.nextLine();
				
				System.out.print("�ּҸ� �Է����ּ��� : ");
				juso.address = sc.nextLine();
				
				System.out.print("��ȭ��ȣ�� �Է����ּ��� : ");
				juso.tel = sc.next(); sc.nextLine();
				array.add(juso);
				
				System.out.println("");
				
				break;
				
			case 2 : 
				System.out.print("�˻��Ͻ� �̸��� �Է����ּ���. : ");
				sname = sc.nextLine();
				System.out.println("");
				
				for(Address a:array) {
					if(sname.equals(a.name)) {
						a.print();
						find = true;
					}
				}
				if(find == false) {
					System.out.println("��ϵ� �̸��� �ƴմϴ�.");
				}
				break;
				
			case 3 : // ��ü �ּ� �����͸� ��� 
				for(Address a:array) { // array��� �ٱ��Ͽ��� �ϳ��� ���� a���� �ְڴ�.
					a.print();
				}
				break;
				
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.");
				break;
				
			default :
				System.out.println("0~3�� �޴��� �������ּ���.");
			}
		}
	}
}
