import React from "react";
import { Router, Route, IndexRoute, Redirect } from "react-router";
import { history } from "./store.js";

import App from "./containers/App";
import Login from "./containers/Login"
import ForgetPassword from "./containers/ForgetPassword"
import Registration from "./containers/Registration"
import Home from "./components/public/home/home";
import AdminHome from "./components/admin/home/adminHome"
import UserHome from "./components/user/home/userHome"
// import {
//   BrowserRouter as Router,
//   Switch,
//   Route,
//   Link,
//   Redirect
// } from "react-router-dom";
const router = (
  <Router onUpdate={() => window.scrollTo(0, 0)} history={history}>

    <Route path="/home" component={Home} />
    <Route path="/login" component={Login} />
    <Route path="/admin" component={AdminHome} />
    <Route path="/user" component={UserHome} />
    <Route path="/registration" component={Registration} />
    <Route path="/forgetPassword" component={ForgetPassword} />
    {/* <Route exact path="/">
      <Redirect to="/login" />
    </Route> */}
  </Router>
);

export default router;
