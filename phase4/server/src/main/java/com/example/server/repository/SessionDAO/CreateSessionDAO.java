package com.example.server.repository.SessionDAO;

import com.example.server.config.JdbcTemplateConfig;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class CreateSessionDAO {
    public JdbcTemplateConfig jdbcTemplateConfig = new JdbcTemplateConfig();

    public JdbcTemplate template = new JdbcTemplate(jdbcTemplateConfig.dataSource());

    public String query = "insert into session_ values (session_seq.NEXTVAL, ?, ?, ?)";

    public String getStudyId = "select max(id) from study_";

    public int joinSessionDAO(int maxRound, String startDate) throws ParseException {
        int StudyId = template.queryForObject(getStudyId, Integer.class);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String strDate = startDate;
        Date date = sdf.parse(strDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int j = 1;
        while (j <= maxRound) {
            cal.add(Calendar.DATE, 1); //
            String resultDate = sdf.format(cal.getTime());
            int result = template.update(query, StudyId, j, resultDate);
            j++;
        }
        return 1;
    }
}
