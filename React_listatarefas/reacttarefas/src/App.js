import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route, Switch}  from 'react-router-dom'
import ListTarefasComponent from './components/ListTarefasComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import CreateTarefaComponent from './components/CreateTarefaComponent';

function App() {
  return (

    <div>
      <Router>
        <HeaderComponent/>
            <div className="container">
              <Switch> 
                  <Route path = "/" exact component={ListTarefasComponent}></Route>
                  <Route path = "/tarefas" component={ListTarefasComponent}></Route>
                  <Route path = "/add_tarefa" component={CreateTarefaComponent}></Route>
                  <ListTarefasComponent/>
              </Switch>
            </div>
          <FooterComponent/>
      </Router>
    </div>
  );
}

export default App;
