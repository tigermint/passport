import * as React from 'react';
import Box from '@mui/material/Box';
import Container from '@mui/material/Container';
import Paper from '@mui/material/Paper';
import Stepper from '@mui/material/Stepper';
import Step from '@mui/material/Step';
import StepLabel from '@mui/material/StepLabel';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Step1 from './Step1';
import Step2 from './Step2';
import Step3 from './Step3';
import Link from '@mui/material/Link';
import { useSelector } from 'react-redux';
import { studyAction } from 'store/studyReducer';
import { apiPostCreateStudy } from 'apis/study';

const steps = ['스터디 기본정보', '스터디 횟수', '기타 설정'];

function getStepContent(step) {
  switch (step) {
    case 0:
      return <Step1 />;
    case 1:
      return <Step2 />;
    case 2:
      return <Step3 />;
    default:
      throw new Error('Unknown step');
  }
}

export default function Checkout() {
  const [activeStep, setActiveStep] = React.useState(0);

  const studyCreateParams = useSelector((state) => state.studyReducer.studyCreateParams);
  const user = useSelector((state) => state.userReducer.user);

  const handleNext = () => {
    setActiveStep(activeStep + 1);
  };

  const handleBack = () => {
    setActiveStep(activeStep - 1);
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    // console.log('제출전', studyCreateParams);
    studyCreateParams.user_id = user.id;
    studyCreateParams.category = [];
    studyCreateParams.category.push(studyCreateParams.category1);
    studyCreateParams.category.push(studyCreateParams.category2);
    studyCreateParams.category.push(studyCreateParams.category3);
    studyCreateParams.total_round = parseInt(studyCreateParams.total_round);
    delete studyCreateParams.category1;
    delete studyCreateParams.category2;
    delete studyCreateParams.category3;
    studyCreateParams.start_date = studyCreateParams.start_date.toISOString().slice(0, 10);
    // console.log('변환후', studyCreateParams);
    await apiPostCreateStudy(studyCreateParams);
  };

  return (
    <Container component="main" maxWidth="sm" sx={{ mb: 4 }}>
      <Paper variant="outlined" sx={{ my: { xs: 3, md: 6 }, p: { xs: 2, md: 3 } }}>
        <Typography component="h1" variant="h4" align="center">
          자신만의 스터디를 만들어보세요!
        </Typography>
        <Stepper activeStep={activeStep} sx={{ pt: 3, pb: 5 }}>
          {steps.map((label) => (
            <Step key={label}>
              <StepLabel>{label}</StepLabel>
            </Step>
          ))}
        </Stepper>
        {activeStep === steps.length ? (
          <React.Fragment>
            <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
              <Button variant="contained" onClick={handleSubmit} sx={{ mt: 3, ml: 1, mb: 3 }}>
                스터디 생성하기!
              </Button>
              <Link href="/study" variant="body2" style={{ color: 'black' }}>
                리스트 페이지로 이동
              </Link>
            </Box>
          </React.Fragment>
        ) : (
          <React.Fragment>
            {getStepContent(activeStep)}
            <Box sx={{ display: 'flex', justifyContent: 'flex-end' }}>
              {activeStep !== 0 && (
                <Button onClick={handleBack} sx={{ mt: 3, ml: 1 }}>
                  뒤로
                </Button>
              )}

              <Button variant="contained" onClick={handleNext} sx={{ mt: 3, ml: 1 }}>
                {/* {activeStep === steps.length - 1 ? '생성' : '다음'} */}
                다음
              </Button>
            </Box>
          </React.Fragment>
        )}
      </Paper>
    </Container>
  );
}
