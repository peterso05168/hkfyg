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
    const register = (
      <div className="registerInfo">
        <h2 className="loginTitle">帳戶註冊</h2>
        <div className="loginForm">
          <Form>
            <Form.Group controlId="">
              <Form.Label>登記電郵</Form.Label>
              <Form.Control type="email" placeholder="登記電郵" />
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>驗證碼</Form.Label>
              <Form.Control type="password" placeholder="驗證碼" />
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>確認密碼</Form.Label>
              <Form.Control type="password" placeholder="確認密碼" />
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>驗證碼</Form.Label>
              <Form.Control type="password" placeholder="Password" />
            </Form.Group>
            <hr />
            <h4>圑體資料</h4>
            <Form.Group controlId="">
              <Form.Label>團體名稱</Form.Label>
              <Form.Control placeholder="團體名稱" style={{ width: "50%" }} />
              <Form.Text className="text-muted">
                如以個人名義申請，請填上申請人全名 (以香港身份證上所顯示為準)
              </Form.Text>
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>團體性質</Form.Label>
              <Form.Control as="select">
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
                <option>5</option>
              </Form.Control>
            </Form.Group>
            <hr />
            <h4>聯絡人資料</h4>
            <Form.Group controlId="">
              <Form.Label>姓名</Form.Label>
              <Form.Control placeholder="姓名" />
              <Form.Text className="text-muted">
                請填上申請人全名(以香港身份證上所顯示為準)
              </Form.Text>
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>電話</Form.Label>
              <Form.Control placeholder="電話" />
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>手提電話</Form.Label>
              <Form.Control placeholder="手提電話" />
              <Form.Text className="text-muted">
                請填上有效的香港手提電話號碼，營地將以此號碼發放重要訊息
              </Form.Text>
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>傳真號碼</Form.Label>
              <Form.Control placeholder="傳真號碼" />
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>郵寄地址</Form.Label>
              <Form.Control
                as="textarea"
                rows="5"
                placeholder="郵寄地址"
                style={{ width: "50%" }}
              />
            </Form.Group>
            <hr />
            <h4>領隊資料</h4>
            <Form.Group controlId="">
              <Form.Label>姓名</Form.Label>
              <Form.Control placeholder="姓名" />
              <Form.Text className="text-muted">
                須年滿18歲及持有香港身份證，並能出席整個活動
              </Form.Text>
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>手提電話</Form.Label>
              <Form.Control placeholder="手提電話" />
              <Form.Text className="text-muted">
                請填上有效的香港手提電話號碼，營地將以此號碼發放重要訊息
              </Form.Text>
            </Form.Group>
            <Form.Group controlId="">
              <Form.Label>電郵地址</Form.Label>
              <Form.Control placeholder="電郵地址" style={{ width: "50%" }} />
            </Form.Group>
            <Form.Group controlId="">
              <Form.Check
                type="checkbox"
                label="	我同意接收由<%=org_name %>發放有關營地優惠資訊的推廣信息"
              />
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
        {register}
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
