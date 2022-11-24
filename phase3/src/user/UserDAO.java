package user;

import java.sql.*;

import static util.DatabaseUtil.getConnection;

public class UserDAO {
    private Connection conn;
    private ResultSet rs;

    public UserDAO() {
        this.conn = getConnection();
    }

    public int login(String userID, String userPW) {
        String sql = "SELECT password FROM user_ where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();

            // check password
            if (rs.next()) {
                if (rs.getString(1).equals(userPW)) {
                    return 1; // success
                } else {
                    return 0; // fail
                }
            }
            return -1; // no user
        } catch (SQLException e) {
            throw new RuntimeException(e); // db error
        }
    }

    public int join(UserDTO user) {
        String sql = "INSERT INTO user_ values(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(user.getId()));
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getSchoolEmail());
            pstmt.setString(5, user.getBankName());
            pstmt.setInt(6, Integer.parseInt(user.getBankAccount()));
            pstmt.setString(7, Boolean.toString(true));
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e); // db error
        }
    }

    public void profile(String userID) {
        String sql = "select U.id,  U.password,U.name, U.school_email, U.bank_name, U.bank_account, P.study_id, P.is_leader\n" +
                "from user_ U join participate P on U.id = P.user__id\n" +
                "where U.id = ?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userID);
            rs = pstmt.executeQuery();

            // print result
            System.out.println("========================================================================================================================================================");
            System.out.println("[내 정보 조회]");
            System.out.print(String.format("%-15s | ", "아이디"));
            System.out.print(String.format("%-15s | ", "비밀번호"));
            System.out.print(String.format("%-15s | ", "이름"));
            System.out.print(String.format("%-20s | ", "이메일"));
            System.out.print(String.format("%-30s | ", "은행"));
            System.out.print(String.format("%-15s |", "은행 계좌"));
            System.out.print(String.format("%-15s |", "스터디 아이디"));
            System.out.println(String.format("%-15s   ", "스터디 리더 여부"));
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.print(String.format("%-17s | ", rs.getInt( 1)));
                System.out.print(String.format("%-15s | ", rs.getString(2)));
                System.out.print(String.format("%-15s | ", rs.getString(3)));
                System.out.print(String.format("%-25s | ", rs.getString(4)));
                System.out.print(String.format("%-30s | ", rs.getString(5)));
                System.out.print(String.format("%-15s | ", rs.getString(6)));
                System.out.print(String.format("%-15s |", rs.getString(7)));
                System.out.println(String.format("%-15s  ", rs.getString(8)));
            }
            System.out.println("\n");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
