import { data } from 'jquery';
import React, { Component } from 'react';
import TarefaService from '../services/TarefaService';

class ListTarefasComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            tarefa: []
        }
        this.addTarefa = this.addTarefa.bind(this);
        this.updateTarefa = this.updateTarefa.bind(this);
        this.updateStatus = this.updateStatus.bind(this);
        this.deleteTarefa = this.deleteTarefa.bind(this);
    }

    componentDidMount(){
        TarefaService.getTarefas().then((res) => {
            this.setState({ tarefa: res.data});
        });
    }

    addTarefa(){
        this.props.history.push('/add_tarefa');
    }

    updateTarefa(id){
        this.props.history.push(`/update_tarefa/${id}`);
    }
    updateStatus(id){
        this.props.history.push(`/tarefas/${id}`);
    }

    deleteTarefa(id){
        TarefaService.deleteTarefa(id).then( res => {
            this.setState({tarefa: this.state.tarefa.filter(tarefa => tarefa.id !== id)});
        })
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Lista de Tarefas</h2>
                <div className="row">
                    <button style={{marginBottom: "10px"}} className='btn btn-primary' onClick={this.addTarefa}>Adicionar Tarefa</button>
                </div>
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Tarefas</th>
                                <th>Status</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>{
                            this.state.tarefa.map(
                                (tarefa, index) => 
                                <tr key = {index}>
                                    <th scope="row">
                                        <input onChange={(event) =>{
                                            let checked = event.target.checked;
                                            this.setState(this.state.tarefa.map((res) => {
                                                if(tarefa.id ===  res.id){
                                                    res.select=true;
                                                    res.status="Concluído";
                                                    
                                                }
                                            }));
                                        }} type="checkbox" value={this.state.tarefa.status} checked={tarefa.select}></input>
                                    </th>
                                    <td>{tarefa.tarefa}</td>
                                    <td>{tarefa.status}</td>
                                    <td><button onClick={() => this.updateTarefa(tarefa.id)} className="btn btn-info">Editar</button>
                                    <button style={{marginLeft: "10px"}} onClick={() => this.deleteTarefa(tarefa.id)} className="btn btn-danger">Deletar</button>
                                    </td>
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