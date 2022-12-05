package Student;

import java.util.ArrayList;

public interface StudentDAO {
	
	//�Է�
	public void insert(StudentVO vo);
	
	//�˻�
	public StudentVO read(int no);
	
	//����
	public void delete(int no);
	
	//����
	public void update(StudentVO vo);

	//���
	public ArrayList<StudentVO> list();
	
	//������ �ڵ尪���ϱ�
	public int getCode();
}
