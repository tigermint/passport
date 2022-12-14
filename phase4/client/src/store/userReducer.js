// action - state management
import * as actionTypes from './actions';

// actions
export const userAction = {
  login: (payload) => ({ type: actionTypes.LOGIN, payload }),
  signup: (payload) => ({ type: actionTypes.SIGNUP, payload }),
  logout: (payload) => ({ type: actionTypes.LOGOUT, payload })
};

export const initialState = {
  user: null
};

const userReducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.LOGIN:
      return { ...state, user: action.payload };
    case actionTypes.SIGNUP:
      return { ...state, user: action.payload };
    case actionTypes.LOGOUT:
      return { ...state, user: null };
    default:
      return state;
  }
};

export default userReducer;
