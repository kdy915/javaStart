package kr.or.kosa.myprj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectSerializationExample {
	public static void main(String[] args) {
		//파일 저장
		Member member = new Member("홍길동", "강남", "hong@hong.com",30);
		Member member2 = new Member("홍길서", "강서", "seo@hong.com",25);
		ArrayList<Member> memberList = new ArrayList<>();
		memberList.add(member);
		memberList.add(member2);
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		//파일 불러오기
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			//파일에 저장
			fos = new FileOutputStream("member.data");
			// member 클래스 확인
			oos = new ObjectOutputStream(fos);  // 직렬화가 된다는 것을 선언해 주어야 한다 클래스에
//			oos.writeObject(member);
//			oos.writeObject(member2);
			oos.writeObject(memberList);
			System.out.println("파일에 저장됨");
			//파일 불러오기
			fis = new FileInputStream("member.data");
			ois = new ObjectInputStream(fis);
			ArrayList<Member> memberList2 = (ArrayList<Member>) ois.readObject();  //읽을 때 형변환 해야한다. 경고는 어쩔 수 없다.
			System.out.println(memberList2);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {fos.close();}catch(Exception e) {}
		}
	}
}
