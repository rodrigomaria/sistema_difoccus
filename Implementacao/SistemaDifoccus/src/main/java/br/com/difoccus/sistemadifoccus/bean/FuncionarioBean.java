package br.com.difoccus.sistemadifoccus.bean;


import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.difoccus.sistemadifoccus.modelo.Funcionario;
import br.com.difoccus.sistemadifoccus.dao.FuncionarioDAO;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {
    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private List<Funcionario> funcionariosFiltrados;

    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }   

    public List<Funcionario> getFuncionariosFiltrados() {
        return funcionariosFiltrados;
    }

    public void setFuncionariosFiltrados(List<Funcionario> funcionariosFiltrados) {
        this.funcionariosFiltrados = funcionariosFiltrados;
    }
    
    


    @PostConstruct
    public void listar() {
        try {
                FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
                funcionarios = funcionarioDAO.listar();
        } catch (RuntimeException erro) {
                Messages.addGlobalError("Ocorreu um erro ao tentar listar os funcionarios");
                erro.printStackTrace();
        }
    }

    public void novo() {
        funcionario = new Funcionario();
    }

    public void salvar() {
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.merge(funcionario);

            funcionario = new Funcionario();
            funcionarios = funcionarioDAO.listar();

            Messages.addGlobalInfo("Funcionario salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar o funcionario");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.excluir(funcionario);

            funcionarios = funcionarioDAO.listar();

            Messages.addGlobalInfo("Funcionario removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o funcionario");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento){
        funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionado");
    }
}