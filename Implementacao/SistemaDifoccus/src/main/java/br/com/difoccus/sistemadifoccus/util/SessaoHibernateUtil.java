/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.difoccus.sistemadifoccus.util;

import org.hibernate.Session;

/**
 *
 * @author Rodrigo Maria <rammaria@restinga.ifrs.edu.br>
 */
public class SessaoHibernateUtil {
    private Session sessaoHibernate;
    
    public void iniciarSessaoHibernate() {
        sessaoHibernate = HibernateUtil.getFabricaDeSessoes().openSession();
    }
    
    public void iniciarTransacao() {
        sessaoHibernate.beginTransaction();
    }
    
    public void encerrarTransacao() {
        sessaoHibernate.getTransaction().commit();
    }
    
    public void encerrarSessaoHibernate() {
        sessaoHibernate.close();
    }

    public Session getSession() {
        return sessaoHibernate;
    }
}
