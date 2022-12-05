package ex18;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AccountDAO accountdao = new AccountDAO();
		AccountVO accountvo = null;
		StatementDAO statementdao = new StatementDAO();
		StatementVO statementvo = null;
		
		int menu;
		int ano;
		int maxCode;
		int balance;
		int price;
		
		String sel;
		String aname;
		
		boolean run = true;
		
		while(run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.������ȸ | 4.�Ա� | 5.��� | 0.����");
			System.out.println("-----------------------------------------------------------");
			menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("");
			
			switch(menu) {
			case 1 : 
				maxCode = accountdao.getMaxCode();
				System.out.println("�����Ͻ� ������ ������ ���¹�ȣ�� " + maxCode + " �Դϴ�.");
				
				System.out.print("����Ͻ� �����ָ��� �Է����ּ���. : ");
				aname = sc.nextLine();
				
				if(aname.equals("")) {
					System.out.println("\n���»����� ����մϴ�.\n");
					break;
				}
				
				balance = Input.input("�ʱ��Աݾ��� �Է����ּ���. : ");
				System.out.println("");
				
				if(balance == 0) {
					System.out.println("�ʱ��Աݾ��� �Ա����ּž��մϴ�.\n");
				} else {
					System.out.print("����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
					sel = sc.nextLine();
					System.out.println("");
					
					if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
						accountvo = new AccountVO();
						accountvo.setAno(maxCode);
						accountvo.setAname(aname);
						accountvo.setBalance(balance);
						accountvo.setOdate(sdf.format(new Date()));
						accountdao.insert(accountvo);
						System.out.println("���ο� ���°� ��ϵǾ����ϴ�.");
					} 
					else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
						System.out.println("����� ��ҵǾ����ϴ�.");
					} 
					else {
						System.out.println("�ٽ� �������ּ���.");
					}
				}
				System.out.println("");
				break;
			case 2 :
				ArrayList<AccountVO> Accountarray = accountdao.list();
				System.out.println("���¹�ȣ\t�����ָ�\t�ܾ�\t���»�����");
				for(AccountVO account : Accountarray) {
					System.out.printf("%d\t%s\t%d\t%s\n", account.getAno(), account.getAname(), account.getBalance(), account.getOdate());
				}
				System.out.println("");
				break;
			case 3 :
				ano = Input.input("��ȸ�Ͻ� ���¹�ȣ�� �Է����ּ���. : ");
				accountvo = accountdao.read(ano);
				System.out.println("");
				
				if(accountvo.getAname() == null) {
					System.out.println("�˻��Ͻ� ���¹�ȣ�� �������� �ʽ��ϴ�.\n");
					break;
				} else {
					System.out.println("���¹�ȣ\t�����ָ�\t�ܾ�\t���»�����");
					System.out.printf("%d\t%s\t%d\t%s\n", accountvo.getAno(), accountvo.getAname(), accountvo.getBalance(), accountvo.getOdate());
					ArrayList<StatementVO> statementarray = statementdao.list(ano);
					System.out.println("\n--------------------����� ����--------------------");
					System.out.println("���¹�ȣ\t�������\tŸ��\t�ݾ�");
					for(StatementVO s : statementarray) {
						System.out.printf("%d\t%s\t%s\t%d\n", s.getAno(), s.getOdate(), s.getType(), s.getAmount());
					}
					System.out.println("");
				}
				
				System.out.println("");
				break;
			case 4 :
				ano = Input.input("�Ա��� �����Ͻ� ���¹�ȣ�� �Է����ּ���. : ");
				accountvo = accountdao.read(ano);
				System.out.println("�����ָ� : " + accountvo.getAname());
				System.out.println("�����ܾ� : " + accountvo.getBalance());
				price = Input.input("�Ա��Ͻ� �ݾ��� �Է����ּ���. : ");
				
				System.out.println("");
				
				System.out.print("�Ա��Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
				sel = sc.nextLine();
				System.out.println("");
				
				if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
					balance = price + accountvo.getBalance();
					accountdao.update(ano, balance);
					System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.\n");
					System.out.println("�Ա��� �ܾ��� : " + balance + " �Դϴ�.");
					System.out.println("");
					
					statementvo = new StatementVO();
					statementvo.setAno(ano);
					statementvo.setOdate(sdf.format(new Date()));
					statementvo.setType("�Ա�");
					statementvo.setAmount(price);
					statementdao.insert(statementvo);
					
					ArrayList<StatementVO> statementarray = statementdao.list(ano);
					System.out.println("--------------------����� ����--------------------");
					System.out.println("���¹�ȣ\t�������\tŸ��\t�ݾ�");
					for(StatementVO s : statementarray) {
						System.out.printf("%d\t%s\t%s\t%d\n", s.getAno(), s.getOdate(), s.getType(), s.getAmount());
					}
					System.out.println("");
					
				} 
				else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
					System.out.println("����� ��ҵǾ����ϴ�.");
				} 
				else {
					System.out.println("�ٽ� �������ּ���.");
				}

				break;
			case 5 :
				ano = Input.input("����� �����Ͻ� ���¹�ȣ�� �Է����ּ���. : ");
				accountvo = accountdao.read(ano);
				System.out.println("�����ָ� : " + accountvo.getAname());
				System.out.println("�����ܾ� : " + accountvo.getBalance());
				price = Input.input("����Ͻ� �ݾ��� �Է����ּ���. : ");
				
				System.out.println("");
				
				System.out.print("����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
				sel = sc.nextLine();
				System.out.println("");
				
				if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
					balance = accountvo.getBalance() - price;
					accountdao.update(ano, balance);
					
					statementvo = new StatementVO();
					statementvo.setAno(ano);
					statementvo.setOdate(sdf.format(new Date()));
					statementvo.setType("���");
					statementvo.setAmount(price);
					statementdao.insert(statementvo);
					
					ArrayList<StatementVO> statementarray = statementdao.list(ano);
					System.out.println("--------------------����� ����--------------------");
					System.out.println("���¹�ȣ\t�������\tŸ��\t�ݾ�");
					for(StatementVO s : statementarray) {
						System.out.printf("%d\t%s\t%s\t%d\n", s.getAno(), s.getOdate(), s.getType(), s.getAmount());
					}
					System.out.println("");
					
					System.out.println("��� �� �ܾ��� : " + balance + " �Դϴ�.");
					System.out.println("");
					
					System.out.println("����� �Ϸ�Ǿ����ϴ�.\n");
				} 
				else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
					System.out.println("����� ��ҵǾ����ϴ�.");
				} 
				else {
					System.out.println("�ٽ� �������ּ���.");
				}
				
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
