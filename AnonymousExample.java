//1.별도의 클래스로 작성
//2.멤버 내부 클래스로 작성
//3.지역 클래스로 작성
//4.익명 클래스로 작성
//5.익명 클래스 변수로 작성

// 1. 별도의 클래스로 작성
public class AnonymousExample {
   public void doEvent(MyHandler handler) {
      System.out.println("콜백 메서드 실행");
      handler.callBack();
   }
   public static void main(String[] args) {
      AnonymousExample ex = new AnonymousExample();
      ex.doEvent(new MyHandlerImpl());
   }
}
class MyHandlerImpl implements MyHandler {
   @Override
   public void callBack() {
      System.out.println("callBack 메서드 호출");
   }
   
}
// 2. 멤버 내부 클래스로 작성
//public class AnonymousExample {
//   public void doEvent(MyHandler handler) {
//      System.out.println("콜백 메서드 실행");
//      handler.callBack();
//   }
//   public static void main(String[] args) {
//      AnonymousExample ex = new AnonymousExample();
//      ex.doEvent(ex.new MyHandlerImpl());
//   }
//   
//   class MyHandlerImpl implements MyHandler {
//      @Override
//      public void callBack() {
//         System.out.println("callBack 메서드 호출");
//      }
//   }
//}
// 3.지역 클래스로 작성
//public class AnonymousExample {
//   public void doEvent(MyHandler handler) {
//      System.out.println("콜백 메서드 실행");
//      handler.callBack();
//   }
//   public static void main(String[] args) {
//      class MyHandlerImpl implements MyHandler {
//         @Override
//         public void callBack() {
//            System.out.println("callBack 메서드 호출");
//         }
//      }
//      AnonymousExample ex = new AnonymousExample();
//      ex.doEvent(new MyHandlerImpl());
//   }
//}
//4. 익명 클래스로 작성
//public class AnonymousExample {
//   public void doEvent(MyHandler handler) {
//      System.out.println("콜백 메서드 실행");
//      handler.callBack();
//   }
//   public static void main(String[] args) {
//      AnonymousExample ex = new AnonymousExample();
//      ex.doEvent(new MyHandler() {
//         @Override
//         public void callBack() {
//            System.out.println("callBack 메서드 호출");
//         }
//      });
//   }
//}
//5. 익명 클래스 변수로 작성
//public class AnonymousExample {
//   public void doEvent(MyHandler handler) {
//      System.out.println("콜백 메서드 실행");
//      handler.callBack();
//   }
//   MyHandler handler = new MyHandler() {
//      @Override
//      public void callBack() {
//         System.out.println("callBack 메서드 호출");
//      }
//   };
//   public static void main(String[] args) {
//      AnonymousExample ex = new AnonymousExample();
//      ex.doEvent(ex.handler);
//   }
//}