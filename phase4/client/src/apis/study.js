import axios from 'axios';
axios.defaults.baseURL = 'http://localhost:8080';

const stubData1 = [
  {
    id: 1,
    name: 'testInsertStudy1',
    total_round: 5,
    participation_fee: 3000,
    cur_participants: 2,
    max_participants: 4,
    max_absent_time: 1,
    is_complete: 'false',
    location: 'testLocation',
    bank_name: 'testBank',
    bank_account: '1111',
    start_date: '2023-01-10 00:00:00',
    category: ['간호사', '조산사', '토목기사'],
    description: 'testDescription1',
    is_participating: null
  },
  {
    id: 2,
    name: 'testInsertStudy2',
    total_round: 5,
    participation_fee: 10000,
    cur_participants: 1,
    max_participants: 5,
    max_absent_time: 2,
    is_complete: 'false',
    location: 'testLocation2',
    bank_name: 'testBank',
    bank_account: '2222',
    start_date: '2023-01-10 00:00:00',
    category: ['간호사', '조산사', '토목기사'],
    description: 'testDescription2',
    is_participating: null
  }
];

const stubData2 = {
  studyListDTO: {
    id: 0,
    name: 'testInsertStudy1',
    total_round: 5,
    participation_fee: 3000,
    cur_participants: 2,
    max_participants: 4,
    max_absent_time: 1,
    is_complete: 'false',
    location: 'testLocation',
    bank_name: 'testBank',
    bank_account: '1111',
    start_date: '2023-01-10 00:00:00',
    category: ['간호사', '조산사', '토목기사'],
    description: 'testDescription1',
    is_participating: 'false'
  },
  sessions: [
    { round: 1, date: '2022-12-9', attendants: 0 },
    { round: 2, date: '2022-12-10', attendants: 0 },
    { round: 3, date: '2022-12-11', attendants: 0 },
    { round: 4, date: '2022-12-12', attendants: 0 },
    { round: 5, date: '2022-12-13', attendants: 0 }
  ]
};

export function apiGetStudyList(onSuccess, onError, isStub = false) {
  if (isStub) {
    onSuccess(stubData1);
  } else {
    axios
      .get('/study')
      .then((response) => {
        onSuccess(response.data);
      })
      .catch((error) => {
        onError(error);
      });
  }
}

export function apiGetStudyDetail(queryParams, body, onSuccess, onError, isStub = false) {
  if (isStub) {
    onSuccess(stubData2);
  } else {
    axios
      .get(`/study/${queryParams.study__id}`, { data: body })
      .then((response) => {
        onSuccess(response.data);
      })
      .catch((error) => {
        onError(error);
      });
  }
}

export async function apiPostParticipateStudy(body, onSuccess, onError = (e) => alert(e), isStub = false) {
  if (isStub) {
    onSuccess();
    return true;
  } else {
    axios
      .post(`/study/${body.study__id}`, body)
      .then((response) => {
        onSuccess(response.data);
        return true;
      })
      .catch((error) => {
        onError(error);
        return false;
      });
  }
}

export async function apiPostCreateStudy(body, onSuccess = () => alert('스터디 생성 성공'), onError = (e) => alert(e), isStub = false) {
  if (isStub) {
    onSuccess();
    return true;
  } else {
    const result = await axios
      .post(`/study`, body)
      .then((response) => {
        onSuccess(response.data);
        return true;
      })
      .catch((error) => {
        onError(error);
        return false;
      });
    return result;
  }
}
