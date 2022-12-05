package ex16;

import java.util.ArrayList;
import java.util.Scanner;

public class Example4 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		TypeDAO tdao = new TypeDAO();
		ScoreDAO dao = new ScoreDAO();
		StudentVO svo = new StudentVO();
		StudentDAO sdao = new StudentDAO();
		
		int grade;
		int menu;
		int count = 0;
		
		String sno;
		String sel;
		String tcode;
		
		boolean isFind = false;
		boolean run = true;
		
		System.out.println("*************************** �� ��  �� �� ***************************");
		
		while(run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.������ȸ | 2.�����Է� | 3.�������� | 0.����");
			System.out.println("--------------------------------------------------------------");
			menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("");
			
			switch(menu) {
			case 1 :
				System.out.print("��ȸ�Ͻ� �л��� �й��� �Է����ּ���. : ");
				sno = sc.nextLine();
				System.out.println("");
				
				if(sno.equals("")) {
					System.out.println("��ȸ�� ����մϴ�.\n");
					break;
				}
				svo = sdao.read(sno);
				if(svo.getSname() == null) {
					System.out.println("�ش��л��� �������� �ʽ��ϴ�.\n");
					break;
				}
				
				System.out.printf("%s(%s)���� �����Դϴ�.\n", svo.getSname(), svo.getDname());
				System.out.println("----------------------------------------------------------");
				ArrayList<ScoreVO> array = dao.list(sno);
				System.out.println("��������(�����ڵ�)\t������\t\t��������");
				for(ScoreVO v : array) {
					System.out.printf("%s(%s)\t%s\t%s��\n", v.getTname(), v.getTcode(), v.getTdate(), v.getGrade());
				}
				System.out.println("");
				break;
			case 2 :
				System.out.print("��ȸ�Ͻ� �л��� �й��� �Է����ּ���. : ");
				sno = sc.nextLine();
				System.out.println("");
				
				if(sno.equals("")) {
					System.out.println("����� ����մϴ�.\n");
					break;
				}
				
				svo = sdao.read(sno);
				if(svo.getSname() == null) {
					System.out.println("�ش��л��� �������� �ʽ��ϴ�.\n");
					break;
				}
				
				System.out.printf("%s(%s)���� �����Դϴ�.\n", svo.getSname(), svo.getDname());
				System.out.println("----------------------------------------------------------");
				array = dao.list(sno);
				System.out.println("��������(�����ڵ�)\t������\t\t��������");
				
				for(ScoreVO v : array) {
					System.out.printf("%s(%s)\t%s\t%s��\n", v.getTname(), v.getTcode(), v.getTdate(), v.getGrade());
				}
				System.out.println("");
				
				ArrayList<TypeVO> tarray = tdao.list();
				for(TypeVO v : tarray) {
					System.out.printf("%s : %s | ", v.getTcode(), v.getTname());
				}
				System.out.println("");
				
				isFind = false;
				do {
					System.out.print("���������� �Է����ּ���. : ");
					tcode = sc.nextLine();
					System.out.println("");
					
					if(tcode.equals("")) {
						break;
					}
					
					count = dao.read(sno, tcode);
					if(count == 1) {
						break;
					}
					
					TypeVO tvo = tdao.read(tcode);
					if(tvo.getTname() != null) {
						isFind = true;
					}
					
				} while(isFind == false);
				
				if(tcode.equals("")) {
					System.out.println("��������� ����մϴ�.\n");
					break;
				}
				
				if(count == 1) {
					System.out.println("�̹� ��ϵ� �����Դϴ�.\n");
					break;
				}
				
				grade = Input.input("������ �Է����ּ���. : ");
				System.out.println("");
				
				ScoreVO vo = new ScoreVO();
				vo.setSno(sno);
				vo.setTcode(tcode);
				vo.setGrade(grade);
				
				dao.insert(vo);
				System.out.println("������ ��ϵǾ����ϴ�.");
				
				System.out.println("");
				break;
			case 3 :
				System.out.print("�����Ͻ� �л��� �й��� �Է����ּ���. : ");
				sno = sc.nextLine();
				System.out.println("");
				svo = sdao.read(sno);
				if(svo.getSname() == null) { 
					System.out.println("�ش��л��� ���������ʽ��ϴ�.");
					break;
				}
				System.out.printf("%s(%s)���� �����Դϴ�.\n", svo.getSname(), svo.getDname());
				array = dao.list(sno);
				for(ScoreVO v : array) {
					System.out.printf("%s(%s)\t%s\t%s��\n", v.getTname(), v.getTcode(), v.getTdate(), v.getGrade());
				}
				System.out.println("");
				do {
					System.out.print("���������� �Է����ּ���. : ");
					tcode = sc.nextLine();
					System.out.println("");
					
					if(tcode.equals("")) {
						break;
					}
					
					count = dao.read(sno, tcode);
					if(count == 0) {
						System.out.println("�����ҵ����Ͱ� �����ϴ�.\n");
					}
					else {
						break;
					}
				} while(true);
				
				if(tcode.equals("")) {
					System.out.println("������ ����մϴ�.\n");
					break;
				}
				
				System.out.print("������ �����Ͻðڽ��ϱ�(�� : Y | �ƴϿ� : N)? ");
				sel = sc.nextLine();
				System.out.println("");
				
				if(sel.equals("��") || sel.equals("Y") || sel.equals("y")) {
					dao.delete(sno, tcode);
					System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
				} else if(sel.equals("n") || sel.equals("N") || sel.equals("��")) {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
				} else {
					System.out.println("������ ��ҵǾ����ϴ�.\n");
				}
				break;
			case 0 :
				run = false;
				System.out.println("���θ޴��� ���ư��ϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���\n");
				break;
			}
		}
	}
}
