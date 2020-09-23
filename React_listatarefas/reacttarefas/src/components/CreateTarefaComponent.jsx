import React, { Component } from 'react';
import TarefaService from '../services/TarefaService';

class CreateTarefaComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            tarefa:''
        }
        this.changeTarefaHandle = this.changeTarefaHandle.bind(this);
        this.saveTarefa = this.saveTarefa.bind(this);
    }

    changeTarefaHandle=(event) => {
        this.setState({tarefa: event.target.value});
    }

    saveTarefa = (e) => {
        e.preventDefault();
        let tarefa = {tarefa: this.state.tarefa}
        console.log('tarefa => '+ JSON.stringify(tarefa));

        TarefaService.createTarefa(tarefa).then(res => {
            this.props.history.push('/tarefas');
        })
    }

    cancel(){
        this.props.history.push('/tarefas');
    }

    render() {
        return (
            <div>
                <div className="container">
                    <h1 className="text-center">Adicionar Tarefa</h1>
                    <div classname="row">
                        <div className="card col-md-6 offset-md-3">
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <h3 className="text-center">Digite a sua tarefa a ser realizada:</h3>
                                        <input placeholder="Digite sua tarefa aqui" name="tarefa" className="form-control"
                                        value={this.state.tarefa} onChange={this.changeTarefaHandle}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.saveTarefa}>Salvar</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)}>Cancelar</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        );
    }
}

export default CreateTarefaComponent;