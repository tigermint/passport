// action - state management
import * as actionTypes from './actions';

// actions
export const studyAction = {
  setStudyList: (payload) => ({ type: actionTypes.SET_STUDY_LIST, payload }),
  setStudyDetail: (payload) => ({ type: actionTypes.SET_STUDY_DETAIL, payload }),
  setStudyCreateParams: (payload) => ({ type: actionTypes.SET_STUDY_CREATE_PARAMS, payload })
};

export const initialState = {
  studyList: [{}],
  studyDetail: {
    studyListDTO: {
      id: 2,
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
  },
  studyCreateParams: {}
};

const studyReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.SET_STUDY_LIST:
      return { ...state, studyList: action.payload };
    case actionTypes.SET_STUDY_DETAIL:
      return { ...state, studyDetail: action.payload };
    case actionTypes.SET_STUDY_CREATE_PARAMS:
      //
      return { ...state, studyCreateParams: action.payload };
    default:
      return state;
  }
};

export default studyReducer;
