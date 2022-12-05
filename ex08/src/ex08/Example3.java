package ex08;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Example3 {
	public static void execute() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DecimalFormat df = new DecimalFormat("#,###��");
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Account> array = new ArrayList<>();
		ArrayList<Trans> tarray = new ArrayList<>();
		
		String date;
		String bal;
		String amount;
	
		int no;
		int sno;
		int menu;
		int balance;
		int input = 0;
		int withdraw = 0;
		
		boolean find = false;
		boolean run = true;
		
		Account acc = new Account();
		
		no = 100;
		acc.setNo(no);
		acc.setName("ȫ�浿");
		acc.setBalance(1000);
		acc.setOpenDate(new Date());
		array.add(acc);
		
		Trans tr = new Trans();
		tr.setNo(no);
		tr.setType("�Ա�");
		tr.setAmount(1000);
		tr.setDate(new Date());
		tarray.add(tr);
		
		acc = new Account();
		no = no + 100;
		acc.setNo(no);
		acc.setName("��û��");
		acc.setBalance(2000);
		acc.setOpenDate(new Date());
		array.add(acc);
		

		tr = new Trans();
		tr.setNo(no);
		tr.setType("�Ա�");
		tr.setAmount(2000);
		tr.setDate(new Date());
		tarray.add(tr);
		
		System.out.println("�ȳ��ϼ���. ���� ���� �ý����Դϴ�. �Ʒ� �׸� �� ������ �۾��� �������ּ���.");
		
		while(run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 0.����");
			System.out.println("------------------------------------------------------------");
			System.out.print("������ �۾��� �������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(menu) {
			case 1 :
				acc = new Account();
				no = no + 100;
				System.out.println("�ȳ��ϼ���. ���� ���� ���Դϴ�.\n");
				System.out.printf("������ ���¹�ȣ�� : %d �Դϴ�.\n", no);
				acc.setNo(no);
				
				System.out.print("������(�̸�)�� �Է����ּ���. : ");
				acc.setName(sc.nextLine());
				
				System.out.print("�ʱ� �Աݾ��� �Է����ּ���. : ");
				balance = sc.nextInt(); sc.nextLine();
				acc.setBalance(balance);
				
				acc.setOpenDate(new Date());
				array.add(acc);
				
				System.out.println("���°� �����Ǿ����ϴ�.");
				System.out.println("");
				break;
			case 2 :
				System.out.println("�ȳ��ϼ���. ���� ��� ���Դϴ�.\n");
				System.out.println("���¹�ȣ\t�̸�\t�ð�\t\t\t�ܾ�");
				for(Account ac:array) {
					date = sdf.format(ac.getOpenDate());
					bal = df.format(ac.getBalance());
					System.out.printf("%d\t%s\t%s\t%s\n", ac.getNo(), ac.getName(), date, bal);
				}
				System.out.println("");
				break;
			case 3 :
				find = false;
				
				System.out.println("�ȳ��ϼ���. �Ա� ���Դϴ�.\n");
				System.out.print("���¹�ȣ�� �Է����ּ��� : ");
				sno = sc.nextInt(); sc.nextLine();
				System.out.println("");
				
				for(Account ac:array) {
					if(sno == ac.getNo()) {
						find = true;
						System.out.println("������(�̸�)�� " + ac.getName() + " �Դϴ�.");
						
						bal = df.format(ac.getBalance());
						
						System.out.println("---------------------------------------------");
						System.out.println("����\t�������\t\t\t����ݾ�");
						System.out.println("---------------------------------------------");
						
						for(Trans ts:tarray) {
							if(sno == ts.getNo()) {
								date = sdf.format(ts.getDate());
								amount = df.format(ts.getAmount());
								System.out.printf("%s\t%s\t%s\n", ts.getType(), date, amount);
							}
						}
						
						System.out.println("");
						System.out.print("�Ա��� �ݾ��� �Է����ּ��� : ");
						input = sc.nextInt(); sc.nextLine();
						
						if(input > 0) {
							tr = new Trans();
							tr.setNo(sno);
							tr.setDate(new Date());
							tr.setType("�Ա�");
							tr.setAmount(input);
							tarray.add(tr);
							
							System.out.println("");
							ac.setBalance(ac.getBalance()+input);
							System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
						}
						
						
						
					}
				}
				
				if(find == false) {
					System.out.println("��ϵ������� �����Դϴ�.");
				}
				System.out.println("");
				break;
			case 4 :
				System.out.println("�ȳ��ϼ���. ��� ���Դϴ�.\n");
				System.out.print("���¹�ȣ�� �Է����ּ��� : ");
				sno = sc.nextInt(); sc.nextLine();
				System.out.println("");
				
				for(Account ac:array) {
					if(sno == ac.getNo()) {
						find = true;
						System.out.println("������(�̸�)�� " + ac.getName() + " �Դϴ�.");
						
						bal = df.format(ac.getBalance());
						
						System.out.println("---------------------------------------------");
						System.out.println("����\t�������\t\t\t����ݾ�");
						System.out.println("---------------------------------------------");
						
						for(Trans ts:tarray) {
							if(sno == ts.getNo()) {
								date = sdf.format(ts.getDate());
								amount = df.format(ts.getAmount());
								System.out.printf("%s\t%s\t%s\n", ts.getType(), date, amount);
								
							}
						}
						System.out.println("");
						
						System.out.print("����� �ݾ��� �Է����ּ��� : ");
						withdraw = sc.nextInt(); sc.nextLine();
						
						if(ac.getBalance() < withdraw) {
							System.out.println("");
							System.out.println("����Ͻ÷��� �Ͻô� �ݾ��� ���¿� �ִ� �ܾ׺��� �����ϴ�.");
							System.out.println("��ݿ� �����Ͽ����ϴ�.");
						}
						else {
							if(withdraw > 0) {
								tr = new Trans();
								tr.setNo(sno);
								tr.setDate(new Date());
								tr.setType("���");
								tr.setAmount(withdraw);
								tarray.add(tr);
								System.out.println("");
								
								ac.setBalance(ac.getBalance()-withdraw);
								System.out.println("����� �Ϸ�Ǿ����ϴ�.");
							}
						}
					}
				}
				
				
				if(find == false) {
					System.out.println("��ϵ������� �����Դϴ�.");
				}
				System.out.println("");
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default : 
				System.out.println("�޴��� �ٽ� �������ּ���. \n");
				break;
			}
		}
	}
}
