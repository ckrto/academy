package ex08;

public class Example1 {
	public static void execute() {
		System.out.println("********** �� �� �� �� **********");
		
		People p1 = new People();
		p1.setJno("123456-1234567");
		p1.setName("ȫ�浿");
		p1.print();
		System.out.println("");
		
		People p2 = new People("456789-1234567", "��û��");
		p2.print();
		System.out.println("");
		
		Student s1 = new Student();
		s1.setJno("000001-0000001");
		s1.setName("������");
		s1.setSno("88001");
		System.out.println("�ֹι�ȣ : " + s1.getJno());
		System.out.println("�̸� : " + s1.getName());
		System.out.println("�й� : " + s1.getSno());
		System.out.println("");
		
		Student s2 = new Student("0000002-0000000", "�̼���", "87001");
		s2.print();
	}
}
