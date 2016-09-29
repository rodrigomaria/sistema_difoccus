package Beans;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import modelo.Contrato;
import persistencia.ContratoDAO;

@ManagedBean(name="contratoBean")
public class ContratoBean {
    private Contrato contrato = new Contrato();
    private final ContratoDAO dao = new ContratoDAO();
    private List<Contrato> listaContratos;
    
    public ContratoBean() {
        listaContratos = dao.listar();
    }
    
    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
    public List<Contrato> getListaContratos() {
        return listaContratos;
    }
    
    public void salvar() {
        dao.salvar(contrato);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contrato incluído com sucesso.", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        contrato = new Contrato();
    }
    
    public void carregar(int id) {
        contrato = dao.carregar(id);
    }
    
    public void remover(Contrato c) {
        dao.remover(c);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contrato removido com sucesso.", "");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        listaContratos.remove(contrato);
    }
    
    @PreDestroy
    public void encerrar() {
        dao.encerrar();
    }
}