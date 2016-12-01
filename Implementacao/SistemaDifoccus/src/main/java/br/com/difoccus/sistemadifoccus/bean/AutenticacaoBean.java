/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.difoccus.sistemadifoccus.bean;

import br.com.difoccus.sistemadifoccus.dao.FuncionarioDAO;
import br.com.difoccus.sistemadifoccus.modelo.Funcionario;
import br.com.difoccus.sistemadifoccus.util.SessaoHibernateUtil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
    
    public void filtro(){
        if(funcionarioLogado.getEmail() == null || funcionarioLogado.getSenha() == null)
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(AutenticacaoBean.class.getName()).log(Level.SEVERE, null, ex);
        } 
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
                HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sessao.setAttribute("usuario", funcionarioLogado);
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
