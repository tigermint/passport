import View.SystemView;
import View.UserView;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SystemView.start();
        while (true) {
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
        }
    }
}