package study;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import static util.DatabaseUtil.getConnection;

public class CreateStudyForm {

    static Connection conn;
    Statement stmt;
    StudyDTO studyDTO;
    String tempString;
    Integer tempInt;
    Scanner sc;

    public CreateStudyForm() throws SQLException {
        conn = getConnection();
        stmt = conn.createStatement();
        studyDTO = new StudyDTO();
        sc = new Scanner(System.in);
    }

    public void displayCreateStudyForm() throws ParseException, SQLException {
        System.out.println("=========================================");
        System.out.println("[스터디 생성]\n");
        System.out.println("-스터디 이름: ");
        tempString = sc.nextLine();
        studyDTO.setName(tempString);
        System.out.println("-총 회차: ");
        tempInt = sc.nextInt();
        studyDTO.setTotalRound(tempInt);
        System.out.println("-참여비: ");
        tempInt = sc.nextInt();
        studyDTO.setParticipationFee(tempInt);
        System.out.println("-최대 인원: ");
        tempInt = sc.nextInt();
        studyDTO.setMaxParticipants(tempInt);
        System.out.println("-최대 결석 횟수: ");
        tempInt = sc.nextInt();
        studyDTO.setMaxAbsentTime(tempInt);
        System.out.println("-장소: ");
        tempString = sc.nextLine();
        studyDTO.setLocation(tempString);
        System.out.println("-은행 이름: ");
        tempString = sc.nextLine();
        studyDTO.setBankName(tempString);
        System.out.println("-계좌 번호: ");
        tempInt = sc.nextInt();
        studyDTO.setBankAccount(tempInt);
        System.out.println("-시작 날짜(ex. 2022-11-20): ");
        tempString = sc.nextLine();
        studyDTO.setStartDate(tempString);

        ResultSet rs = StudyDAO.createStudy(studyDTO);
        System.out.println("스터디 생성이 완료되었습니다.");
        System.out.println("목록으로 돌아갑니다.");
    }
}
