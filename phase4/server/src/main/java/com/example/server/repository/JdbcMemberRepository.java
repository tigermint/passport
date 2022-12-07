package com.example.server.repository;

import com.example.server.domain.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;
public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql = "INSERT INTO user_ values(user_seq.nextval, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql,new String[]{"id", "name", "school_email", "password", "bank_name", "bank_account", "is_active"});
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getSchoolEmail());
            pstmt.setString(3, member.getPassword());
            pstmt.setString(4, member.getBankName());
            pstmt.setInt(5, Integer.parseInt(member.getBankAccount()));
            pstmt.setString(6, Boolean.toString(member.getIsActive()));

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                member.setId(rs.getLong(1));
                member.setName(rs.getString(2));
                member.setSchoolEmail(rs.getString(3));
                member.setPassword(rs.getString(4));
                member.setBankName(rs.getString(5));
                member.setBankAccount(rs.getString(6));
                member.setIsActive(rs.getBoolean(7));

            } else {
                throw new SQLException("id 조회 실패");
            }
            return member;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally{
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Member> findByEmail(String memberSchoolEmail) {
        String sql = "select * from user_ where school_email = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberSchoolEmail);

            rs = pstmt.executeQuery();

            if(rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong(1));
                member.setName(rs.getString(2));
                member.setSchoolEmail(rs.getString(3));
                member.setPassword(rs.getString(4));
                member.setBankName(rs.getString(5));
                member.setBankAccount(rs.getString(6));
                // isActive 무조건 true
                member.setIsActive(rs.getBoolean(7));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }



    public Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
    {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } try {
        if (pstmt != null) {
            pstmt.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } }
    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}
