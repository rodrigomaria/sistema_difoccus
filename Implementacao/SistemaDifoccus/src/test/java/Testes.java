
import br.com.difoccus.sistemadifoccus.dao.FuncionarioDAO;
import br.com.difoccus.sistemadifoccus.modelo.Funcionario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Will
 */
public class Testes {
    
    public static void main(String[] args) {
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        Funcionario f = funcionarioDAO.autenticar("andrius@difoccus.com.brh", "1234");
        
        if(f == null)
            System.out.println("Nao achou");
        else
            System.out.println(f.getNome() + "Achou");
        
    }
    
}
