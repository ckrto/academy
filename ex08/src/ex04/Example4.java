package ex04;

import java.util.ArrayList;
import java.util.Scanner;

public class Example4 {
	public static void execute() {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> arrStudent = new ArrayList<>();
		ArrayList<Score> arrScore = new ArrayList<>();
		
		String type;
		
		int grade;
		int menu;
		int no;
		int sno;
		int sum = 0;
		int count = 0;
		double avg;
		
		boolean run = true;
		boolean find = false;
		
		no = 100;
		Student student = new Student();
		student.setNo(no);
		student.setName("ȫ�浿");
		student.setAvg(90);
		arrStudent.add(student);
		
		Score score = new Score();
		score.setNo(no);
		score.setType("�߰�");
		score.setGrade(70);
		arrScore.add(score);
		
		score = new Score();
		score.setNo(no);
		score.setType("�⸻");
		score.setGrade(90);
		arrScore.add(score);
		
		no = no + 100;
		student = new Student();
		student.setNo(no);
		student.setName("��û��");
		student.setAvg(45);
		arrStudent.add(student);
		
		System.out.println("�ȳ��ϼ���. ���� ���� �ý����Դϴ�.");
		
		while(run) {
			System.out.println("-------------------------------");
			System.out.println("1.������� | 2.�����˻� | 0.����");
			System.out.println("-------------------------------");
			System.out.print("������ �۾��� �������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(menu)	{
			case 1 :
				find = false;
				
				System.out.println("�ȳ��ϼ���. ���� ��� ���Դϴ�.");
				System.out.print("������ ����Ͻ� �л��� �й��� �Է����ּ���. : ");
				sno = sc.nextInt(); sc.nextLine();
				System.out.println("");
				
				for(Student st:arrStudent) {
					if(sno == st.getNo()) {
						find = true;
						System.out.println("�л� �̸� : " + st.getName());
						System.out.println("��� : " + st.getAvg());
						
						System.out.println("----------------");
						System.out.println("����\t����");
						System.out.println("----------------");
						
						for(Score sco:arrScore) {
							if(sno==sco.getNo()) {
								System.out.printf("%s\t%d\n", sco.getType(), sco.getGrade());
								count++;
								sum = sum + sco.getGrade();
							}
						}
						System.out.println("");
						
						System.out.print("������ ������ �Է����ּ��� : ");
						type = sc.nextLine();
								
						System.out.print("������ �Է����ּ��� : ");
						grade = sc.nextInt(); sc.nextLine();
						System.out.println("");
								
						score = new Score();
						score.setNo(sno);
						score.setType(type);
						score.setGrade(grade);
						arrScore.add(score);
						
						sum = sum + grade;
						avg = sum/(count+1);
						st.setAvg(avg);
						
						System.out.println("���� ����� �Ϸ�Ǿ����ϴ�.\n");
					}
				}
				if(find == false) {
					System.out.println("��ϵ� �л��� �����ϴ�.");
				}
				break;
			case 2 :
				find = false;
				
				System.out.println("�ȳ��ϼ���. ���� �˻� ���Դϴ�.");
				System.out.print("�˻��Ͻ� �л��� �й��� �Է����ּ���. : ");
				sno = sc.nextInt(); sc.nextLine();
				System.out.println("");
				
				for(Student st:arrStudent) {
					if(sno == st.getNo()) {
						find = true;
						System.out.println("�л� �̸� : " + st.getName());
						System.out.println("��� : " + st.getAvg());
						
						System.out.println("----------------");
						System.out.println("����\t����");
						System.out.println("----------------");
						
						for(Score sco:arrScore) {
							if(sno==sco.getNo()) {
								System.out.printf("%s\t%d\n", sco.getType(), sco.getGrade());
							}
						}
						System.out.println("");
					}
				}
				if(find == false) {
					System.out.println("��ϵ� �л��� �����ϴ�.");
				}
				
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
