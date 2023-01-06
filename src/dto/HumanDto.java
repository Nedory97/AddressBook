package dto;

// Data Transfer Object   -> 쓰기, 읽기
// VO : Value Object      -> 읽기전용   
// 주소록에 한 명의 데이터를 담는 object
public class HumanDto {
	
	// 사람의 정보 항목(column)
	// 이름, 나이, 전화번호, 주소, 메모
	private String name;
	private int age;
	private String phone;
	private String address;
	private String memo;
	
	// 기본 생성자
	public HumanDto() {
		
		
	}

	public HumanDto(String name, int age, String phone, String address, String memo) {   // Source - Generate Constructor using Fields
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.memo = memo;
	}

	public String getName() {   // Source - Generate Getters and Setters
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {   // Generate toString() -> 데이터 출력
		return name + ":" + age + ":" + phone + ":" + address + ":" + memo;
	}
}
