package br.com.difoccus.sistemadifoccus.bean;

import br.com.difoccus.sistemadifoccus.dao.ContratoDAO;
import java.util.List;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import org.omnifaces.util.Messages;
import br.com.difoccus.sistemadifoccus.dao.FormandoDAO;
import br.com.difoccus.sistemadifoccus.modelo.Contrato;
import br.com.difoccus.sistemadifoccus.modelo.Formando;

@ManagedBean
@ViewScoped
public class FormandoBean implements Serializable {
    private Formando formando;
    private List<Formando> formandos;
    private List<Contrato> contratos;
    private List<Formando> formandosFiltrados;

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }

    public Formando getFormando() {
        return formando;
    }
    public void setFormando(Formando formando) {
        this.formando = formando;
    }

    public List<Formando> getFormandos() {
        return formandos;
    }
    public void setFormandos(List<Formando> formandos) {
        this.formandos = formandos;
    }

    public List<Formando> getFormandosFiltrados() {
        return formandosFiltrados;
    }

    public void setFormandosFiltrados(List<Formando> formandosFiltrados) {
        this.formandosFiltrados = formandosFiltrados;
    }
    
    @PostConstruct
    public void listar() {
        try {
            
            FormandoDAO formandoDAO = new FormandoDAO();
            formandos = formandoDAO.listar();
            
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar listar os formandos");
            erro.printStackTrace();
        }
    }

    public void novo(){
        try {
            formando = new Formando();
            ContratoDAO contratoDao = new ContratoDAO();
            contratos = contratoDao.listar();
        } 
        catch (Exception e) {
            Messages.addFlashGlobalError("Ocorreu um erro ao gerar uma nova cidade");
            //erro.printStackTrace();
        }
 
        
        
    }

    public void salvar() {
        try {
            FormandoDAO formandoDAO = new FormandoDAO();
            formandoDAO.merge(formando);

            formando = new Formando();
            formandos = formandoDAO.listar();

            Messages.addGlobalInfo("Formando salvo com sucesso");
        } catch (RuntimeException erro) {
            Messages.addGlobalError("Ocorreu um erro ao tentar salvar o formando");
            erro.printStackTrace();
        }
    }

    public void excluir(ActionEvent evento) {
        try {
            formando = (Formando) evento.getComponent().getAttributes().get("formandoSelecionado");

            FormandoDAO formandoDAO = new FormandoDAO();
            formandoDAO.excluir(formando);

            formandos = formandoDAO.listar();

            Messages.addGlobalInfo("Formando removido com sucesso");
        } catch (RuntimeException erro) {
            Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o formando");
            erro.printStackTrace();
        }
    }

    public void editar(ActionEvent evento){
            formando = (Formando) evento.getComponent().getAttributes().get("formandoSelecionado");
    }
}