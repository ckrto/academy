package ex13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentDAO {
	File file = new File("c:/data/java/ex13/student.txt");
	
	public int getMaxNo() { // ������ ��ȣ�� �����ϱ� ���� �ż���
		int no = 0; // �ʱⰪ�� 0���� ����
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				no = Integer.parseInt(st.nextToken());
			}
		} catch(Exception e) {
			System.out.println("������ ���� : " + e.toString());
		}
		return no; // no���� �ٸ��������� ����ϱ����� return���� ��ȯ
	}
	
	public ArrayList<StudentVO> list() {
		ArrayList<StudentVO> array = new ArrayList<StudentVO>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				StudentVO vo = new StudentVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setName(st.nextToken());
				vo.setAddress(st.nextToken());
				array.add(vo);
			}
		} catch(Exception e) {
			System.out.println("�л���� : " + e.toString());
		}
		return array;
	}
	
	public void insert(StudentVO vo) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(vo.getNo() + "|" + vo.getName() + "|" + vo.getAddress() + "\n");
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("�л���� : " + e.toString());
		}
	}
	
	public StudentVO read(int no) {
		StudentVO vo = new StudentVO();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				vo.setNo(Integer.parseInt(st.nextToken()));
				if(no==vo.getNo()) {
					vo.setName(st.nextToken());
					vo.setAddress(st.nextToken());
					break;
				}
			}
		} catch(Exception e) {
			System.out.println("�˻� : " + e.toString());
		}
		return vo;
	}
	
}
