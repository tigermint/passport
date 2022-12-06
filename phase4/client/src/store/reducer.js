import { combineReducers } from 'redux';

// reducer import
import customizationReducer from './customizationReducer';
import userReducer from './userReducer';
import studyReducer from './studyReducer';
import sessionReducer from './sessionReducer';

// ==============================|| COMBINE REDUCER ||============================== //

const reducer = combineReducers({
  customization: customizationReducer,
  userReducer,
  studyReducer,
  sessionReducer
});

export default reducer;
