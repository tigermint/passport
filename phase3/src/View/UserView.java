package View;

import user.UserDAO;
import user.UserDTO;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UserView {
    public static int loginView() {
        UserDAO userDAO = new UserDAO();
        Scanner sc = new Scanner(System.in);
        String id;
        String pw;

        System.out.println("==========================================");
        System.out.println("[로그인]");
        System.out.print("숫자로 된 아이디를 입력해주세요: ");
        while (true) {
            id = sc.next();
            if (!id.matches("[0-9]+")) {
                System.out.print("####### 숫자로만 입력해주세요 #######: ");
            } else {
                break;
            }
        }

        System.out.print("비밀번호를 입력해주세요: ");
        pw = sc.next();

        switch (userDAO.login(id, pw)) {
            case 1:
                System.out.println("로그인 되었습니다.");
                return Integer.parseInt(id);
            case 0:
                System.out.println("로그인에 실패하였습니다.");
                return -1;
            case -1:
                System.out.println("사용자가 존재하지 않습니다. 회원가입을 해주세요");
                return -2;
            default:
                break;
        }
        return -3;
    }

    public static int joinView() {
        UserDAO userDAO = new UserDAO();
        UserDTO userDTO = new UserDTO();
        Scanner sc = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("[회원 가입]");

        System.out.print("이름을 입력해주세요: ");
        userDTO.setName(sc.next());

        System.out.print("아이디를 입력해주세요: ");

        while (true) {
            String tmp = sc.next();
            if (!tmp.matches("[0-9]+")) {
                System.out.print("####### 숫자로만 입력해주세요 #######: ");
            } else {
                userDTO.setId(tmp);
                break;
            }
        }

        System.out.print("비밀번호를 입력해주세요: ");
        userDTO.setPassword(sc.next());

        System.out.print("학교 이메일을 입력해주세요: ");
        userDTO.setSchoolEmail(sc.next());

        System.out.print("사용하는 은행 이름을 입력해주세요: ");
        userDTO.setBankName(sc.next());

        System.out.print("사용하는 은행 계좌를 입력해주세요: ");

        while (true) {
            String tmp = sc.next();
            if (!tmp.matches("[0-9]+")) {
                System.out.print("####### 숫자로만 입력해주세요 #######: ");
            } else {
                userDTO.setBankAccount(tmp);
                break;
            }
        }
        System.out.println(userDTO);
        return userDAO.join(userDTO);
    }

    public static void myView() {
        System.out.println("==========================================");
        System.out.println("1.로그아웃    2.스터디 목록 조회    3.스터디 생성    4.내정보 조회    5.종료 ");
    }
}
