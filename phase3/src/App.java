import View.SystemView;
import View.UserView;
import study.CreateStudyForm;
import study.ListOfStudy;
import user.UserDAO;
import user.UserDTO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String isLogined = null; // userID
        UserDAO userDAO = new UserDAO();

        SystemView.start();
        while (true) {
            while (true) {
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
                switch (sc.nextInt()) {
                    case 1:
                        isLogined = null;
                        System.out.println("로그아웃 되었습니다.\n");
                        break;
                    case 2:
                        // 스터디 목록조회
                        try {
                            ListOfStudy lo = new ListOfStudy();
                            lo.displayListOfStudy();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 3:
                        // 스터디 생성
                        try {
                            CreateStudyForm cs = new CreateStudyForm();
                            cs.displayCreateStudyForm();
                        } catch (SQLException | ParseException e) {
                            throw new RuntimeException(e);
                        }

                        break;
                    case 4:
                        //내정보조회
                        userDAO.profile(isLogined);
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