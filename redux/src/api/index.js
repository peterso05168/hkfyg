import axios from 'axios';
import actions from '../actions';

const makeRequest = (urlExtension, data) => axios.post(config.baseUrl + urlExtension, data);

export default {
	basicFunction: () => makeRequest({type: 'post_data_for_backend'}),
 login: () => makeRequest('/auth/signin', {email: "heichan1106@gmail.com", password: "heichan1106"}),
 getUser: () => makeRequest('/user/getAllUserList'),
 createUserPri: () => makeRequest('/userPrivilege/createUserPrivilege', {name: "PRI" + new Date()})
}