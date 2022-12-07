import axios from 'axios';
axios.defaults.baseURL = 'http://localhost:8080';

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

export async function apiPostLogin(body, onSuccess, onError = (e) => alert(e), isStub = false) {
  if (isStub) {
    onSuccess(stubData1);
    return true;
  } else {
    axios
      .post('/login', body)
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

export async function apiPostSignup(body, onSuccess, onError = (e) => alert(e), isStub = false) {
  if (isStub) {
    onSuccess(stubData2);
    return true;
  } else {
    const result = await axios
      .post('/signup', body)
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
