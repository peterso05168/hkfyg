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
	  redirect: null
    };
  }

  changeUp() {
    // console.log("12312312", document.getElementsByClassName("icon"));
    document.getElementsByClassName("icon")[0].style.transform =
      "translateY(-28px)";
    document.getElementsByClassName("icon")[0].style.transitionDuration = "3s";
  }

  changeDown() {
    document.getElementsByClassName("icon")[0].style.transform =
      "translateY(0px)";
    document.getElementsByClassName("icon")[0].style.transitionDuration = "1s";
  }

  render() {
    const { redirect } = this.state;
    const { result, isAuth } = this.props;
	console.log("Login -> render -> isAuth", isAuth);
	if(redirect) {
		return <Redirect to={redirect} />
	}
    const loginForm = (
      <div className="loginInfo">
        <h2 className="loginTitle">登入</h2>
        <div className="loginForm">
          <Form>
            <Form.Group controlId="formBasicEmail">
              <Form.Label>登記電郵</Form.Label>
              <Form.Control type="email" placeholder="登記電郵" />
            </Form.Group>
            <Form.Group controlId="formBasicPassword">
              <Form.Label>密碼</Form.Label>
              <Form.Control
                type="password"
                placeholder="密碼"
                style={{ zIndex: "-10" }}
              />
            </Form.Group>
            <img src={alien} className="icon" />
            <Button
              variant="secondary"
              onClick={this.props.onClickLogin}
              onMouseOver={this.changeUp}
              onMouseLeave={this.changeDown}
            >
              登入
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
        {loginForm}
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
