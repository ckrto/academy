package ex07;

import java.util.ArrayList;
import java.util.Scanner;

public class Example6 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		ArrayList<Score> scores = new ArrayList<>();
		
		String type;
		
		int no;
		int sno;
		int kor;
		int eng;
		int mat;
		int menu;
		
		boolean find = true;
		boolean run = true;
		
		no = 10;
		Student student = new Student();
		student.setNo(no);
		student.setName("ȫ�浿");
		student.setDept("����");
		students.add(student);
		
		Score score = new Score();
		score.setNo(no);
		score.setType("�߰�");
		score.setKor(90);
		score.setEng(90);
		score.setMat(90);
		scores.add(score);
		
		score = new Score();
		score.setNo(no);
		score.setType("�⸻");
		score.setKor(95);
		score.setEng(95);
		score.setMat(95);
		scores.add(score);
		
		while(run) {
			System.out.println("�ȳ��ϼ���. ����� ���� ���� �ý����Դϴ�. �Ʒ� �׸� �� �������ּ���.");
			System.out.println("----------------------------------------");
			System.out.println("1.�л���� | 2.�л��˻� | 3.������� | 0.����");
			System.out.println("----------------------------------------");
			System.out.print("�������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(menu) {
			case 1 :
				System.out.println("�ȳ��ϼ���. �л� ��� ���Դϴ�.");
				
				no = no + 1;
				student = new Student();
				System.out.println("�й��� " + no + "�� �Դϴ�.");
				student.setNo(no);
				
				System.out.print("�̸��� �Է����ּ���. : ");
				student.setName(sc.nextLine());
				
				System.out.print("�а��� �Է����ּ���. : ");
				student.setDept(sc.nextLine());
				students.add(student);
				
				System.out.println("����� �Ϸ�Ǿ����ϴ�.");
				System.out.println("");
				
				System.out.println("��ϵ� �л��� ���� " + students.size() + "�� �Դϴ�.\n");
				break;
			case 2 : 
				System.out.println("�ȳ��ϼ���. �л� �˻����Դϴ�.");
				System.out.print("�й��� �Է����ּ���. : ");
				sno = sc.nextInt(); sc.nextLine();
				System.out.println("");
				
				find = false;
				for(Student stu:students) {
					if(sno == stu.getNo()) {
						find = true;
						System.out.printf("�˻��Ͻ� %s(%s)���� �����Դϴ�.\n", stu.getName(), stu.getDept());
						System.out.println("����\t����\t����\t����\t����\t���");
						for(Score sco:scores) {
							if(sno == sco.getNo()) {
								System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n", sco.getType(), sco.getKor(), sco.getEng(), sco.getMat(), sco.getTot(), sco.getAvg());	
							}
						}
					}
				}
				if(find == false) {
					System.out.println("��ϵ� �л��� �ƴմϴ�.");
				}
				System.out.println("");
				break;
			case 3 :
				System.out.println("�ȳ��ϼ���. ���� ��� ���Դϴ�.");
				score = new Score();
				
				System.out.print("�й��� �Է����ּ���. : ");
				sno = sc.nextInt(); sc.nextLine();
				System.out.println("");
				
				score.setNo(sno);
				
				System.out.print("���� ������ �Է����ּ��� : ");
				type = sc.nextLine();
				score.setType(type);
				
				System.out.print("���������� �Է����ּ��� : ");
				kor = sc.nextInt(); sc.nextLine();
				score.setKor(kor);
				
				System.out.print("���������� �Է����ּ��� : ");
				eng = sc.nextInt(); sc.nextLine();
				score.setEng(eng);
				
				System.out.print("���������� �Է����ּ��� : ");
				mat = sc.nextInt(); sc.nextLine();
				score.setMat(mat);
				
				System.out.println("");
				
				scores.add(score);
				System.out.println("��������� �Ϸ�Ǿ����ϴ�.\n");
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �Է����ּ���.\n");
				break;
			}
		}
	}
}
