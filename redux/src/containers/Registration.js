import { connect } from 'react-redux';
import actions from '../actions';
import TheComponent from '../components/login/registration';
const mapStateToProps = (state, ownProps) => {
    return {
        result: state.login,
        isAuth: state.login.isAuth
    }
}
const mapDispatchToProps = (dispatch, ownProps) => {
    return {
        onClickLogin: () => {
            dispatch({
                type: actions.LOGIN
            })
        }
    }
}
const Login = connect(
    mapStateToProps,
    mapDispatchToProps
)(TheComponent)
export default Login;