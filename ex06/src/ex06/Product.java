package ex06;

import java.text.DecimalFormat;

public class Product {
	DecimalFormat df = new DecimalFormat("#,###");
	String name;
	String grade = "";
	int price;
	int qnt;
	int sum;
	
	public Product(String name, int price, int qnt) {
		super();
		this.name = name;
		this.price = price;
		this.qnt = qnt;
	}
	
	public int sum() {
		sum = price * qnt;
		return sum;
	}
	
	public String grade() {
		if(sum() >= 1000000) {
			grade = "�ֿ��";
		}
		else if(sum() >= 500000) {
			grade = "���";
		}
		else {
			grade = "����";
		}
		return grade;
	}
	
	public void print() {
		System.out.println("��ǰ�̸� : " + name);
		System.out.println("��ǰ�ܰ� : " + df.format(price));
		System.out.println("�Ǹż��� : " + df.format(qnt));
		System.out.println("�ݾ� : " + df.format(sum()));
		System.out.println("�Ǹ� ��� : " + grade());
	}
	
	public void printList() {
		System.out.println(name + "\t" + df.format(price) + "\t\t\t" + df.format(qnt) + "\t\t\t" + df.format(sum()) + "\t\t\t" + grade());
	}
}
