package study;

import java.sql.*;
import java.util.logging.Logger;

import static util.DatabaseUtil.getConnection;

public class StudyDAO {
    static Connection conn = getConnection();
    Statement stmt = conn.createStatement();
    static String sql;
    static StringBuffer sb;
    static Logger LOG = Logger.getGlobal();
    public StudyDAO() throws SQLException {
    }

    public static ResultSet createStudy(StudyDTO study) throws SQLException {
        String tempSql = "select max(S.id)\n" +
                "from study_ S";

        PreparedStatement pstmt = conn.prepareStatement(tempSql);

        ResultSet rset = pstmt.executeQuery();
        if(rset.next()){
            study.setId(rset.getInt(1) + 1);
        }

        ResultSet rs = null;
        sb = new StringBuffer();
        sb.append("Insert into STUDY_ ");
        sb.append("values ( ");
        sb.append("?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?");
        sb.append(")");
        sql = sb.toString();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, study.getId());
        ps.setString(2, study.getName());
        ps.setInt(3, study.getTotalRound());
        ps.setInt(4, study.getParticipationFee());
        ps.setInt(5, study.getMaxParticipants());
        ps.setInt(6, study.getMaxAbsentTime());
        ps.setBoolean(7, study.getComplete());
        ps.setString(8, study.getLocation());
        ps.setString(9, study.getBankName());
        ps.setInt(10, study.getBankAccount());
        ps.setDate(11, (Date) study.getStartDate());

        try {
            rs = ps.executeQuery();
//            LOG.info("Study created");
        } catch (SQLException e) {
//            LOG.warning("Study creation failed");
            throw new RuntimeException(e);
        }

        return rs;
    }

    public static ResultSet readListOfStudy(Statement stmt) throws SQLException {
        ResultSet rs = null;
        sb = new StringBuffer();
        sb.append("SELECT * FROM STUDY_ ");
        sql = sb.toString();

        try {
            rs = stmt.executeQuery(sql);
//            LOG.info("Study List successfully retrieved.");
        } catch (SQLException e) {
//            LOG.warning("");
//            LOG.warning("Error retrieving Study List.");
            throw new RuntimeException(e);
        }

        return rs;
    }

    public static ResultSet readDetailOfStudy(Integer id) throws SQLException {
        ResultSet rs = null;
        sb = new StringBuffer();
        sb.append("select s.id studyId, s.name studyName , u.name UserName, s.total_round, s.participation_Fee, s.Max_Participants, s.Max_absent_Time, s.Location, s.start_date ");
        sb.append("from study_ s,participate p, user_ u ");
        sb.append("where s.id = p.study_id and u.id = p.user__id and s.id= ?");
        sql = sb.toString();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        try {
            rs = ps.executeQuery();
            LOG.info("Study Detail successfully retrieved.");
        } catch (SQLException e) {
            LOG.warning("Error retrieving Study Detail.");
            throw new RuntimeException(e);
        }

        return rs;
    }

}
