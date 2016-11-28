
import br.com.difoccus.sistemadifoccus.util.HibernateUtil;
import java.time.Clock;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author awsilva
 */
public class testeUtil {
    
    public static void main(String[] args) {
	Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
	sessao.close();
	HibernateUtil.getFabricaDeSessoes().close();
        System.out.println("OI");
    }
    
}
