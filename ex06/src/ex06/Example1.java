package ex06;

public class Example1 {
	public static void execute() {
		Car car1 = new Car();
		car1.company = "����";
		car1.model = "���׽ý�";
		car1.maxSpeed = 300;
		car1.infoPrint();
		
		System.out.println("");
		
		Car car2 = new Car("���");
		car2.model = "K7";
		car2.maxSpeed = 250;
		car2.infoPrint();
		
		System.out.println("");
		
		Car car3 = new Car("�ֿ�", "Ƽ����", 230);
		car3.infoPrint();
	}
}