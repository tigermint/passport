package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
