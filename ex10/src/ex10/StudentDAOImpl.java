package ex10;

import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO { // DAO�� �����ϴ� Ŭ����

	@Override
	public ArrayList<StudentVO> list() {
		ArrayList<StudentVO> array = new ArrayList();
		StudentVO vo = new StudentVO();
		vo.setNo(100);
		vo.setName("ȫ�浿");
		vo.setTel("010-0001-0001");
		vo.setAddress("��õ������ ����Ȧ�� �־ȵ�");
		array.add(vo);
		
		vo = new StudentVO();
		vo.setNo(200);
		vo.setName("��û��");
		vo.setTel("010-0002-0002");
		vo.setAddress("��õ������ ��籸 ��굿");
		array.add(vo);
		
		vo = new StudentVO();
		vo.setNo(300);
		vo.setName("������");
		vo.setTel("010-0003-0003");
		vo.setAddress("���� ������ ȭ�");
		array.add(vo);
		
		return array;
	} 
	
	@Override
	public StudentVO read(int no) {
		ArrayList<StudentVO> array = list();
		StudentVO vo = new StudentVO();
		for(StudentVO v : array) {
			if(no == v.getNo()) {
				vo.setNo(no);
				vo.setName(v.getName());
				vo.setTel(v.getTel());
				vo.setAddress(vo.getAddress());
			}
		}
		return vo;
	}

	@Override
	public void insert(StudentVO vo) {
		ArrayList<StudentVO> array = list();
		array.add(vo);
		
		for(StudentVO v:array) {
			System.out.println(v.toString());
		}
		
	}

	@Override
	public void delete(int no) {
		ArrayList<StudentVO> array = list();
		for(StudentVO v : array) {
			if(no==v.getNo()) {
				array.remove(v);
				break;
			}
		}
		for(StudentVO v:array) {
			System.out.println(v.toString());
		}
	}

	@Override
	public void update(StudentVO vo) {
		ArrayList<StudentVO> array = list();
		for(StudentVO v : array) {
			if(vo.getNo() == v.getNo()) {
				v.setName(vo.getName());
				v.setTel(vo.getTel());
				v.setAddress(vo.getAddress());
				break;
			}
		}
		for(StudentVO v : array) {
			System.out.println(v.toString());
		}
	}
	
}
