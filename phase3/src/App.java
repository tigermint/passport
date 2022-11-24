import View.SystemView;
import View.UserView;
import user.UserDTO;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDTO isLogined = null;



        while (true) {
            SystemView.start();
            System.out.print("\n메뉴를 선택해주세요: ");
            switch (sc.nextInt()) {
                case 1:
                    UserView.loginView();
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
            if (isLogined == null) {
                continue;
            }
            //입력
            while (true) {
                UserView.myView();
                switch(sc.nextInt()){
                    case 1:
                        isLogined = null;
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
                if (isLogined == null) {
                    break;
                }
            }


        }





    }
}