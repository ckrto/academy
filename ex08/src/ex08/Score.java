package ex08;

public class Score extends Stu {
	private int grade;
	private String type;
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override // �θ𿡼� ������ ������ �ڽĿ��� ���Ӱ� �����ϴ� ��
	public void print() {
		super.print();
		System.out.println("���� : " + type);
		System.out.println("���� : " + grade);
	}
}
