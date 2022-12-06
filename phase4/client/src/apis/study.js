import axios from 'axios';

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
  sessions: [{ round: 1, date: '2022-11-19', attendants: 3 }]
};

export function apiGetStudyList(onSuccess, onError, isStub = true) {
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

export function apiGetStudyDetail(queryParams, onSuccess, onError, isStub = true) {
  if (isStub) {
    onSuccess(stubData2);
  } else {
    axios
      .get(`/study/${queryParams.study__id}`)
      .then((response) => {
        onSuccess(response.data);
      })
      .catch((error) => {
        onError(error);
      });
  }
}