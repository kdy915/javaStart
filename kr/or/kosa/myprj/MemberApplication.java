package kr.or.kosa.myprj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberApplication {
	static ArrayList<Member> memberList = new ArrayList<>();
	static ArrayList<Member> presentList = new ArrayList<>();
	static Scanner scan = new Scanner(System.in); //inputStream 타입이다
	static boolean isUpdated = false;

// 필요한 함수들을 미리 정리해 놓고 작업을 시작하면 가독성과 코드에 대한 이해력을 높힐 수 있다.
	public static void main(String[] args) {
		try {
			load("member.csv");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		while (true) {
			if (isUpdated) {
				System.out.print("*");
			}
			System.out.print("메뉴: 1.입력, 2.CSV 저장, 3. CSV 불러오기, 4.목록 출력, 5.수정, 6.삭제, 7.조회 0. 종료 :");
			int menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.println("정보를 입력합니다.");
				insert();
				isUpdated = true;
				break;
			case 2:
				System.out.println("파일에 저장합니다.");
				try {
					save("member.csv");
				} catch (IOException e) {
					e.printStackTrace();
				}
				isUpdated = false;
				break;
			case 3:
				System.out.println("파일에서 데이터를 불러옵니다.");
				try {
					load("member.csv");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("모든 정보를 출력합니다.");
				printAllMember();
				break;
			case 5:
				System.out.println("정보를 수정합니다.");
				int searchIndex = scan.nextInt();
				update(searchIndex);
				isUpdated = true;
				break;
			case 6:
				System.out.println("정보를 삭제합니다");
				System.out.print("삭제할 인덱스를 입력하세요");
				int delIndex = scan.nextInt();
				try {
					delete(delIndex);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("인덱스가 범위를 벗어납니다.");
				}
				isUpdated = true;
				break;
			case 7:
				System.out.println("정보를 조회합니다");
				System.out.println("조회할 이름을 입력하세요.");
				String searchName = scan.next();
				try {
					search(searchName);
				} catch (RuntimeException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 0:
				if (isUpdated) {
					System.out.println("수정된 데이터를 저장하겠습니까?(y/n):");
					String change = scan.next();
//					if(change.equals("y"))
					if ("y".equals(change) || "Y".equals(change)) { // 상수를 앞에두는게 좋다
						try {
							load("member.csv");
						} catch (IOException e) {
							System.out.println(e.getMessage());
						}
					} else {
						System.out.println("수정된 데이터 저장 안함");
					}
				}
				System.exit(0);
			}
		}
	}// end main
	

	private static void update(int searchIndex) {
		if (searchIndex < 0 || searchIndex >= memberList.size()) {
			throw new IndexOutOfBoundsException();
		}
		Member member = memberList.get(searchIndex);
		System.out.print("이름(" + member.getName() + "):");
		String name = scan.next();
		member.setName(name);
//		member.setName(scan.next());
		System.out.print("주소(" + member.getAddress() + "):");
		member.setAddress(scan.next());
		System.out.print("이메일(" + member.getEmail() + "):");
		member.setEmail(scan.next());
		System.out.print("나이(" + member.getAge() + "):");
		member.setAge(scan.nextInt());
	}

	private static void search(String searchName) {
		int searchCount = 0;
		for (Member member : memberList) {
			if (searchName.equals(member.getName())) {
				System.out.println(member);
				searchCount++;
			}
		}
		if (searchCount == 0) {
			throw new RuntimeException("찾는 데이터가 없습니다.");
		}
	}

	private static void delete(int index) {
		if (index < 0 || index >= memberList.size()) {
			throw new IndexOutOfBoundsException(index); // 숫자를 받는 생성자가 없는 경우 ""+index와 같이 표현해 주어야 한다.
		}
		memberList.remove(index);
	}

	private static void printAllMember() {
		System.out.println("=========================");
		System.out.println("이름\t주소\t이메일\t나이");
		System.out.println("=========================");
		for (Member member : memberList) {
//			System.out.println(member);
			System.out.print(member.getName() + "\t");
			System.out.print(member.getAddress() + "\t");
			System.out.print(member.getEmail() + "\t");
			System.out.print(member.getAge() + "\n");
		}
		System.out.println("-------------------------");
	}

	public static void insert() {
		System.out.print("이름: ");
		String name = scan.next();
		System.out.print("주소: ");
		String address = scan.next();
		System.out.print("이메일: ");
		String email = scan.next();
		System.out.print("나이: ");
		int age = scan.nextInt();
		Member member = new Member(name, address, email, age);
		memberList.add(member);
	}

	public static void save(String fileName) throws IOException {
		FileWriter writer = new FileWriter(fileName);
		for (Member member : memberList) {
			writer.write(member.toCSV());
			writer.write('\n');
		}
		writer.flush();
		writer.close();
	}

	public static void load(String fileName) throws IOException {
		FileReader reader = new FileReader(fileName);
		BufferedReader in = new BufferedReader(reader);
		String line = null;
		while ((line = in.readLine()) != null) {
			String[] datas = line.split(",");
			String name = datas[0];
			String address = datas[1];
			String email = datas[2];
			int age = Integer.parseInt(datas[3]);
			Member member = new Member(name, address, email, age);
			memberList.add(member);
			presentList.add(member);
		}
	}

}
