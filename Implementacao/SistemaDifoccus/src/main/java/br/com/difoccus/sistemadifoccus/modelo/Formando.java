package br.com.difoccus.sistemadifoccus.modelo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Formando {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(length = 50, nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private String estadoCivil;
    
    @Column(length = 14, nullable = false, unique = true)
    private String cpf;
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String endereco;
    
    @Column(nullable = false)
    private String bairro;
    
    @Column(nullable = false)
    private String cidade;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Contrato contrato;
    
    @Column(nullable = false)
    private boolean comissao;
    
    @Column(nullable = false)
    private double valorAPagar;
    
    @Column(nullable = false)
    private double valorPago;
    
    @Column(nullable = false)
    private double valorEmAberto;
    
    @Column(nullable = false)
    private boolean retiradaMidia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public boolean isComissao() {
        return comissao;
    }

    public void setComissao(boolean comissao) {
        this.comissao = comissao;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorEmAberto() {
        return valorEmAberto;
    }

    public void setValorEmAberto(double valorEmAberto) {
        this.valorEmAberto = valorEmAberto;
    }

    public boolean isRetiradaMidia() {
        return retiradaMidia;
    }

    public void setRetiradaMidia(boolean retiradaMidia) {
        this.retiradaMidia = retiradaMidia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}