import { combineReducers } from "redux";
import { routerReducer } from "react-router-redux";
import loginReducer from "./loginReducer";

export const reducers = combineReducers({
  routing: routerReducer,
  login: loginReducer
});
