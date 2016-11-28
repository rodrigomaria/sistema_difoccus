package br.com.difoccus.sistemadifoccus.dao;

import br.com.difoccus.sistemadifoccus.modelo.Funcionario;
import br.com.difoccus.sistemadifoccus.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FuncionarioDAO extends GenericDAO<Funcionario> {
    
    public Funcionario autenticar(String email, String senha){
        
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Funcionario funcionario = null;

        try {
            Query consulta = sessao.createQuery("SELECT f FROM Funcionario f WHERE f.email = :email AND f.senha = :senha");
            consulta.setString("email", email);
            consulta.setString("senha", senha);
            
            funcionario = (Funcionario) consulta.uniqueResult();
            
        } catch (RuntimeException erro) {  
            throw erro;
        } finally {
            sessao.close();
        }
        return funcionario;        
    }
    
}