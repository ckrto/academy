package ex10;

import java.util.ArrayList;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		Scanner sc = new Scanner(System.in);
		ScoreDAO dao = new ScoreDAOImpl();
		ArrayList<ScoreVO> array = new ArrayList<>();
		ScoreVO vo = null;
		
		int no = 400;
		int dno;
		int uno;
		int menu;
		
		String sel;
		String newName;
		String newGrade;
			
		boolean run = true;
		
		vo = new ScoreVO();
		vo.setNo(100);
		vo.setName("ȫ�浿");
		vo.setGrade(90);
		array.add(vo);
		
		vo = new ScoreVO();
		vo.setNo(200);
		vo.setName("��û��");
		vo.setGrade(100);
		array.add(vo);
		
		vo = new ScoreVO();
		vo.setNo(300);
		vo.setName("������");
		vo.setGrade(100);
		array.add(vo);
		
		while(run) {
			System.out.println("1.��� | 2.�˻� | 3.��� | 4.���� | 5.���� |0.����");
			System.out.print("�޴��� �������ּ���. : ");
			menu = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			switch(menu) {
			case 1 : 
				System.out.println("������ ��ȣ�� " + no + " �� �Դϴ�.");
				vo = new ScoreVO();
				vo.setNo(no);
				
				System.out.print("�̸��� �Է����ּ��� : ");
				vo.setName(sc.nextLine());
				
				System.out.print("������ �Է����ּ��� : ");
				vo.setGrade(sc.nextInt()); sc.nextLine();
				
				dao.insert(vo, array);
				
				System.out.println(vo);
				System.out.println(array);
				System.out.println("���� ����� �Ϸ�Ǿ����ϴ�.");
				no += 100;
				System.out.println("");
				break;
			case 2 : 
				System.out.print("�˻��Ͻ� ��ȣ�� �Է����ּ���. : ");
				no = sc.nextInt(); sc.nextLine();
				vo = dao.read(no, array);
				
				if(vo.getName() == null) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.");
				}
				else {
					System.out.println(vo.toString());
				}
				
				System.out.println("");
				break;
			case 3 :
				System.out.println("�ý��� ����� ����Ʈ�Դϴ�.");

				for(ScoreVO v : array) {
					System.out.println(v.toString());
				}
				System.out.println("");
				break;
			case 4 :
				System.out.println("�����Ͻ� ��ȣ�� �Է����ּ��� : ");
				uno = sc.nextInt(); sc.nextLine();
				vo = dao.read(no, array);
				
				if(vo.getName() == null) {
					System.out.println("��ϵ� ����ڰ� �ƴմϴ�.\n");
				}
				else {
					System.out.println(vo.getName() + "�� �������� �ٲܱ��? : ");
					newName = sc.nextLine();
					System.out.println(vo.getGrade() + "�� �������� �ٲܱ��? : ");
					newGrade = sc.nextLine();
					
					if(!newName.equals(vo.getName())) {
						vo.setName(newName);
					}
					if(!newName.equals(vo.getGrade())) {
						vo.setGrade(Integer.parseInt(newGrade));
					}
					dao.update(vo, array);
					System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				}
				
				System.out.println("");
			break;
			case 5 : 
				System.out.print("�����Ͻ� ��ȣ�� �Է����ּ���. : ");
				dno = sc.nextInt(); sc.nextLine();
				
				for(ScoreVO v : array) {
					if(dno == v.getNo()) {
						dao.delete(dno, array);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						break;
					}
					else {
						System.out.println("��ϵ� ����ڰ� �ƴմϴ�.");
						break;
					}
				}
				
				System.out.println("");
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
