import { Grid } from '@mui/material';
import StudyCard from 'ui-component/cards/StudyCard';

const SamplePage = () => (
    <>
        <h1>스터디 리스트</h1>
        <Grid container rowSpacing={3} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
            <Grid item xs={6}>
                <StudyCard />
            </Grid>
        </Grid>
    </>
);

export default SamplePage;
