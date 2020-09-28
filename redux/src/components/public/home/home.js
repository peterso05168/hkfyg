import React, { Component } from "react";
import PropTypes from "prop-types";
import { Table, Button, Modal } from "react-bootstrap";
import "./home.scss";
import { useTable } from "react-table";
// const Home = props => <div>{props.text}</div>;

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      show: false,
    };
  }

  render() {
    const { show } = this.state;
    const title = [
      "",
      "08/10/2020 (四)",
      "09/10/2020 (五)",
      "10/10/2020 (六)",
      "11/10/2020 (日)",
      "12/10/2020 (一)",
      "13/10/2020 (二)",
      "14/10/2020 (三)",
    ];
    const data = [
      [
        "日營",
        "尚餘250位",
        "尚餘173位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
      ],
      [
        "黃昏營",
        "尚餘250位",
        "尚餘173位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
      ],
      [
        "28 人複式客房",
        "尚餘250位",
        "尚餘173位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
      ],
      [
        "12人特選客房",
        "尚餘250位",
        "尚餘173位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
      ],
      [
        "12人標準客房",
        "尚餘250位",
        "尚餘173位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
      ],
      [
        "8人客房",
        "尚餘250位",
        "尚餘173位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
      ],
      [
        "2人客房",
        "尚餘250位",
        "尚餘173位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
        "尚餘250位",
      ],
    ];

    const popup = (
      <Modal show={show} onHide={() => this.setState({ show: false })} centered>
        <Modal.Header closeButton>
          <Modal.Title>Modal heading</Modal.Title>
        </Modal.Header>
        <Modal.Body>Woohoo, you're reading this text in a modal!</Modal.Body>
        <Modal.Footer>
          <Button
            variant="secondary"
            onClick={() => this.setState({ show: false })}
          >
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    );

    return (
      <div className="tableContainer">
        <p> 網上只可查詢15個月內的營位，如查詢往後日子營位，請致電27922727</p>
        <Table striped bordered hover>
          <thead>
            <tr>
              {Object.keys(title).map((value, index) => {
                return (
                  <th>
                    <text>{title[index]}</text>
                    <br />
                    {index > 0 ? (
                      <Button variant="outline-dark">預訂</Button>
                    ) : (
                      ""
                    )}
                  </th>
                );
              })}
            </tr>
          </thead>
          <tbody>
            {Object.keys(data).map((value, index) => {
              return (
                <tr>
                  {Object.keys(data[index]).map((value, index2) => {
                    return (
                      <td style={{ verticalAlign: "middle" }}>
                        {data[index][index2]}
                        <br />
                        {index2 < 1 ? (
                          <Button
                            variant="outline-dark"
                            onClick={() => this.setState({ show: true })}
                          >
                            詳情
                          </Button>
                        ) : (
                          ""
                        )}
                      </td>
                    );
                  })}
                </tr>
              );
            })}
          </tbody>
        </Table>
        <p>＊　男女不可同房</p>

        {popup}
      </div>
    );
  }
}

Home.propTypes = {
  text: PropTypes.string,
};

Home.defaultProps = {
  text: "Hello World",
};

export default Home;
