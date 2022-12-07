import { styled } from '@mui/material/styles';
import { Card } from '@mui/material';
import teamPassport from 'assets/images/teamPassport.png';

// project imports
import MainCard from 'ui-component/cards/MainCard';
import SecondaryAction from 'ui-component/cards/CardSecondaryAction';

// assets
import LinkIcon from '@mui/icons-material/Link';

// styles
const IFrameWrapper = styled('iframe')(({ theme }) => ({
  height: 'calc(100vh - 210px)',
  border: '1px solid',
  borderColor: theme.palette.primary.light
}));

const PassportNotionPage = () => (
  <MainCard
    title="팀 패스포트를 소개합니다."
    secondary={
      <SecondaryAction
        icon={<LinkIcon fontSize="small" />}
        link="https://www.notion.so/Passport-22-2-DB-876fa71828d9452e9bd2d12d86b62464"
      />
    }
  >
    <Card sx={{ overflow: 'hidden' }}>
      {/* <IFrameWrapper title="Notion Page" width="100%" src="https://www.notion.so/Passport-22-2-DB-876fa71828d9452e9bd2d12d86b62464" /> */}
      <img src={teamPassport} alt="Passport" width="100%" />
    </Card>
  </MainCard>
);

export default PassportNotionPage;
