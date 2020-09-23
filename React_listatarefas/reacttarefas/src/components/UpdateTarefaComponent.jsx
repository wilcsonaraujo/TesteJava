import React, { Component } from 'react';
import TarefaService from '../services/TarefaService';

class UpdateTarefaComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            id:this.props.match.params.id,
            tarefa:''
        }
        this.changeTarefaHandle = this.changeTarefaHandle.bind(this);
        this.updateTarefa = this.updateTarefa.bind(this);
    }

    changeTarefaHandle=(event) => {
        this.setState({tarefa: event.target.value});
    }

    updateTarefa = (e) => {
        e.preventDefault();
        let tarefa = {tarefa: this.state.tarefa}
        console.log('tarefa => '+ JSON.stringify(tarefa));
        
        TarefaService.updateTarefa(tarefa, this.state.id).then( res => {
            this.props.history.push('/tarefas');
        });
    }


    cancel(){
        this.props.history.push('/tarefas');
    }

    componentDidMount(){
        TarefaService.getTarefaByd(this.state.id).then( (res) => {
            let tarefa = res.data;
            this.setState({tarefa: tarefa.tarefa});
        });
    }

    render() {
        return (
            <div>
                <div className="container">
                    <h1 className="text-center">Editar Tarefa</h1>
                    <div classname="row">
                        <div className="card col-md-6 offset-md-3">
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <h3 className="text-center">Digite a sua tarefa correta:</h3>
                                        <input placeholder="Digite sua tarefa aqui" name="tarefa" className="form-control"
                                        value={this.state.tarefa} onChange={this.changeTarefaHandle}/>
                                    </div>
                                    <button className="btn btn-success" onClick={this.updateTarefa}>Editar</button>
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

export default UpdateTarefaComponent;