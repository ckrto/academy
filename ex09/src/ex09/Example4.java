package ex09;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Example4 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		File file = new File("c:/data/java/address.txt");
		
		String line = "";
		String strLine = "";
		String sname;
		String dname;
		String sel;
		
		int menu;
		
		boolean find = false;
		boolean run = true;
		
		System.out.println("�ȳ��ϼ��� �ּҰ��� �ý����Դϴ�.\n");
		
		while(run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.�ּҵ�� | 2.�ּҰ˻� | 3.�ּҸ�� | 4.�ּһ��� | 0.����");
			System.out.println("---------------------------------------------------");
			System.out.print("���� �ϽǸ� �������ּ��� : ");
			menu = sc.nextInt(); sc.nextLine();	
			System.out.println("");
			
			switch(menu) {
			case 1 :
				Address add = new Address();
				System.out.print("�̸��� �Է����ּ���  : ");
				add.setName(sc.nextLine());
				System.out.print("��ȭ��ȣ�� �Է����ּ��� : ");
				add.setTel(sc.nextLine());
				System.out.print("�ּҸ� �Է����ּ��� : ");
				add.setJuso(sc.nextLine());
				System.out.println("");
				
				try {
					FileWriter writer = new FileWriter(file, true);
					writer.write(add.getName() + "|" + add.getTel() + "|" +  add.getJuso() + "\n");
					writer.flush();
					writer.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 2 :
				find = false;
				
				System.out.print("�˻��Ͻ� �̸��� �Է����ּ��� : ");
				sname = sc.nextLine();
				
				System.out.println("");
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, "|");
						add = new Address();						
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());
						if(sname.equals(add.getName())) {
							find = true;
							add.printList();	
						}
					}
					reader.close();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(find == false) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.");
				}
				System.out.println("");
				break;
			case 3 :
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, "|");
						add = new Address();						
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());
						add.printList();
					}
					reader.close();
					
				} catch (Exception e) {
					
				}
				System.out.println("");
				break;
			case 4 :
				find = false;
				
				System.out.print("������ �̸��� �Է����ּ��� : ");
				dname = sc.nextLine();
				System.out.println("");
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					while((line = reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, "|");
						add = new Address();
						add.setName(st.nextToken());
						add.setTel(st.nextToken());
						add.setJuso(st.nextToken());
						if(dname.equals(add.getName())) {	
							find = true;
						}
						else {
							strLine += add.getName() + "|";
							strLine += add.getTel() + "|";
							strLine += add.getJuso() + "\n";	
						}
					}
					if(find == false) {
						System.out.println("��ϵ� ����ڰ� �ƴմϴ�.");
					} else {
						System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y, �ƴϿ� : N)? ");
						sel = sc.nextLine();
						System.out.println("");
						
						if(sel.equals("Y") || sel.equals("y") || sel.equals("��")) {
							FileWriter writer = new FileWriter(file, false);
							writer.write(strLine);
							writer.flush();
							writer.close();
							
							System.out.println(dname + "���� ���� �Ǿ����ϴ�.\n");
							break;
						}
						else if(sel.equals("N") || sel.equals("n") || sel.equals("��")) {
							System.out.println("������ ����Ͽ����ϴ�.\n");
							break;
						}
					}
				} catch (Exception e) {
					
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
