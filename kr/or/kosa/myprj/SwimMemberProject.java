package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SwimMemberProject {
	static ArrayList<SwimMemberVO> memberList = new ArrayList<>();
	static ArrayList<SwimMemberVO> copyMember = new ArrayList<>();
	static Scanner scan = new Scanner(System.in); 
	static int insertCount, updateCount, deleteCount = 0;
	static boolean isInserted, isUpdated, isDeleted = false;
	
	public static void main(String[] args) {
		
		String fileName = "SwimMember.csv";
		String smenu = "";
		try {
			LeftSwimMotion();
			System.out.println("프로그램이 실행되었습니다. 파일에서 데이터를 불러옵니다.");
			System.out.println("파일명 : " + fileName);
			load(fileName);
			objectCopy();
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		while(true) {
			System.out.println("############################################################################################################################################");
			System.out.println("####################################################  수 영 장   회 원   관 리    프 로 그 램  ####################################################");
			System.out.println("############################################################################################################################################");
			System.out.println("#################################################################  메 뉴  ###################################################################");
			System.out.println("############################################################################################################################################");
			System.out.printf("##########################                                 ** %-15s%3s **                              ###########################\n\n","Total Member : ", memberList.size());
			System.out.printf("\t\t\t   | %s%15s | %s%15s | %s%15s |\n", "1. ", "Insert", "2. ","save To CSV", "3. ", "List Print");
			System.out.printf("\t\t\t   | %s%15s | %s%15s | %s%15s | %s%15s |\n", "4. ", "Update", "5. ", "Delete", "6. ", "Search", "0. ", "Exit");
			System.out.println("##########################                                                                                       ###########################");
			System.out.println("############################################################################################################################################");
			System.out.print("메뉴를 입력하세요 >>> ");
			smenu = scan.nextLine();
			int menu = Integer.parseInt(smenu);

			switch (menu) {
			//삽입
			case 1:
				try {
					insert();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			//csv 저장
			case 2:
				try {
					save(fileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			//전체 출력, 다음, 이전 출력
			case 3:
				printAll();
				System.out.printf("\n");
				break;

			//데이터 수정
			case 4:
				System.out.printf("수정할 인덱스를 입력해 주세요. ( 0 ~ %d )\n", memberList.size()-1);
				System.out.print(">>> ");
				String SearchIndex = scan.nextLine();
				int searchIndex = Integer.parseInt(SearchIndex);
				try {
					update(searchIndex);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("인덱스가 범위를 벗어났습니다.");
				}
				break;

			//데이터 삭제
			case 5:
				System.out.printf("삭제할 인덱스를 입력해 주세요. ( 0 ~ %d )\n", memberList.size()-1);
				System.out.print(">>> ");
				String DeleteIndex = scan.nextLine();
				int deleteIndex = Integer.parseInt(DeleteIndex);
				try {
					delete(deleteIndex);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("인덱스가 범위를 벗어났습니다.");
				}
				break;

			//데이터 조회
			case 6:
				System.out.println("검색할 이름을 입력해 주세요.");
				System.out.print(">>> ");
				String searchName = scan.nextLine();
				search(searchName);
				break;

			//프로그램 종료
			case 0:
				try {
					exit(fileName);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			}//end switch
		}//end while
	}//end main

	//수영모션
	static void SwimMotion() throws Exception{
		for(int i = 0; i < 3; i++) {
			LeftSwimMotion();
			Thread.sleep(500);
			RightSwimMotion();
			Thread.sleep(1000);
		}
	}
	
	//수영 왼쪽
	static void LeftSwimMotion() {
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("##########################################################################################################    #############################");
		System.out.println("##########       ##########  #######   #######  ##########      ##########    #######    ############### ###### ###########################");
		System.out.println("##########  ################  #####  #  #####  #############  ############  #  #####  #  ############## ##    ## ##################       #");
		System.out.println("##########       ############  ###  ###  ###  ##############  ############  ##  ###  ##  #################                        ######## ");
		System.out.println("###############  #############  #  #####  #  ###############  ############  ###  #  ###  ############  ##  ##  ##  ##  ##  ##  ##  ##  ####");
		System.out.println("##########       ##############   #######   ##############      ##########  ####   ####  ##########  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
	}
	
	//수영 오른쪽
	static void RightSwimMotion() {
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("##########################################################################################################    #############################");
		System.out.println("##########       ##########  #######   #######  ##########      ##########    #######    ############### ###### ###########################");
		System.out.println("##########  ################  #####  #  #####  #############  ############  #  #####  #  ############## ##    ## #################        #");
		System.out.println("##########       ############  ###  ###  ###  ##############  ############  ##  ###  ##  #################                        ######## ");
		System.out.println("###############  #############  #  #####  #  ###############  ############  ###  #  ###  ############  ##  ##  ##  ##  ##  ##  ##  ##  ####");
		System.out.println("##########       ##############   #######   ##############      ##########  ####   ####  ##########  ##  ##  ##  ##  ##  ##  ##  ##  ##  ##");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
		System.out.println("###########################################################################################################################################");
	}
	
	//데이터 삽입
	static void insert() throws IOException {
		System.out.println("수영장의 새로운 회원정보를 입력합니다.");
		String name = "", sex = "", phone = "",  period = "", address = "";
		int age = 0;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss a");

		name = nameChk(name);
		age = ageChk(age);
		sex = sexChk(sex);
		phone = phoneChk(phone);
		period = date.format(today) + " " + time.format(today); 
		address = addressChk(address);
		SwimMemberVO member = new SwimMemberVO(name, age, sex, phone, period, address);
		memberList.add(member);

		insertCount++;
		isInserted = true;

		System.out.printf("※※새로운 회원이 등록되었습니다.※※\n\n");
	}//end insert

	//데이터 저장
	static void save(String fileName) throws IOException {
		FileWriter writer = new FileWriter(fileName);

		System.out.print("회원정보를 저장하시겠습니까? (Y / N) : ");
		String saveCheck = scan.nextLine();

		if("Y".equals(saveCheck) || "y".equals(saveCheck) || "ㅛ".equals(saveCheck)) {
			for(SwimMemberVO member : memberList) {
				writer.write(member.toCSV());
				writer.write('\n');
			}
			System.out.println("파일이 저장되었습니다.");
		} else if("N".equals(saveCheck) || "n".equals(saveCheck) || "ㅜ".equals(saveCheck)){
			for(SwimMemberVO member : copyMember) {
				writer.write(member.toCSV());
				writer.write('\n');
			}
			System.out.printf("파일을 저장하지 않았습니다.\n");
		}
		writer.flush();
		writer.close();
		insertCount = 0; updateCount = 0; deleteCount = 0;
		isInserted = false; isUpdated = false; isDeleted = false;
	}//end save

	//데이터 불러오기
	static void load(String fileName) throws IOException{
		FileReader reader = new FileReader(fileName);
		BufferedReader br = new BufferedReader(reader);
		String line = null;

		while((line = br.readLine()) != null) {
			String[] datas = line.split(",");
			String name = datas[0];
			int age = Integer.parseInt(datas[1]);
			String sex = datas[2];
			String phone = datas[3];
			String period = datas[4];
			String address = datas[5];
			
			SwimMemberVO member = new SwimMemberVO(name, age, sex, phone, period, address);
			memberList.add(member);
		}
		reader.close();
		br.close();
	}//end load

	//전체 데이터 출력
	static void printAll() {
		System.out.println("###########################################################################################################################################");
		System.out.println("############################################################# 수영장 회원 목록 출력 #############################################################");
		System.out.println("###########################################################################################################################################");

		int i = 0, count = 0;
		String control = "";
		while(i >= -1) {
			try {
				if(count == 0) {
					System.out.println("첫번째 회원입니다.");
					System.out.printf("\t\t\t  %-5s | %-5s  | %-5s | %-5s | %-15s | %-30s | %-50s \n", "index", "name", "age", "sex", "phone", "period", "address");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.printf("\t\t\t %5d  | %-5s | %-5d | %-5s |", i, memberList.get(i).getName(), memberList.get(i).getAge(), memberList.get(i).getSex());
					System.out.printf(" %-15s | %-30s | %-50s \n", memberList.get(i).getPhone(), memberList.get(i).getPeriod(), memberList.get(i).getAddress());
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					count++;
				}
				
				System.out.printf("전체 회원은 A(All), 다음 회원은 N(Next), 이전 회원은 P(Previous), 메뉴로 돌아가기는 E(Exit) || (%d / %d)", i+1, memberList.size());
				System.out.print(">>> ");
				control = scan.nextLine();
				System.out.println();
				if("n".equals(control) || "N".equals(control)) {	//다음 회원
					i++;
				} else if("p".equals(control) || "P".equals(control)) {	//이전 회원
					i--;
				} else if("a".equals(control) || "A".equals(control)) {	//전체 회원 
					i = 0;
					System.out.printf("\t\t\t  %-5s | %-5s  | %-5s | %-5s | %-15s | %-30s | %-50s \n", "index", "name", "age", "sex", "phone", "period", "address");
					System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
					for(SwimMemberVO member : memberList) {
						System.out.printf("\t\t\t %5d  | %-5s | %-5d | %-5s |", i, member.getName(), member.getAge(), member.getSex());
						System.out.printf(" %-15s | %-30s | %-50s \n",  member.getPhone(), member.getPeriod(), member.getAddress());
						System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
						i++;
					}
					break;
				} else if("e".equals(control) || "E".equals(control)){
					System.out.println("#########################################################");
					System.out.println("##################### 메뉴로 돌아갑니다.######################");
					System.out.println("#########################################################");
					System.out.println();
					break;
				} else {	//입력 오류
					System.out.println("#########################################################");
					System.out.println("############# 잘못 입력하셨습니다. 다시 입력해 주세요.##############");
					System.out.println("#########################################################");
					continue;
				}
				
				System.out.printf("\t\t\t  %-5s | %-5s  | %-5s | %-5s | %-15s | %-30s | %-50s \n", "index", "name", "age", "sex", "phone", "period", "address");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf("\t\t\t %5d  | %-5s | %-5d | %-5s |", i, memberList.get(i).getName(), memberList.get(i).getAge(), memberList.get(i).getSex());
				System.out.printf(" %-15s | %-30s | %-50s \n", memberList.get(i).getPhone(), memberList.get(i).getPeriod(), memberList.get(i).getAddress());
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.println();
				
				
			} catch(IndexOutOfBoundsException e) {
				if(i < 0) {
					System.out.println("이전 회원정보가 없습니다.");	
				} else {
					System.out.println("다음 회원정보가 없습니다.");
				}
				break;
			}
		} //end while
	}//end printAll

	//데이터 수정
	static void update(int searchIndex) {
		if(searchIndex < 0 || searchIndex >= memberList.size()) {
			throw new IndexOutOfBoundsException(searchIndex);
		}

		String name="", sex="", phone="", address=""; int age = 0;

		SwimMemberVO member = memberList.get(searchIndex);
		System.out.print("이름(" + member.getName() + ") ");
		name = nameChk(name); member.setName(name);

		System.out.print("나이(" + member.getAge() + ") ");
		age = ageChk(age); member.setAge(age);

		System.out.print("성별(" + member.getSex() + ") ");
		sex = sexChk(sex); member.setSex(sex);

		System.out.print("연락처(" + member.getPhone() + ") ");
		phone = phoneChk(phone); member.setPhone(phone);

		System.out.print("주소(" + member.getAddress() + ") ");
		address = addressChk(address); member.setAddress(address);

		System.out.println("인덱스 " + searchIndex + "이 수정되었습니다.");
		updateCount++;
		isUpdated = true;
	}//end update

	//데이터 삭제
	static void delete(int index) {
		if(index < 0 || index >= memberList.size()) {
			throw new IndexOutOfBoundsException(" : " + index);
		}
		System.out.println("정말로 삭제하시겠습니까? (Y / N)");
		System.out.print(">>> ");
		String check = scan.nextLine();

		if("n".equals(check) || "N".equals(check)) {
			System.out.println("삭제를 취소하였습니다.");
		} else if("y".equals(check) || "Y".equals(check)) {
			memberList.remove(index);
			System.out.println("삭제가 완료되었습니다.");

			deleteCount++;
			isDeleted = true;
		} else {
			System.out.println("잘못 입력하였습니다.");
		}
	}//end delete

	//데이터 찾기
	static void search(String searchName) {
		int searchCount = 0, i = 0;
		System.out.printf("\t\t\t  %-5s | %-5s  | %-5s | %-5s | %-15s | %-30s | %-50s \n", "index", "name", "age", "sex", "phone", "period", "address");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
		for(SwimMemberVO member : memberList) {
			if(searchName.equals(member.getName())) {
				System.out.printf("\t\t\t %5d  | %-5s | %-5d | %-5s |", i, member.getName(), member.getAge(), member.getSex());
				System.out.printf(" %-15s | %-30s | %-50s \n",  member.getPhone(), member.getPeriod(), member.getAddress());
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
				searchCount++; i++;
			}
		}
		if(searchCount == 0) {
			throw new RuntimeException("찾는 데이터가 없습니다.");
		}
	}//end search

	//프로젝트 종료
	static void exit(String fileName) throws IOException {
		if(isInserted || isUpdated || isDeleted) {
			try {
				System.out.println(insertCount + "개가 입력되었습니다.");
				System.out.println(updateCount + "개가 수정되었습니다.");
				System.out.println(deleteCount + "개가 삭제되었습니다.");
				save(fileName);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		scan.close();
		System.out.println("프로그램을 종료합니다.");
		System.out.println("감사합니다.");
		System.exit(0);
	}//end exit

	//이름 유효성 검사
	static String nameChk(String name) {
		while(true) {
			int count = 0;
			System.out.print(">>> 이름 : ");
			name = scan.nextLine();

			if(name.length() < 2) {
				System.out.println("※※이름이 너무 짧습니다. 이름을 다시 입력해 주세요.※※");
				continue;
			} 

			//이름에 숫자포함 여부 판별
			for(int i = 0; i < name.length(); i++) {
				if((name.charAt(i) >= '0') && (name.charAt(i) <= '9')) {
					System.out.println("※※이름에 문자가 아닌 부분이 있습니다. 이름을 다시 입력해 주세요.※※");
					break;
				} 
				count++;
			}
			if(count == name.length()) {
				return name;
			}
		}//end while
	}//end nameChk

	//나이 유효성 검사
	static int ageChk(int age) {
		while(true) {
			try {
				System.out.print(">>> 나이 : ");
				String s = scan.nextLine();
				age = Integer.parseInt(s);

				if((age > 0) && (age < 150)) {
					return age;
				} else { //범위 밖 나이
					System.out.println("※※나이가 너무 많거나 적습니다. 다시 입력해주세요.※※");
					continue;
				}
			} catch (NumberFormatException e) {	//숫자가 아닌 다른 문자
				System.out.println("※※나이에 문자가 있습니다. 다시 입력해주세요.※※");
				continue;
			}
		}//end while
	}//end ageChk

	//성별 유효성 검사
	static String sexChk(String sex) {
		while(true) {
			System.out.print(">>> 성별(남 / 여) : ");
			sex = scan.nextLine();
			if(!("남".equals(sex) || "여".equals(sex))) {
				System.out.println("※※성별을 잘못 입력하셨습니다. 다시 입력해주세요.※※");
				continue;
			} else {
				return sex;
			}
		}//end while
	}//end sexChk

	//연락처 유효성 검사
	static String phoneChk(String phone) {
		String first, middle, last;
		String[] s = null; 
		while(true) {
			System.out.print(">>> 연락처(***-****-****) : ");
			phone = scan.nextLine();
			
			if(phone.length() > 13) {
				System.out.println("※※연락처가 너무 깁니다. 연락처를 다시 입력해 주세요.※※");
				continue;
			} else if (phone.length() < 9){
				System.out.println("※※연락처가 너무 짧습니다. 연락처를 다시 입력해 주세요.※※");
				continue;
			} else {
				//하이픈 체크
				int count = 0;
				for(int i = 0; i < phone.length(); i++) {
					if(phone.charAt(i) == '-') {
						count++;
					}
				}
				
				//하이픈 0개
				if(count == 0) {
					//서울 지역번호
					if("02".equals(phone.substring(0, 2))) {
						first = phone.substring(0, 2);
						if(phone.length() == 9) {
							middle = phone.substring(2, 5);
							last = phone.substring(5, 9);
						} else if(phone.length() == 10){
							middle = phone.substring(2, 6);
							last = phone.substring(6, 10);
						} else {
							System.out.println("※※연락처를 다시 입력해 주세요.※※");
							continue;
						}
					} else {	//그외 지역번호
						first = phone.substring(0, 3);
						if(phone.length() == 10) {
							middle = phone.substring(3, 6);
							last = phone.substring(6, 10);
						} else if(phone.length() == 11){
							middle = phone.substring(3, 7);
							last = phone.substring(7, 11);
						} else {
							System.out.println("※※연락처를 다시 입력해 주세요.※※");
							continue;
						}
					}
				} else if(count == 1) { //하이픈 1개
					if(phone.indexOf("-") < 4) {	//지역번호 다음 하이픈
						if("02".equals(phone.substring(0, 2))) {
							first = phone.substring(0, 2);
							if(phone.length() == 10) {
								middle = phone.substring(3, 6);
								last = phone.substring(6, 10);
							} else if(phone.length() == 11){
								middle = phone.substring(3, 7);
								last = phone.substring(7, 11);
							} else {
								System.out.println("※※연락처를 다시 입력해 주세요.※※");
								continue;
							}
						} else {	//그외 지역번호
							first = phone.substring(0, 3);
							if(phone.length() == 11) {
								middle = phone.substring(4, 7);
								last = phone.substring(7, 11);
							} else if(phone.length() == 12){
								middle = phone.substring(4, 8);
								last = phone.substring(8, 12);
							} else {
								System.out.println("※※연락처를 다시 입력해 주세요.※※");
								continue;
							}
						}
					} else {	//중간번호 다음 하이픈
						if("02".equals(phone.substring(0, 2))) {
							first = phone.substring(0, 2);
							if(phone.length() == 10) {
								middle = phone.substring(2, 5);
								last = phone.substring(6, 10);
							} else if(phone.length() == 11){
								middle = phone.substring(2, 6);
								last = phone.substring(7, 11);
							} else {
								System.out.println("※※연락처를 다시 입력해 주세요.※※");
								continue;
							}
						} else {	//그외 지역번호
							first = phone.substring(0, 3);
							if(phone.length() == 11) {
								middle = phone.substring(3, 6);
								last = phone.substring(7, 11);
							} else if(phone.length() == 12){
								middle = phone.substring(3, 7);
								last = phone.substring(8, 12);
							} else {
								System.out.println("※※연락처를 다시 입력해 주세요.※※");
								continue;
							}
						}
					}
				} else if(count == 2){ //하이픈 정상 입력
					s = phone.split("-");
					first = s[0];
					middle = s[1];
					last = s[2];
				} else {
					System.out.println("※※하이픈이 많습니다. 연락처를 다시 입력해주세요.※※");
					continue;
				}
				
				phone = first + "-" + middle + "-" + last;
		
				//연락처 자리수 판별
				if((first.length() == 2 || first.length() == 3) && (middle.length() == 3 || middle.length() == 4 ) && (last.length() == 4)) {
					//앞자리 숫자 판별
					for(int i = 0; i < first.length(); i++) {
						if(!Character.isDigit(first.charAt(i))){
							System.out.println("※※연락처에 숫자가 아닌 부분이 있습니다. 연락처를 다시 입력해 주세요.※※");
							break;
						}
					}
	
					//중간자리 숫자 판별
					for(int i = 0; i < middle.length(); i++) {
						if(!Character.isDigit(middle.charAt(i))){
							System.out.println("※※연락처에 숫자가 아닌 부분이 있습니다. 연락처를 다시 입력해 주세요.※※");
							break;
						}
					}
	
					//마지막자리 숫자 판별
					for(int i = 0; i < last.length(); i++) {
						if(!Character.isDigit(last.charAt(i))){
							System.out.println("※※연락처에 숫자가 아닌 부분이 있습니다. 연락처를 다시 입력해 주세요.※※");
							break;
						}
					}
					return phone;
				}
			}//end if
		}//end while
	}//end phoneChk
	//주소 유효성 검사
	static String addressChk(String address) {
		System.out.print(">>> 주소 : ");
		address = scan.nextLine().trim();
		return address;
	}
	
	//객체 복사
	static void objectCopy() {
		for(int i = 0; i < memberList.size(); i++) {
			String name = memberList.get(i).getName(); 
			int age = memberList.get(i).getAge();
			String sex = memberList.get(i).getSex();
			String phone = memberList.get(i).getPhone();
			String address = memberList.get(i).getAddress();
			String period = memberList.get(i).getPeriod();
			SwimMemberVO member = new SwimMemberVO(name, age, sex, phone, address, period);
			copyMember.add(member);
		}
	}
}
