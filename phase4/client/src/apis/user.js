import axios from 'axios';

const stubData1 = {
  id: 1,
  name: '호반우',
  school_email: 'hobanwoo@knu.ac.kr',
  bank_name: '카카오뱅크',
  bank_account: '3333-12-1234567'
};

const stubData2 = {
  id: 1,
  name: '호반우',
  school_email: 'hobanwoo@knu.ac.kr',
  bank_name: '카카오뱅크',
  bank_account: '3333-12-1234567'
};

export function apiPostLogin(body, onSuccess, onError = (e) => alert(e), isStub = true) {
  if (isStub) {
    onSuccess(stubData1);
  } else {
    axios
      .post('/login', body)
      .then((response) => {
        onSuccess(response.data);
      })
      .catch((error) => {
        onError(error);
      });
  }
}

export function apiPostSignup(body, onSuccess, onError = (e) => alert(e), isStub = true) {
  if (isStub) {
    onSuccess(stubData2);
    return true;
  } else {
    axios
      .post('/signup', body)
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
