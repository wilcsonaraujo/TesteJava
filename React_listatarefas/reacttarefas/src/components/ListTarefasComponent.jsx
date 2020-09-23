import React, { Component } from 'react';
import TarefaService from '../services/TarefaService';

class ListTarefasComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            tarefa: []
        }
        this.addTarefa = this.addTarefa.bind(this);
    }

    componentDidMount(){
        TarefaService.getTarefas().then((res) => {
            this.setState({ tarefa: res.data});
        });
    }

    addTarefa(){
        this.props.history.push('/add_tarefa');
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Lista de Tarefas</h2>
                <div className="row">
                    <button className='btn btn-primary' onClick={this.addTarefa}>Adicionar Tarefa</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Tarefas</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>{
                            this.state.tarefa.map(
                                (tarefa, index) => 
                                <tr key = {index}>
                                    <td><input type="checkbox" name="name1" /></td>
                                    <td>{tarefa.tarefa}</td>
                                    <td>{tarefa.status}</td>
                                </tr>
                            )
                        }
                        </tbody>
                    </table>
                </div>

            </div>
        );
    }
}

export default ListTarefasComponent;