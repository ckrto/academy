package ex12;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###��");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		AccountVO vo = null;
		AccountDAO dao = new AccountDAOImpl();
		TradeDAO tdao = new TradeDAO();
		TradeVO tvo = null;
		
		int menu;
		int sno;
		int newNo;
		
		String ssno;
		String balance;
		
		boolean run = true;
		boolean isNumber = false;
		
		
		while(run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.���»��� | 2.������ȸ | 3.�Ա� | 4.��� | 5.���¸�� | 0.����");
			System.out.println("-----------------------------------------------------");
			System.out.print("������ �۾��� �������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(menu) {
			case 1 : 
				newNo = dao.getLastNo() + 100;
				System.out.println("������ ���¹�ȣ�� " + newNo + " �Դϴ�.");
				vo = new AccountVO();
				vo.setNo(newNo);
				
				System.out.print("�̸��� �Է����ּ���. : ");
				vo.setName(sc.nextLine());
				
				isNumber = false;
				do {
					System.out.print("�ʱ��Աݾ��� �Է����ּ���. : ");
					balance = sc.nextLine();
					isNumber = balance.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.print("�ʱ��Աݾ��� ���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				System.out.println("");
				
				vo.setBalance(Integer.parseInt(balance));
				dao.insert(vo);
				
				tvo = new TradeVO();
				tvo.setNo(newNo);
				tvo.setDate(sdf.format(new Date()));
				tvo.setType("�Ա�");
				tvo.setAmount(Integer.parseInt(balance));
				tdao.insert(tvo);
				
				System.out.println("���ο� ���°� �����Ǿ����ϴ�.\n");
	
				break;
			case 2 :
				isNumber = false;
				
				do {
					System.out.print("��ȸ�Ͻ� ���¹�ȣ�� �Է����ּ���. : ");
					ssno = sc.nextLine();
					System.out.println("");
					isNumber = ssno.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.println("���¹�ȣ�� ���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				
//				System.out.print("��ȸ�Ͻ� ���¹�ȣ�� �Է����ּ���. : ");
//				sno = sc.nextInt(); sc.nextLine();
//				System.out.println("");
//				0
				vo = dao.read(Integer.parseInt(ssno));
				
				if(vo.getName() == null) {
					System.out.println("��ȸ�Ͻ� ���°� �������� �ʽ��ϴ�.\n");
				} else {
					System.out.println("���¹�ȣ\t�����ָ�\t�ܾ�");
					balance = df.format(vo.getBalance());
					System.out.printf("%d\t%s\t%s\n", vo.getNo(), vo.getName(), balance);
					ArrayList<TradeVO> tarray = tdao.list(Integer.parseInt(ssno));
					System.out.println("------------------------------------------");
					for(TradeVO t : tarray) {
						String amount = df.format(t.getAmount());
						System.out.printf("%s\t%s\t%s\n", t.getDate(), t.getType(), amount);
					}
				}
				System.out.println("");
				break;
			case 3 : 
				isNumber = false;
				ssno = "";
				do {
					System.out.print("�Ա��� �����Ͻ� ���¹�ȣ�� �Է����ּ���. : ");
					ssno = sc.nextLine();
					System.out.println("");
					isNumber = ssno.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.println("���¹�ȣ�� ���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				
				vo = dao.read(Integer.parseInt(ssno));
				if(vo.getName() == null) {
					System.out.println("�Ա��� ���°� �������� �ʽ��ϴ�.");
				}
				else {
					System.out.println("�����ָ� : " + vo.getName());
					System.out.println("�����ܾ� : " + vo.getBalance());
					System.out.println("");
					System.out.print("�Ա��� �ݾ��� �Է����ּ��� : ");
					String price = sc.nextLine();
					
					System.out.println("");
					dao.trade(Integer.parseInt(ssno), Integer.parseInt(price));
					
					System.out.println("------------------------------------------");
					tvo = new TradeVO();
					tvo.setNo(Integer.parseInt(ssno));
					tvo.setDate(sdf.format(new Date()));
					tvo.setType("�Ա�");
					tvo.setAmount(Integer.parseInt(price));
					tdao.insert(tvo);
					
					System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
				}
				System.out.println("");
				break;
			case 4 : 
				isNumber = false;
				ssno = "";
				do {
					System.out.print("����� �����Ͻ� ���¹�ȣ�� �Է����ּ���. : ");
					ssno = sc.nextLine();
					System.out.println("");
					isNumber = ssno.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.println("���¹�ȣ�� ���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				
				vo = dao.read(Integer.parseInt(ssno));
				if(vo.getName() == null) {
					System.out.println("����� ���°� �������� �ʽ��ϴ�.");
				}
				else {
					System.out.println("�����ָ� : " + vo.getName());
					System.out.println("�����ܾ� : " + vo.getBalance());
					System.out.println("");
					System.out.print("����� �ݾ��� �Է����ּ��� : ");
					String price = sc.nextLine();
					
					System.out.println("");
					dao.trade(Integer.parseInt(ssno), (Integer.parseInt(price) * -1));

					System.out.println("------------------------------------------");
					tvo = new TradeVO();
					tvo.setNo(Integer.parseInt(ssno));
					tvo.setDate(sdf.format(new Date()));
					tvo.setType("���");
					tvo.setAmount(Integer.parseInt(price));
					tdao.insert(tvo);
					System.out.println("����� �Ϸ�Ǿ����ϴ�.");
				}
				System.out.println("");
				break;
			case 5 :
				ArrayList<AccountVO> array = dao.list();
				System.out.println("���¹�ȣ\t�����ָ�\t�ܾ�");
				for(AccountVO v : array) {
					balance = df.format(v.getBalance());
					System.out.printf("%d\t%s\t%s\n", v.getNo(), v.getName(), balance);
				}
				System.out.println("");
				System.out.println("��ü ���¼� : " + array.size() + "\n");
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
