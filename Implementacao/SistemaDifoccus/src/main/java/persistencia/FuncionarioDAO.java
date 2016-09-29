package persistencia;

import java.util.List;
import modelo.Funcionario;
import org.hibernate.Session;

public class FuncionarioDAO {
    private Session sessao;
    
    public FuncionarioDAO() {
        sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.beginTransaction();
    }
    
    public void salvar(Funcionario f) {
        sessao.saveOrUpdate(f);
    }
    
    public Funcionario carregar(int id) {
        return (Funcionario)sessao.get(Funcionario.class, id);
    }
    
    public void remover(Funcionario f) {
        sessao.delete(f);
    }
    
    public List<Funcionario> listar() {
        return sessao.createCriteria(Funcionario.class).list();
    }
    
    public void encerrar() {
        sessao.getTransaction().commit();
    }
}