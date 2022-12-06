import { combineReducers } from 'redux';

// reducer import
import customizationReducer from './customizationReducer';
import studyReducer from './studyReducer';
import sessionReducer from './sessionReducer';

// ==============================|| COMBINE REDUCER ||============================== //

const reducer = combineReducers({
  customization: customizationReducer,
  studyReducer,
  sessionReducer
});

export default reducer;
