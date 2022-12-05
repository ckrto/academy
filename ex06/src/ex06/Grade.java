package ex06;

import java.text.DecimalFormat;

public class Grade {
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double avg;
	
	public Grade() {
		
	}
	
	public Grade(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int total() {
		tot = kor + eng + mat;
		
		return tot;
	}
	public String average() {
		DecimalFormat df = new DecimalFormat("###.00");
		avg = total() / (double) 3;

		return df.format(avg);
	}
	
	public void print() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + kor);
		System.out.println("���� : " + eng);
		System.out.println("���� : " + mat);
		System.out.println("���� : " + total());
		System.out.println("��� : " +average());
	}
	public void printList() {
		System.out.print(name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + total() + "\t" + average());
		System.out.println("");
	}

}
