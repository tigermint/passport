package View;

public class SystemView {
    public static void start() {
        System.out.println("================ passport ================");
        System.out.println("안녕하세요 환영합니다!");
        System.out.println("==========================================");
        System.out.println("1. 로그인        2. 회원가입         3. 종료하기");

    }


    public static void exit() {
        System.out.println("==========================================");
        System.out.println("종료하였습니다. 다음번에 또 방문해주세요!");
        System.out.println("==========================================");
        System.exit(1);
    }
}
