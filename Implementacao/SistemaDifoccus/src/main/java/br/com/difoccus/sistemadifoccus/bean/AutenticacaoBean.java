/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.difoccus.sistemadifoccus.bean;

import br.com.difoccus.sistemadifoccus.dao.FuncionarioDAO;
import br.com.difoccus.sistemadifoccus.modelo.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
    
    public void entrar(){
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioLogado = funcionarioDAO.autenticar(funcionarioLogado.getEmail(), funcionarioLogado.getSenha());
        } catch (Exception e) {
            
        }
        
    }
}
