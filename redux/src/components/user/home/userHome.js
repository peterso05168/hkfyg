import React, { Component } from "react";

import { Form, Button } from "react-bootstrap";
class UserHome extends Component {
	constructor(props) {
		super(props);
	}

	componentWillMount() {
	}

	render() {
		const {
			state
		} = this.props;
		return (
			<div >
                this is user page

			</div>
		)
	}

}

export default UserHome;