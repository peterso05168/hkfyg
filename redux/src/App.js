import React from "react";

import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';

import { Provider } from "react-redux";
import { store } from "./store.js";
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Apps from "./containers/App";

const muiTheme = getMuiTheme({});

const App = props => <Provider store={store}>
  <MuiThemeProvider muiTheme={muiTheme}>
    <Router>
      <Route path="/" component={Apps} />
    </Router>
  </MuiThemeProvider>
</Provider>;

export default App;
