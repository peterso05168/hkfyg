import { connect } from "react-redux";
import TheComponent from "../components/App"; 
import actions from "../actions";

import { getPath } from "../selectors";

const mapStateToProps = (state, ownProps) => {
  return {
    location: getPath(state),
    isAuth: state.login.isAuth,
    loginInfo: state.login,
  };
};

const mapDispatchToProps = (dispatch, ownProps) => {
  return {
    onCreate: () => {
      dispatch({ type: actions.BASIC_ACTION });
    },
    logout: () => {
      dispatch({ type: actions.LOGOUT });
    }
  };
};

const App = connect(mapStateToProps, mapDispatchToProps)(TheComponent);

export default App;
