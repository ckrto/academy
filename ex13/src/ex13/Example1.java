package ex13;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {
	public static void execute() {
		Scanner sc = new Scanner(System.in); //�Է��� �ޱ� ���� Scanner ������ sc�� �ҷ��ͼ� ���
		StudentVO vo = new StudentVO(); // StudentVO�� ����ִ� �л� ������ ����ϱ� ���� vo�� �����Ͽ� ���
		StudentDAO dao = new StudentDAO(); // �л� ���� �������̽��� ����ϱ����� dao�� �����Ͽ� ���
		ScoreVO svo = new ScoreVO(); // ScoreVO�� ����ִ� �л����� ���� ������ ����ϱ� ���� svo�� �����Ͽ� ���
		ScoreDAO sdao = new ScoreDAO(); // �л����� ���� ���� �������̽��� ����ϱ� ���� dao�� �����Ͽ� ���
		
		int newNo; // ��������ȣ�� �������� dao Ŭ������ getMaxNo �ż��带 Ȱ���ϱ� ���� int ���� newNo�� �����Ͽ� ���
		
		String menu; // ����ڰ� ������ �۾��� �Է��Ͽ� switch~case ���� ����ϱ� ���� String ���� menu�� �����Ͽ� ���
		String sno; // ����ڰ� �л��� ��ȸ �� ����� ���� ����ϴ� String ����
		
		boolean isNumber = false; // ���ڰ� �´��� üũ�ϱ����� ����� boolean ���� isNumber�� ����
		boolean run = true; // while���� �����ϱ� ���� boolean ���� run�� ����
		
		while(run) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1.�л���� | 2.�л���ȸ | 3.�л���� | 4.������� | 0.����");
			System.out.println("--------------------------------------------------------");
			System.out.print("������ �۾��� �������ּ���. : ");
			menu = sc.nextLine(); // ������ �۾��� �����Ͽ� ���� ����
			
			System.out.println("");
			
			switch(menu) { // ���� menu�� ����� ���� ���� �ٸ� case ���� ���� 
			case "1" : // �л� ����� ���� ���Ǵ� case��
				vo = new StudentVO(); // StudentVO�� ����ϱ� ���� vo �ν��Ͻ�(��ü)�� ����
				newNo = dao.getMaxNo() + 100; // StudentDAO�� ����ִ� getMaxNo �ż��忡 100�� ���� newNo�� ����
				
				System.out.println("������ �й��� " + newNo + "�� �Դϴ�.");
				vo.setNo(newNo); // �й��� ����ڰ� ���ϴ� ���� �ƴ� �ý����� �ڵ����� ��������
				
				System.out.print("�̸��� �Է����ּ���. : ");
				vo.setName(sc.nextLine()); // ����ڰ� �Է��� �̸��� vo.setName�� ����
				
				System.out.print("�ּҸ� �Է����ּ���. : ");
				vo.setAddress(sc.nextLine()); // ����ڰ� �Է��� �ּҸ� vo.setAddress�� ����
				
				System.out.println("");
				
				dao.insert(vo); // StudentDAO�� �ִ� insert �ż��忡 vo���� ������ insert �ż��带 ����
				
				System.out.println("���ο� �л��� ��ϵǾ����ϴ�.\n");
				break;
			case "2" : 
				isNumber = false; // �й��� ���ڷ� �Է��ߴ��� Ȯ���� ����
				do {
					System.out.print("��ȸ�Ͻ� �л��� �й��� �Է����ּ���. : ");
					sno = sc.nextLine(); // ����ڰ� ��ȸ�� �й� ������ sno ������ ����
					System.out.println("");
					
					isNumber = sno.matches("-?\\d+(\\.\\d+)?"); // ���Խ��� Ȱ���Ͽ� ����ڰ� ��ȸ�� �й� ������ ������ sno�� ��
					if(isNumber == false) { // ���ڰ� �ƴϸ� if���� ����
						System.out.println("�й��� ���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false); // do~while������ �Է��� ������ �����϶����� while���� ����
				
				vo = dao.read(Integer.parseInt(sno)); // StudentDAO�� �ִ� read �ż��忡 String sno���� integer.parsInt�� ����� ��ȯ�Ͽ� ����
				
				if(vo.getName() == null) { // dao.read�� �����ϰ� sno���� vo�� ����� name�� ���Ͽ� null ���϶� if�� ����
					System.out.println("��ȸ�Ͻ� �л��� �������� �ʽ��ϴ�.");
				} else {
					System.out.println("�й�\t�̸�\t�ּ�");
					System.out.printf("%s\t%s\t%s\n", vo.getNo(), vo.getName(), vo.getAddress());
					
					ArrayList<ScoreVO> sarray = sdao.list(Integer.parseInt(sno)); // �Էµ� sno���� �´� ����� ������ ������ֱ� ���� arraylist�� sdao�� �ִ� list �ż��带 ����Ͽ� �˻��� ����� ���� ������ sarray�� ����
					
					System.out.println("\n" + vo.getName() + "���� �����Դϴ�.");
					System.out.println("-----------------------------------------------------");
					System.out.println("����\t����\t����\t����\t����\t���");
					for(ScoreVO s : sarray) { // sarray�� ScoreVO�� �ִ� ���������� ����
						s.print(); // sarray�� ����� ���� ������ ���
					}
				}
				
				System.out.println("");
				break;
			case "3" :
				ArrayList<StudentVO> array = dao.list(); // array�� StudentDAO�� list �ż��带 ����
				System.out.println("�й�\t�̸�\t�ּ�");
				for(StudentVO v : array) { // StudentVO�� ���� �ϳ��� ���� ���
					System.out.printf("%s\t%s\t%s\n", v.getNo(), v.getName(), v.getAddress());	
				}
				System.out.printf("\n��� �Ǿ��ִ� ��ü �л� ���� %d�� �Դϴ�.\n", array.size()); // size()�� ����Ͽ� array�� ũ��(�л� ��)�� ���
				System.out.println("");
				break;
			case "4" :
				svo = new ScoreVO(); // ScoreVO�� ����ϱ� ���� svo �ν��Ͻ� ����
				isNumber = false;
				do {
					System.out.print("������ �Է��Ͻ� �л��� �й��� �Է����ּ���. : ");
					sno = sc.nextLine();
					System.out.println("");
					
					isNumber = sno.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.println("�й��� ���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				svo.setNo(Integer.parseInt(sno));
				
				svo = sdao.read(Integer.parseInt(sno));
				vo = dao.read(Integer.parseInt(sno));
				
				if(vo.getName() == null) {
					System.out.println("��ȸ�Ͻ� �л��� �������� �ʽ��ϴ�.");
				} 
				else {
					System.out.print("���� ������ �Է����ּ���. : ");
					svo.setType(sc.nextLine());
					
					isNumber = false;
					String kor = "";
					do {
						System.out.print("���� ������ �Է����ּ���. : ");	
						kor = sc.nextLine();
						
						isNumber = kor.matches("-?\\d+(\\.\\d+)?");
						if(isNumber == false) {
							System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
						}
					} while(isNumber == false);
					svo.setKor(Integer.parseInt(kor));
					
					isNumber = false;
					String eng = "";
					do {
						System.out.print("���� ������ �Է����ּ���. : ");
						eng = sc.nextLine();
						
						isNumber = eng.matches("-?\\d+(\\.\\d+)?");
						if(isNumber == false) {
							System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
						}
					} while(isNumber == false);
					svo.setEng(Integer.parseInt(eng));
					
					isNumber = false;
					String mat = "";
					do {
						System.out.print("���� ������ �Է����ּ���. : ");
						mat = sc.nextLine();
						
						isNumber = mat.matches("-?\\d+(\\.\\d+)?");
						if(isNumber == false) {
							System.out.println("���� ������ ���ڷ� �Է����ּ���.\n");
						}
					} while(isNumber == false);
					svo.setMat(Integer.parseInt(mat));
					
					System.out.println("");
					
					sdao.insert(svo); // �Է¹��� ������(svo)�� ScoreDAO�� insert �ż��带 �����Ͽ� ����
					
					System.out.println("���ο� ������ ��ϵǾ����ϴ�.\n");
				}
				
				break;
			case "0" :
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
