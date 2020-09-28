import React from "react";
import PropTypes from "prop-types";
import { Navbar, Nav } from "react-bootstrap";
import Login from "../containers/Login";
import "./main.scss";
import { useLocation } from "react-router-dom";
import AdminHome from "./admin/home/adminHome";
import UserHome from "./user/home/userHome";
import Home from "./public/home/home";
import router from "../router"
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  Redirect,
} from "react-router-dom";
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      isUserAuthenticated: false,
    };
  }

  componentDidMount() {
    console.log("app props", this.props);
  }

  logout = () => {
    const { logout } = this.props;
    console.log("App -> logout -> logout", logout)
    logout;
    this.forceUpdate();
  };

  render() {
    const { isAuth, loginInfo, location } = this.props;
    console.log("App -> render -> location", location);
    const header = (
      <Navbar bg="dark" variant="dark" className="topnav">
        <Navbar.Brand>香港青年協會賽馬會西貢戶外訓練營</Navbar.Brand>
        <Nav className="mr-auto" />
        {isAuth ? (
          <Nav>
            <Nav.Item>
              <Nav.Link style={{ color: "white" }} disabled>
                帳戶姓名 : {loginInfo.email}
              </Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link style={{ color: "white" }} disabled>
                帳戶身份 : {loginInfo.role}
              </Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link href="/home" style={{ color: "white" }}>
                主頁
              </Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link onClick={this.props.logout} style={{ color: "white" }}>
                登出
              </Nav.Link>
            </Nav.Item>
          </Nav>
        ) : (
          <Nav>
            <Nav.Item>
              <Nav.Link href="/login" style={{ color: "white" }}>
                登入
              </Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link href="/forgetPassword" style={{ color: "white" }}>
                忘記密碼
              </Nav.Link>
            </Nav.Item>
            <Nav.Item>
              <Nav.Link href="/registration" style={{ color: "white" }}>
                帳戶註冊
              </Nav.Link>
            </Nav.Item>
          </Nav>
        )}
      </Navbar>
    );
    return (
      <div>
        <Router>
          <div>
            {header}
            <Switch>
              <Route
                exact
                path={"/"}
                render={() => {
                  return !isAuth ? (
                    <Redirect to="/home" />
                  ) : (
                    <Redirect to="/admin" />
                  );
                }}
              />
              {/* <Route exact path="/home" component={Home} />
              <Route exact path="/login" component={Login} />
              <Route exact path="/admin" component={AdminHome} />
              <Route exact path="/user" component={UserHome} /> */}
               {router}
            </Switch>
          </div>
        </Router>
      </div>
    );
  }
}

App.propTypes = {
  onCreate: PropTypes.func.isRequired,
  location: PropTypes.string,
  isAuth: PropTypes.bool,
  logout: PropTypes.func,
  loginInfo: PropTypes.object,
};

App.defaultProps = {};

export default App;
