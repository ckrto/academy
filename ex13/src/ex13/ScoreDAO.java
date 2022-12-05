package ex13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ScoreDAO {
	
	File file = new File("c:/data/java/ex13/score.txt");
	
	public void insert(ScoreVO svo) { // �л��� ���ο� ���� ������ �����ϱ� ���� �ż���
		try { // try ~ catch���� ����� ����ó���� �����ϰ� ����
			FileWriter writer = new FileWriter(file, true); // filewriter �ν��Ͻ��� ���Ӱ� �����ϰ� true������ ������ ���Ͽ� ���ο� ������ �߰�
			writer.write(svo.getNo() + "|" + svo.getType() + "|" + svo.getKor() + "|" + svo.getEng() + "|" + svo.getMat() + "\n");
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("���� �Է� : " + e.toString());
		}
	}
	
	public ScoreVO read(int no) { // �л��� ���� ������ �б� ���� �ż���
		ScoreVO svo = new ScoreVO(); // ScoreVO�� ����ϱ� ���� ���ο� �ν��Ͻ��� ����
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file)); // BufferedReader(����� ���͸� ���� �Է°��� �ޱ⶧���� ������ �ʿ䰡 ����)�� ����Ͽ� file�� ���� ����
			String line = ""; // line ������ ����
			while((line = bf.readLine()) != null) { // ������ line ������ file���� ���� ���� null���� �ƴҶ� while ���� ����
				StringTokenizer st = new StringTokenizer(line, "|"); // ���ο� StringTokenizer(���ڿ��� �츮�� ������ �����ڷ� ���ڿ��� �ɰ��ִ� Ŭ����) �ν��Ͻ��� �����ϰ� line�� ���� "|"�� ������
				svo.setNo(Integer.parseInt(st.nextToken()));
				if(no == svo.getNo()) { // �˻��� �й��� �ҷ��;��ϹǷ� Example1���� ���� no���� vo�� ����� no���� ���Ͽ� ������ if���� ����
					svo.setType(st.nextToken());
					svo.setKor(Integer.parseInt(st.nextToken()));
					svo.setEng(Integer.parseInt(st.nextToken()));
					svo.setMat(Integer.parseInt(st.nextToken()));
					break;
				}
			}
		} catch(Exception e) {
			System.out.println("���� �˻� : " + e.toString());
		}
		return svo; // svo���� �ٸ��������� ����ϱ����� return���� ��ȯ
	}
	
	public ArrayList<ScoreVO> list(int no) { // ��� �л��� ��� ���� ������ �б� ���� �ż���
		ArrayList<ScoreVO> sarray = new ArrayList<ScoreVO>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineNo = Integer.parseInt(st.nextToken());
				if(lineNo == no) {
					ScoreVO svo = new ScoreVO();
					svo.setNo(lineNo);
					svo.setType(st.nextToken());
					svo.setKor(Integer.parseInt(st.nextToken()));
					svo.setEng(Integer.parseInt(st.nextToken()));
					svo.setMat(Integer.parseInt(st.nextToken()));
					sarray.add(svo);
				}
			}
		} catch(Exception e) {
			System.out.println("������� : " + e.toString());
		}
		return sarray; // sarray ���� �ٸ��������� ����ϱ����� return���� ��ȯ
	}
}
