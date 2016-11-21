/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.difoccus.sistemadifoccus.bean;

import br.com.difoccus.sistemadifoccus.dao.FuncionarioDAO;
import br.com.difoccus.sistemadifoccus.modelo.Funcionario;
import br.com.difoccus.sistemadifoccus.util.SessaoHibernateUtil;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rodrigo Maria <rammaria@restinga.ifrs.edu.br>
 */
@ManagedBean
@SessionScoped
public class SessaoFuncionarioBean {
    private String email;
    private String senha;
    private Funcionario funcionarioLogado;
    private FuncionarioDAO dao;

    public SessaoFuncionarioBean() {
        HttpSession sessaoHTTP = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        SessaoHibernateUtil controleSessaoHibernate = (SessaoHibernateUtil) sessaoHTTP.getAttribute("controleSessaoHibernate");
        dao = new FuncionarioDAO(controleSessaoHibernate.getSession());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }
    
    public String fazerLogin() {
        funcionarioLogado = dao.consultaPorEmailESenha(email, senha);
        if(funcionarioLogado == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou senha inválidos!", ""));
            return null;
        } else {
            return "index";
        }
    }
    
    public String logout() {
        funcionarioLogado = null;
        return "login";
    }
    
    public boolean temUsuarioLogado() {
        return funcionarioLogado != null;
    }
}
