import java.sql.Connection;

import static util.DatabaseUtil.getConnection;

public class App {
    public static void main(String[] args) {

        // page 호출 -> main, main에서 컴포넌트화 된 구성 요소들 호출
        System.out.println("Hello world!");
        // 연결 테스트
        Connection conn = getConnection();
        System.out.println("conn = " + conn);
    }
}