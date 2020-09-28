import React, { Component } from "react";
import { Form, Button, Accordion, Card, Table } from "react-bootstrap";
import "./adminHome.scss";
import { object } from "prop-types";
import { CardActions } from "material-ui";
import { FileText } from "react-bootstrap-icons";
class AdminHome extends Component {
  constructor(props) {
    super(props);
    this.state = {
      reportList: [
        {
          firstLevel: "申請營位",
          secondLevel: [],
        },
        {
          firstLevel: "預訂記錄管理",
          secondLevel: ["查詢所有預訂記錄", "查詢/處理預訂記錄上載文件"],
        },
        {
          firstLevel: "報價記錄管理",
          secondLevel: [],
        },
        {
          firstLevel: "待辦事項",
          secondLevel: [],
        },
        {
          firstLevel: "當日入營/在營記錄",
          secondLevel: [],
        },
        {
          firstLevel: "房間管理",
          secondLevel: ["房表"],
        },
        {
          firstLevel: "活動及場地管理",
          secondLevel: ["活動表", "場地表"],
        },
        {
          firstLevel: "活動導師管理",
          secondLevel: ["查詢/處理活動導師當值時段"],
        },
        {
          firstLevel: "膳食管理",
          secondLevel: ["飯表", "膳食坐位安排", "當日膳食數量"],
        },
        {
          firstLevel: "SMS通訊",
          secondLevel: ["發送SMS (教練)", "發送SMS (團體)", "內容設定"],
        },
        {
          firstLevel: "我的範本",
          secondLevel: [],
        },
        {
          firstLevel: "更改密碼",
          secondLevel: [],
        },
        {
          firstLevel: "設定",
          secondLevel: [
            "房間",
            "營舍/房間種類",
            "非宿營人數限制",
            "公眾假期",
            "繁忙期",
            "潮汐",
            "活動",
            "活動裝備",
            "場地種類",
            "場地",
            "膳食設備",
            "膳食種類",
            "膳食",
            "其他費用",
            "團體性質聲明",
            "聲明",
            "收費及基本設定",
            "電郵內容",
            "短訊內容",
            "系統設定",
          ],
        },
        {
          firstLevel: "帳戶管理",
          secondLevel: [
            "管理員工帳戶",
            "管理公眾帳戶",
            "管理教練帳戶",
            "批量轉換跟進員工",
          ],
        },
        {
          firstLevel: "報表",
          secondLevel: [],
        },
      ],
    };
  }

  componentDidMount() {}

  expandPanel = (index) => {
    const { reportList } = this.state;

    var e = document.getElementsByClassName("panel");
    if (e[index].classList.contains("active")) {
      e[index].classList.remove("active");
      e[index].style.maxHeight = "0";
    } else {
      e[index].classList.add("active");
      e[index].style.maxHeight = `${
        (reportList[index]["secondLevel"].length + 1) * 30
      }px `;
    }
  };

  render() {
    const { reportList } = this.state;

    const sideBar = (
      <div className="sidebar">
        {Object.keys(reportList).map((value, index) => {
          return (
            <div className="sidebarItem">
              <div className="expand" onClick={() => this.expandPanel(index)}>
                <FileText color="white" size={30} />
                <text className="sidebarText">
                  {reportList[index]["firstLevel"]}
                </text>
              </div>
              <div className="panel">
                {Object.keys(reportList[index]["secondLevel"]).map(
                  (value, index2) => {
                    return (
                      <div className="panelItem">
                        <text className="panelText">
                          {reportList[index]["secondLevel"][index2]}
                        </text>
                      </div>
                    );
                  }
                )}
              </div>
            </div>
          );
        })}
      </div>
    );

    const content = (
      <div>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>#</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Username</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Mark</td>
              <td>Otto</td>
              <td>@mdo</td>
            </tr>
            <tr>
              <td>2</td>
              <td>Jacob</td>
              <td>Thornton</td>
              <td>@fat</td>
            </tr>
            <tr>
              <td>3</td>
              <td colSpan="2">Larry the Bird</td>
              <td>@twitter</td>
            </tr>
          </tbody>
        </Table>
      </div>
    );
    return (
      <div className="layout">
        {sideBar}
        {content}
      </div>
    );
  }
}

export default AdminHome;
