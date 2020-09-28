import { takeLatest, put, call } from 'redux-saga/effects'
import actions from '../actions'
import api from '../api/index';
import { store } from '../store';
function* generic(...data) {
    let [func, params] = data;
    let { type } = params;
    try {
        const data = yield call(api[func], params);
        yield put({ type: actions[type] + actions.SUCCESS, data });
    } catch (error) {
        console.error('saga error: ', error);
        yield put({ type: actions[type] + actions.FAIL, error })
    }
}

function* login(...data) {
    console.log("login: ", data)
    try {
        const data = yield call(api.login);
        yield put({ type: actions.LOGIN + actions.SUCCESS, data });
        console.log("login success data:", data)

    } catch (error) {
        console.log('saga fail: ', error);
        yield put({ type: actions.LOGIN + actions.FAIL, error });

    }
}

function* logout(...data) {
    console.log("logout: ", data)
    yield put({ type: actions.LOGOUT + actions.SUCCESS, data });
    console.log("logout success data:", data)

}

export function* sagas() {
    yield takeLatest(actions.LOGIN, login);
    yield takeLatest(actions.LOGOUT, logout);
    // yield login(actions.LOGIN, login);
}