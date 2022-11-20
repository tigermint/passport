package study;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static study.StudyDAO.readDetailOfStudy;
import static study.StudyDAO.readListOfStudy;
import static util.DatabaseUtil.getConnection;

public class DetailOfStudy {

    Connection conn;
    Statement stmt;
    StudyDAO studyDAO;
    ResultSet rs;

    public DetailOfStudy() throws Exception {
        conn = getConnection();
        stmt = conn.createStatement();
        studyDAO = new StudyDAO();
    }

    public Integer displayDetailOfStudy(Integer id) throws SQLException {
        ResultSet rs = readDetailOfStudy(id);
        Scanner sc = new Scanner(System.in);

        rs.next();
        System.out.println("=================================================\n");
        System.out.println("[스터디 상세 조회]");
        System.out.print(String.format("스터디 번호: %s  ", rs.getString("studyId")));
        System.out.println(String.format("스터디 이름: %s", rs.getString("studyName")));
        System.out.println(String.format("최대유저수: %d", rs.getString("maxParticipants")));
        System.out.print(String.format("총 회차: %s  ", rs.getString("totalRound")));
        System.out.println(String.format("참여비: %s", rs.getString("participationFee")));
        System.out.print(String.format("최대 결석 횟수: %s  ", rs.getString("maxAbsentTime")));
        System.out.println(String.format("장소: %s", rs.getString("location")));
        System.out.println(String.format("시작 날짜: %s", rs.getString("startDate")));
        System.out.println("\n1. 참여하기 | 2. [스터디 목록 조회]로 돌아가기");
        System.out.print("입력: ");
        int input = sc.nextInt();
        return input;
    }
}
