package ex10;

import java.util.ArrayList;

public class Example1 {
	public static void execute() {
		//�л� ��� ���
		StudentDAO dao = new StudentDAOImpl();
//		ArrayList<StudentVO> array = dao.list();
//		
//		System.out.println("��ü �л� �� : " + array.size());
//		for(StudentVO vo : array) {
//			System.out.println(vo.toString());
//		}
		
		//�л� �˻�
//		StudentVO vo = dao.read(100);
//		System.out.println(vo.toString());
		
		//�л� �Է�
//		StudentVO vo = new StudentVO();
//		vo.setNo(400);
//		vo.setName("������");
//		vo.setTel("010-0001-0002");
//		vo.setAddress("���� ������ �б�����");
//		dao.insert(vo);
		
		//�л� ����
//		dao.delete(100);
		
		//�л� ����
		StudentVO vo = new StudentVO();
		vo.setNo(100);
		vo.setName("��浿");
		vo.setTel("010-1111-1111");
		vo.setAddress("��õ������ ����Ȧ�� ���͵�");
		
		dao.update(vo);
		
	}
}
