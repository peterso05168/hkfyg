import React from "react";
import PropTypes from 'prop-types';
import { Navbar, Nav } from "react-bootstrap";
import {Router,Link} from "react-router-dom"
import router from "./router.js";
class Root extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			state: 0,
			isUserAuthenticated: true
		}
	}

	
	render() {
        const header = (
        <Navbar bg="dark" variant="dark" className="topnav">
            <Navbar.Brand>香港青年協會賽馬會西貢戶外訓練營</Navbar.Brand>
            <Nav className="mr-auto" />
            <Nav>
                <Nav.Link >登入</Nav.Link>
                <Nav.Link >忘記密碼</Nav.Link>
                <Nav.Link >帳戶註冊</Nav.Link>
                {/* <Nav.Link ><Link to="/home" style={{color: "white"}}>登入</Link></Nav.Link>
                <Nav.Link ><Link to="/admin" style={{color: "white"}}>忘記密碼</Link></Nav.Link>
                <Nav.Link ><Link to="/user" style={{color: "white"}}>帳戶註冊</Link></Nav.Link> */}
            </Nav>
        </Navbar>
    )
		return (
           <div>
               {header}
               {router}
           </div>
		)
	}

}

export default Root;