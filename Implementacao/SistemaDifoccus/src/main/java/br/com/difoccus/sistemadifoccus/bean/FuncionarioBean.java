package br.com.difoccus.sistemadifoccus.bean;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.difoccus.sistemadifoccus.modelo.Funcionario;
import br.com.difoccus.sistemadifoccus.dao.FuncionarioDAO;

@ManagedBean(name="funcionarioBean")
public class FuncionarioBean {
    private Funcionario funcionario = new Funcionario();
    private final FuncionarioDAO dao = new FuncionarioDAO();
    private List<Funcionario> listaFuncionarios;
    
    public FuncionarioBean() {
        listaFuncionarios = dao.listar();
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
    
    public void salvar() {
        dao.salvar(funcionario);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionario incluído com sucesso.", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        funcionario = new Funcionario();
    }
    
    public void carregar(int id) {
        funcionario = dao.carregar(id);
    }
    
    public void remover(Funcionario f) {
        dao.remover(f);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Funcionario removido com sucesso.", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        listaFuncionarios.remove(funcionario);
    }
    
    @PreDestroy
    public void encerrar() {
        dao.encerrar();
    }
}