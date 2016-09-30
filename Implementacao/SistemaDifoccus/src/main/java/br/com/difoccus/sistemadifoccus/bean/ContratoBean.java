package br.com.difoccus.sistemadifoccus.bean;

import java.util.List;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.difoccus.sistemadifoccus.dao.ContratoDAO;
import br.com.difoccus.sistemadifoccus.modelo.Contrato;

@ManagedBean
@ViewScoped
public class ContratoBean implements Serializable {
	private Contrato contrato;
	private List<Contrato> contratos;

	public Contrato getContrato() {
            return contrato;
	}
	public void setContrato(Contrato contrato) {
            this.contrato = contrato;
	}

	public List<Contrato> getContratos() {
            return contratos;
        }
	public void setContratos(List<Contrato> contratos) {
            this.contratos = contratos;
	}        
        

	@PostConstruct
	public void listar() {
		try {
			ContratoDAO contratoDAO = new ContratoDAO();
			contratos = contratoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os contratos");
			erro.printStackTrace();
		}
	}

	public void novo() {
		contrato = new Contrato();
	}

	public void salvar() {
		try {
			ContratoDAO contratoDAO = new ContratoDAO();
			contratoDAO.merge(contrato);

			contrato = new Contrato();
			contratos = contratoDAO.listar();

			Messages.addGlobalInfo("Contrato salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o contrato");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			contrato = (Contrato) evento.getComponent().getAttributes().get("contratoSelecionado");

			ContratoDAO contratoDAO = new ContratoDAO();
			contratoDAO.excluir(contrato);
			
			contratos = contratoDAO.listar();

			Messages.addGlobalInfo("Contrato removido com sucesso");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o contrato");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		contrato = (Contrato) evento.getComponent().getAttributes().get("contratoSelecionado");
	}
}