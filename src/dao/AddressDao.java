package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import data.FileProc;
import dto.HumanDto;
// Data Access Object
// 데이터를 접근하고 편집하는 object
public class AddressDao {
	
	Scanner sc = new Scanner(System.in);
	
	// 변수 100개 생성 - 객체(class) x
	private HumanDto humanArr[] = new HumanDto[100];
	private int count;
	
	private FileProc fp = null;   // composition(합성) - class 안에서 class를 생성

    public AddressDao() {
    	
    	// 변수들에 객체 생성
    	/*
    	for (int i = 0; i < humanArr.length; i++) {
			humanArr[i] = new HumanDto();
		}
		*/
    	
    	fp = new FileProc("address");
    	
    	
        fileload();
    	/*
    	humanArr[0] = new HumanDto("홍길동", 24, "123-1234", "서울시", "절친");
    	humanArr[1] = new HumanDto("성춘향", 16, "234-4456", "남원시", "여사친");
    	humanArr[2] = new HumanDto("일지매", 22, "323-4343", "부산시", "동호회");
    	humanArr[2] = new HumanDto("홍길동", 32, "431-4323", "고산면", "친구");
    	*/
        
        // 데이터를 새로 읽었을 때 배열의 할당되지 않은 공간을 검색
        int nextcount = 0;
        
        for (int i = 0; i < humanArr.length; i++) {
			// 생성된 객체 검사                 
			if (humanArr[i] != null ) {
				
				nextcount++;
			}
    	count = nextcount;
        }
	}
	
	// 추가, 삭제, 검색, 수정
	public void insert() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("지인을 추가합니다.");
	    System.out.print("이름 = ");
	    String name = sc.next();
	    
	    System.out.print("나이 = ");
	    int age = sc.nextInt();
	    
	    System.out.print("전화번호 = ");
	    String phone = sc.next();
	    
	    System.out.print("주소 = ");
	    String address = "";
	    try {
			address = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    System.out.print("메모 = ");
	    String memo = sc.next();
	    
		
	    // 변수들에 객체 생성시
	    /*
	    humanArr[0].setName(name);
	    humanArr[0].setAge(age);
	    humanArr[0].setPhone(phone);
	    humanArr[0].setAddress(address);
	    humanArr[0].setMemo(memo);
	    */
	    
	    // 생성 x 
	    humanArr[count] = new HumanDto(name, age, phone, address, memo );
	    count++;
	}
	
	public void delete() {
		
		System.out.print("삭제할 지인의 이름 = ");
		String name = sc.next();
		
		int index = serching(name);
		
		if(index == -1) {
			System.out.println("지인의 정보를 찾을 수 없습니다.");
		}
		else {
			// 삭제
			humanArr[index].setName("");
			humanArr[index].setAge(0);
			humanArr[index].setPhone("");
			humanArr[index].setAddress("");
			humanArr[index].setMemo("");
			
			System.out.println("지정한 지인을 삭제하였습니다.");
		}
		
	}
	
	public void select() {   // 동명이인을 찾는다
		
		System.out.print("검색할 지인의 이름 = ");
		String name = sc.next();
		
		int count = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
				count++;
			}
		}
		
		if(count < 1) {
			System.out.println("검색한 지인이 없습니다.");
			return;
		}
		
		HumanDto hdto[] = new HumanDto[count];
		
		int n = 0;
		for (int i = 0; i < humanArr.length; i++) {
			
			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
				hdto[n] = humanArr[i];
				n++;
			}
		}
		
		for (int i = 0; i < hdto.length; i++) {
			System.out.println(hdto[i].toString());
		}
	}
	
	public void update() {
		
		System.out.print("수정할 지인의 이름 : ");
		String name = sc.next();
		
		int index = serching(name);
		
		if(index == -1) {
			System.out.println("지인의 정보를 찾을 수 없습니다.");
			return;
		}
		
		// 수정
		int selNum = 0;
		System.out.print("변경할 항목 ([1]전화번호 / [2]주소 / [3]두 항목 모두)");
		selNum = sc.nextInt();
		
		// phone
		if(selNum == 1) {
			System.out.println("기존 전화번호 : " + humanArr[index].getPhone());
			System.out.print("변경할 전화번호를 입력 : ");
			String chedNum = sc.next();
			humanArr[index].setPhone(chedNum);
			System.out.println("전화번호 변경 완료!");
		}
		
		// address
		else if(selNum == 2) {
			System.out.println("기존 주소 : " + humanArr[index].getAddress());
			System.out.print("변경할 주소를 입력 : ");
			String chedAdd = sc.next();
			humanArr[index].setAddress(chedAdd);
			System.out.println("주소 변경 완료!");
			}
		
		// both
	    else if(selNum == 3) {
	    	
	    	// 번호
	    	System.out.println("기존 전화번호 : " + humanArr[index].getPhone());
			System.out.print("변경할 전화번호를 입력 : ");
			String chedNum = sc.next();
			humanArr[index].setPhone(chedNum);
			System.out.println("전화번호 변경 완료!");
			// 주소
			System.out.println("기존 주소 : " + humanArr[index].getAddress());
			System.out.print("변경할 주소를 입력 : ");
			String chedAdd = sc.next();
			humanArr[index].setAddress(chedAdd);
			System.out.println("주소 변경 완료!");
	    	
	    	}
		}
	
	public void allDataPrint() {
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && humanArr[i].getName().equals("") == false) {
				System.out.println(humanArr[i].toString()); 
			}
		}
	}
	
	public int serching(String name) {
		// 검색
		int index = -1;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && name.equals(humanArr[i].getName())) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	public void filesave() {
		// 실제 배열에 들어 있는 데이터
		int count = 0;
		for (int i = 0; i < humanArr.length; i++) {
			// 생성된 객체 검사                  삭제한 데이터 검사
			if (humanArr[i] != null && !humanArr[i].getName().equals("")) {
				
				count++;
				
			}
		}
		
		String dataArr[] = new String[count];
		/*
		    이름, 나이, 전화번호, 주소, 메모 
		*/
		
		count = 0;
		for (int i = 0; i < humanArr.length; i++) {
			if(humanArr[i] != null && !humanArr[i].getName().equals("")) {
				
				dataArr[count] = humanArr[i].toString();
				count++;
			}
		}
		
		fp.write(dataArr);
		System.out.println("파일에 저장되었습니다.");
	}
	
	public void fileload() {
		
		String datas[] = fp.read();
		/*
		for (String s : datas) {
			System.out.println(s);
		}
		*/
		
		for (int i = 0; i < datas.length; i++) {
		
			String split[] = datas[i].split(":");
		
			humanArr[i] = new HumanDto(split[0], Integer.parseInt(split[1]), split[2], split[3], split[4]);
		}
	}
}
