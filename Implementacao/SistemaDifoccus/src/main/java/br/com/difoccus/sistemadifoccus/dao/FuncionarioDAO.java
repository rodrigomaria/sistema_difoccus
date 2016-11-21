package br.com.difoccus.sistemadifoccus.dao;

import br.com.difoccus.sistemadifoccus.modelo.Funcionario;
import org.hibernate.Query;
import org.hibernate.Session;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    
    private Session sessao;
    
    public FuncionarioDAO(Session sessao) {
        this.sessao = sessao;
    }

    public FuncionarioDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Funcionario consultaPorEmailESenha(String email, String senha) {
        Query consulta = sessao.createQuery("FROM Funcionario WHERE email = :email and senha = :senha");
        consulta.setString("email", email);
        consulta.setString("senha", senha);
        return (Funcionario) consulta.uniqueResult();
    }
}