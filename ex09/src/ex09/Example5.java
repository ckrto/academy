package ex09;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Example5 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		File file = new File("c:/data/java/score.txt");
		
		String sname;
		String dname;
		String line = "";
		String strLine = "";
		String sel;
		
		int menu;
		
		boolean find =  true;
		boolean run = true;
		
		System.out.println("�ȳ��ϼ���. ���� ���� �ý����Դϴ�. �Ʒ� �׸� �� �������ּ���.");
		
		while(run) {	
			System.out.println("------------------------------------------------");
			System.out.println("1.������� | 2.�����˻� | 3.������� | 4.�������� | 0.����");
			System.out.println("------------------------------------------------");
			System.out.print("�������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(menu) {
			case 1 :
				try {
					FileWriter writer = new FileWriter(file, true);
					Score score = new Score();
					
					System.out.print("�̸��� �Է����ּ��� : ");
					score.setName(sc.nextLine());
					
					System.out.print("���� ������ �Է����ּ��� : ");
					score.setKor(sc.nextInt()); sc.nextLine();
					
					System.out.print("���� ������ �Է����ּ��� : ");
					score.setEng(sc.nextInt()); sc.nextLine();
					
					System.out.print("���� ������ �Է����ּ��� : ");
					score.setMat(sc.nextInt()); sc.nextLine();
					
					writer.write(score.getName() + "|");
					writer.write(score.getKor() + "|");
					writer.write(score.getEng() + "|");
					writer.write(score.getMat() + "\n");
					writer.flush();
					writer.close();
				
					System.out.println("������ ��ϵǾ����ϴ�.\n");
					
				} catch(Exception e) {
					
				}
				break;
			case 2 :
				find = false;
				
				System.out.print("�̸��� �Է����ּ���. : ");
				sname = sc.nextLine();
				
				System.out.println("");
				
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					
					
					while((line=reader.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line, "|");
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));
						if(sname.equals(score.getName())) {
							find = true;
							System.out.println("�̸�\t����\t����\t����\t����\t���");
							score.printList();
						}
					}
					if(find == false) {
						System.out.println("��ϵ� �л��� �ƴմϴ�.");
					}
					reader.close();
					
				} catch(Exception e) {
					
				}
				System.out.println("");
				break;
			case 3 : 
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					System.out.println("�̸�\t����\t����\t����\t����\t���");
					
					while((line=reader.readLine()) != null){
						StringTokenizer st = new StringTokenizer(line, "|");
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));
						score.printList();
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
						Score score = new Score();
						score.setName(st.nextToken());
						score.setKor(Integer.parseInt(st.nextToken()));
						score.setEng(Integer.parseInt(st.nextToken()));
						score.setMat(Integer.parseInt(st.nextToken()));
						if(dname.equals(score.getName())) {	
							find = true;
						}
						else {
							strLine += score.getName() + "|";
							strLine += score.getKor() + "|";
							strLine += score.getEng() + "|";
							strLine += score.getMat() + "\n";	
						}
					}
					if(find == false) {
						System.out.println("��ϵ� �л��� �ƴմϴ�.");
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
