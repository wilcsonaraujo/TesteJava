import axios from 'axios';

const TAREFAS_API_BASE_URL = "http://localhost:8080/api/v1/tarefas";

class TarefaService{
    getTarefas(){
        return axios.get(TAREFAS_API_BASE_URL);
    }

    createTarefa(tarefa){
        return axios.post(TAREFAS_API_BASE_URL, tarefa);
    }

    getTarefaById(tarefaId){
        return axios.get(TAREFAS_API_BASE_URL + '/' + tarefaId);
    }

    updateTarefa(tarefa, tarefaId){
        return axios.put(TAREFAS_API_BASE_URL + '/' + tarefaId, tarefa);
    }

    deleteTarefa(tarefaId){
        return axios.delete(TAREFAS_API_BASE_URL + '/' + tarefaId);
    }
}

export default new TarefaService()