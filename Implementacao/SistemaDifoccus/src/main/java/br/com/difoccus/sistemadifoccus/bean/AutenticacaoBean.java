/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.difoccus.sistemadifoccus.bean;

import br.com.difoccus.sistemadifoccus.dao.FuncionarioDAO;
import br.com.difoccus.sistemadifoccus.modelo.Funcionario;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.omnifaces.util.Messages;

/**
 *
 * @author rmimportacoes
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean {
    
    private Funcionario funcionarioLogado;
  
    public Funcionario getFuncionarioLogado() {
        if(funcionarioLogado == null)
            funcionarioLogado = new Funcionario();
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }
    
    public String entrar(){
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioLogado = funcionarioDAO.autenticar(funcionarioLogado.getEmail(), funcionarioLogado.getSenha());
            if(funcionarioLogado == null){
                Messages.addGlobalInfo("Falha ao autenticar");
                return "login";
            }
            else{
                Messages.addGlobalInfo("Usuario autenticado");
                return "contrato";
            }
        } catch (Exception e) {
            
        }
        return "login";
    }
    
    public String sair(){
        funcionarioLogado = null;
        return "login.xhtml?faces-redirect=true";
    }
    

}
