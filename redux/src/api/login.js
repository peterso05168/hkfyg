import axios from 'axios';
import actions from '../actions';

const makeRequest = (urlExtension, data) => axios.post(config.baseUrl + urlExtension, data);

export default {
 login: () => makeRequest('/auth/signin', {email: "heichan1106@gmail.com", password: "heichan1106"}),
}