package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionarios")
public class Funcionario {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String setor;
    private String cargo;
    private int rg;
    private String cpf;
    private String bornDate;
    private String banco;
    private String agencia;
    private String tipoConta;
    private String numConta;
    private String telefone;
    private String email;
}