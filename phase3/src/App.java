import java.sql.Connection;
import java.util.logging.Logger;

import static util.DatabaseUtil.getConnection;

public class App {
    public static void main(String[] args) {

        Logger Log = Logger.getGlobal();

        // page 호출 -> main, main에서 컴포넌트화 된 구성 요소들 호출
        System.out.println("Hello world!");
        // 연결 테스트
        Connection conn = getConnection();
        if (conn != null) {
            Log.info("Connection success");
            return;
        }
        Log.warning("Connection failed");
        return;
    }
}