# passport
* * *
### 환경설정 (Trouble Shooting)
+ 사용자별 DataBaseUtil클래스의 url값의 마지막 부분이 다르므로 자신의 환경에 맞게 url값을 수정해야 한다.
+ DB로 부터 쿼리를 불러올때 다음과 오류가 뜬다면 orai18n.jar파일을 외부 라이브러리에 추가해주어야 한다.
```
There was an unexpected error (type=Internal Server Error, status=500).
Error attempting to get column 'ID' from result set. Cause: java.sql.SQLException: 지원되지 않는 문자 집합(클래스 경로에 orai18n.jar 추가): KO16MSWIN949 ;
uncategorized SQLException; SQL state [99999]; error code [17056]; 지원되지 않는 문자 집합(클래스 경로에 orai18n.jar 추가): KO16MSWIN949; 
```