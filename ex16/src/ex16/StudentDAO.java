package ex16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO {
	Connection con = Database.getConnection();
	
	//����
	public boolean delete(String sno) {
		boolean success = false;
		try {
			String sql = "delete from tbl_student where sno = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			ps.execute();
			success = true;
		} catch(Exception e) {
		
		}
		return success;
	}
	
	//����
	public void update(StudentVO vo) {
		try {
			String sql = "update view_student set sname = ?, dcode = ? where sno = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getSname());
			ps.setString(2, vo.getDcode());
			ps.setString(3, vo.getSno());
			ps.execute();
		} catch(Exception e) {
			System.out.println("���� : " + e.toString());
		}
	}
	
	//Max Code ��������
	public String maxNo() {
		String maxNo = "";
		try {
			String sql = "select max(sno) mno from view_student";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString("mno");
			}
		} catch(Exception e) {
			System.out.println("Max Code : " + e.toString());
		}
		return maxNo;
	}
	
	//�Է�
	public void insert(StudentVO vo) {
		try {
			String sql = "insert into tbl_student(sno,sname,dcode) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getSno());
			ps.setString(2, vo.getSname());
			ps.setString(3, vo.getDcode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("�Է� : " + e.toString());
		}
	}
	
	//��ȸ
	public StudentVO read(String sno) {
		StudentVO vo = new StudentVO();
		try {
			String sql = "select * from view_student where sno = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				vo.setSno(rs.getString("sno"));
				vo.setSname(rs.getString("sname"));
				vo.setDcode(rs.getString("dcode"));
				vo.setDname(rs.getString("dname"));
			}
		} catch(Exception e) {
			System.out.println("��ȸ : " + e.toString());
		}
		return vo;
	}
	
	// ���
	public ArrayList<StudentVO> list() {
		ArrayList<StudentVO> array = new ArrayList<StudentVO>();
		try {
			String sql = "select * from view_student order by sno";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setSno(rs.getString("sno"));
				vo.setSname(rs.getString("sname"));
				vo.setDcode(rs.getString("dcode"));
				vo.setDname(rs.getString("dname"));
				array.add(vo);
			}
		} catch(Exception e) {
			System.out.println("��� : " + e.toString());
		}
		return array;
	}
}
