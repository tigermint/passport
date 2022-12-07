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
      id: null,
      name: '',
      total_round: null,
      participation_fee: null,
      cur_participants: null,
      max_participants: null,
      max_absent_time: null,
      is_complete: '',
      location: '',
      bank_name: '',
      bank_account: '',
      start_date: '',
      category: [],
      description: '',
      is_participating: ''
    },
    sessions: [{ round: null, date: '', attendants: null }]
  },
  studyCreateParams: {
    name: 'default name',
    total_round: 5,
    description: '',
    participation_fee: '10000',
    max_participants: '5',
    max_absent_time: '3',
    location: 'default location',
    start_date: '2022-11-26',
    category: ['', '', '']
  }
};

const studyReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.SET_STUDY_LIST:
      return { ...state, studyList: action.payload };
    case actionTypes.SET_STUDY_DETAIL:
      return { ...state, studyDetail: action.payload };
    case actionTypes.SET_STUDY_CREATE_PARAMS:
      return { ...state, studyCreateParams: action.payload };
    default:
      return state;
  }
};

export default studyReducer;
