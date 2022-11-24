import View.SystemView;
import View.UserView;
import user.UserDTO;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String isLogined = null;

        SystemView.start();
        while (true) {
            while(true){
                SystemView.menu();
                System.out.print("\n메뉴를 선택해주세요: ");
                switch (sc.nextInt()) {
                    case 1:
                        isLogined = String.valueOf(UserView.loginView());
                        break;
                    case 2:
                        UserView.joinView();
                        break;
                    case 3:
                        SystemView.exit();
                        break;
                    default:
                        System.out.println("###### 올바른 메뉴를 선택해주세요 #####");
                        break;
                }
                if (Integer.parseInt(isLogined) > 0) { // login 성공
                    break;
                }
            }

            //입력
            while (true) {
                UserView.myView();
                System.out.print("\n메뉴를 선택해주세요: ");
                switch(sc.nextInt()){
                    case 1:
                        isLogined = null;
                        System.out.println("로그아웃 되었습니다.\n");
                        break;
                    case 2:
                        // 스터디 몰록조회
                        break;
                    case 3:
                        // 스터디 생성
                        break;
                    case 4:
                        //내정보조회
                        break;
                    case 5:
                        SystemView.exit();
                        break;
                    default:
                        System.out.println("###### 올바른 메뉴를 선택해주세요 #####");
                        break;
                }
                if(isLogined == null){
                    break;
                }
            }
        }
    }
}