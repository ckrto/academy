package ex10;

import java.util.ArrayList;

public interface StudentDAO { // Database Access Object �����Ϳ� �����ϱ����� ��ü
	//������ ��� ���
	public ArrayList<StudentVO> list();
	
	//������ �˻�
	public StudentVO read(int no);
	
	//������ ���
	public void insert(StudentVO vo);
	
	//������ ����
	public void update(StudentVO vo);
	
	//������ ����
	public void delete(int no);
	
}
