package ex05;

public class Car {
	// Ŭ������ �⺻������ �ʵ�, �Ӽ�, ������, �޼ҵ带 ������.
	// �ʵ�, �Ӽ�
	String nation = "���ѹα�";
	String company;
	String model;
	String color;
	int maxSpeed;
	
		
	public Car() { // �⺻������
			
	}
	
	//�Ű������� �ٸ��� ���� �����ڶ� �Ȱ��� �ż������ ������ ������ �� �ִ� = �����ε�
	//this�� �ʵ带 ����Ų��.
	public Car(String model, String color, int maxSpeed) {
		super(); // �⺻�����ڸ� ������ ���� ���� �ִ´�.
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public Car(String company, String model, String color, int maxSpeed) { // �Ű�����
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public void carPrint() { // �޼ҵ�
		System.out.println("���� : " + nation);
		System.out.println("ȸ�� : " + company);
		System.out.println("�� : " + model);
		System.out.println("���� : " + color);
		System.out.println("�ִ�ӵ� : " + maxSpeed);		
	}
}