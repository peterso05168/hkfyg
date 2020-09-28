import actions from '../actions';
//return state for init website
const loginReducer = (state = {
  email: localStorage.getItem("email"),
  token: localStorage.getItem("token"),
  role: localStorage.getItem("role"),
  isAuth: localStorage.getItem("token") != ""
}, action) => {
  console.log("login reducer state:", state, action)
  switch (action.type) {
    case actions.LOGIN:
      state = {
        ...state,
        payload: action.payload
      }
      return state;
    case actions.LOGIN + actions.SUCCESS:
      localStorage.setItem("email",  action.data.data.email);
      localStorage.setItem("token",  action.data.data.token);
      localStorage.setItem("role",  action.data.data.role);
      return state = {
        ...state,
        email: localStorage.getItem("email"),
        token: localStorage.getItem("token"),
        role: localStorage.getItem("role"),
        isAuth: true
      }
    case actions.LOGOUT + actions.SUCCESS:
      localStorage.setItem("token", "");
      localStorage.setItem("email", "");
      localStorage.setItem("role",[]);
      return state = {
        ...state,
        email: "",
        token: "",
        role: [],
        isAuth: false
      }
    default: return state
  }
}

export default loginReducer;