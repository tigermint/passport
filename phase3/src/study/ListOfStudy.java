package study;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static study.StudyDAO.readListOfStudy;
import static util.DatabaseUtil.getConnection;

public class ListOfStudy {

    Connection conn;
    Statement stmt;
    StudyDAO studyDAO;
    ResultSet rs;
    Scanner sc;

    public ListOfStudy() throws SQLException {
        conn = getConnection();
        stmt = conn.createStatement();
        studyDAO = new StudyDAO();
        rs = readListOfStudy(stmt);

    }

    public Integer displayListOfStudy() throws SQLException {
        sc = new Scanner(System.in);
        ResultSet rs = readListOfStudy(stmt);
        System.out.println("=================================================================================================================================\n");
        System.out.println("[스터디 목록 조회]");
        System.out.print(String.format("%-2s | ", "번호"));
        System.out.print(String.format("%-30s | ", "스터디 이름"));
        System.out.print(String.format("%-2s | ", "총 회차"));
        System.out.print(String.format("%-3s | ", "참여비"));
        System.out.print(String.format("%-2s | ", "최대 인원"));
        System.out.print(String.format("%-2s | ", "최대 결석 횟수"));
        System.out.print(String.format("%-22s | ", "장소"));
        System.out.print(String.format("%-10s  \n", "시작 날짜"));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        while(rs.next()){
            System.out.print(String.format("%-3s | ", rs.getInt("id")));
            System.out.print(String.format("%-33s | ", rs.getString("name")));
            System.out.print(String.format("%-6s | ", rs.getString("total_round")));
            System.out.print(String.format("%-6s| ", rs.getString("participation_fee")));
            System.out.print(String.format("%-7s | ", rs.getString("max_participants")));
            System.out.print(String.format("%-12s | ", rs.getString("max_absent_time")));
            System.out.print(String.format("%-23s | ", rs.getString("location")));
            System.out.println(String.format("%-10s  ", rs.getString("start_date")));
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\n1. 스터디 번호 선택 | 2. 스터디 생성");
        System.out.print("번호를 입력하세요: ");
        return sc.nextInt();
    }
}
