package br.com.difoccus.sistemadifoccus.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.difoccus.sistemadifoccus.util.HibernateUtil;
import org.hibernate.exception.ConstraintViolationException;
import org.omnifaces.util.Messages;



public class GenericDAO<Entidade> {

    private Class<Entidade> classe;

    @SuppressWarnings("unchecked")
    public GenericDAO(){
        this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void salvar(Entidade entidade) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.save(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                    transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public List<Entidade> listar(){
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe);
            List<Entidade> resultado = consulta.list();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    @SuppressWarnings({ "deprecation", "unchecked" })
    public Entidade buscar(int codigo){
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        try {
            Criteria consulta = sessao.createCriteria(classe);
            consulta.add(Restrictions.idEq(codigo));
            Entidade resultado = (Entidade)consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public void excluir(Entidade entidade) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.delete(entidade);
            transacao.commit();
        } catch(ConstraintViolationException e){
            if (transacao != null) {
                transacao.rollback();
            }
            Messages.addGlobalInfo("Falha ao excluir");
            throw e;
        } catch (RuntimeException erro) {
            if (transacao != null) {
                    transacao.rollback();
            }
            throw erro; 
        } finally {
            sessao.close();
        }
    }

    public void editar(Entidade entidade) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.update(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                    transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }

    public void merge(Entidade entidade) {
        Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
        Transaction transacao = null;

        try {
            transacao = sessao.beginTransaction();
            sessao.merge(entidade);
            transacao.commit();
        } catch (RuntimeException erro) {
            if (transacao != null) {
                    transacao.rollback();
            }
            throw erro;
        } finally {
            sessao.close();
        }
    }
}