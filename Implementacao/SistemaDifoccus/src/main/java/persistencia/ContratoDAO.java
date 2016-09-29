package persistencia;

import java.util.List;
import modelo.Contrato;
import org.hibernate.Session;

public class ContratoDAO {
    private Session sessao;
    
    public ContratoDAO() {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.beginTransaction();
    }
    
    public void salvar(Contrato c) {
        sessao.saveOrUpdate(c);
    }
    
    public Contrato carregar(int id) {
        return (Contrato)sessao.get(Contrato.class, id);
    }
    
    public void remover(Contrato c) {
        sessao.delete(c);
    }
    
    public List<Contrato> listar() {
        return sessao.createCriteria(Contrato.class).list();
    }
    
    public void encerrar() {
        sessao.getTransaction().commit();
    }
}