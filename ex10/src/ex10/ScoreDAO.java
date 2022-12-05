package ex10;

import java.util.ArrayList;

public interface ScoreDAO {
	
	//��� ���
	public ArrayList<ScoreVO> list(ArrayList<ScoreVO> array);
	
	//�Է�
	public void insert(ScoreVO vo, ArrayList<ScoreVO> array);
	
	//�˻�
	public ScoreVO read(int no, ArrayList<ScoreVO> array);
	
	//����
	public void update(ScoreVO vo, ArrayList<ScoreVO> array);
	
	//����
	public void delete(int no, ArrayList<ScoreVO> array);
}
