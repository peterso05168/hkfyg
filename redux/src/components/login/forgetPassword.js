import React, { Component } from "react";
import PropTypes from "prop-types";
import "./login.scss";

import { Form, Button } from "react-bootstrap";
import { Redirect } from "react-router-dom";
import alien from "./alien.png";
class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      redirect: null,
    };
  }

  render() {
    const { redirect } = this.state;
    const { result, isAuth } = this.props;
    console.log("Login -> render -> isAuth", isAuth);
    if (redirect) {
      return <Redirect to={redirect} />;
    }

    const forgetPassword = (
      <div className="loginInfo">
        <h2 className="loginTitle">忘記密碼</h2>
        <div className="loginForm">
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>登記電郵</Form.Label>
              <Form.Control type="email" placeholder="登記電郵" />
            </Form.Group>
            <Form.Group controlId="formBasicPassword">
              <Form.Label>驗證碼</Form.Label>
              <Form.Control placeholder="驗證碼" />
            </Form.Group>
            <Button variant="secondary" type="submit">
              遞交
            </Button>{" "}
            <Button variant="secondary" onClick={() => this.setState({redirect:"/home"})}>
              返回主頁
            </Button>
          </Form>
        </div>
      </div>
    );
    return (
      <div className="loginBox">
        {forgetPassword}
      </div>
    );
  }
}

Login.propTypes = {
  result: PropTypes.object,
  onClickLogin: PropTypes.func,
  isAuth: PropTypes.bool,
};

Login.defaultProps = {
  goHome: () => console.log("going home"),
};

export default Login;
