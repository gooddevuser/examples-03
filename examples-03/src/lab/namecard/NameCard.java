package lab.namecard;

import java.io.Serializable;

//Serializable : 객체를 파일에 저장하기 위해 구현하는 인터페이스 (마커인터페이스 - 구현 메서드 X)
public class NameCard implements Serializable {
	
	private int no;
	private String name;
	private String phone;
	private String email;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		String info = 
			String.format("[%3d][%s][%s][%s]", no, name, phone, email);
		return info;
	}

}
