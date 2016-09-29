/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
import java.util.List;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
import javax.persistence.Column;
=======
>>>>>>> parent of 9baeb29... Mudanças do Front End:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
=======
>>>>>>> parent of eb286a5... Salvar erExclguir:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
=======
import javax.persistence.Table;
>>>>>>> parent of 9baeb29... Mudanças do Front End:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
=======
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
>>>>>>> parent of eb286a5... Salvar erExclguir:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java

/**
 *
 * @author awsilva
 */
@Entity
@Table(name="contratos")
public class Contrato {    
    @Id
    @GeneratedValue
    private int id;
    private int status;
    private String universidade;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
    
    @Column(length = 20, nullable = false)
    private String semestre;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
=======
    private int semestre;
>>>>>>> parent of 9baeb29... Mudanças do Front End:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
=======
    private String semestre;
>>>>>>> parent of eb286a5... Salvar erExclguir:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
    private Date data;
    private Date horario;
    private String senha;
    private int festas;
    private int fotos;
    private boolean toga;
    private boolean teaser;
    private double creditoFotografico;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
    
//    @ManyToMany
//    @JoinTable()
//    private List<Midia> midia;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
    
    @Column(nullable = false)
=======
    private Midia midia;
>>>>>>> parent of 9baeb29... Mudanças do Front End:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
=======
>>>>>>> parent of eb286a5... Salvar erExclguir:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
    private boolean fotosLiberadas;
    private double valorTotal;
    private double valorVista;
    private double valorFormando;
    private String observacoes;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getUniversidade() {
        return universidade;
    }
    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }
    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getFestas() {
        return festas;
    }

    public void setFestas(int festas) {
        this.festas = festas;
    }

    public int getFotos() {
        return fotos;
    }

    public void setFotos(int fotos) {
        this.fotos = fotos;
    }

    public boolean isToga() {
        return toga;
    }

    public void setToga(boolean toga) {
        this.toga = toga;
    }

    public boolean isTeaser() {
        return teaser;
    }

    public void setTeaser(boolean teaser) {
        this.teaser = teaser;
    }

    public double getCreditoFotografico() {
        return creditoFotografico;
    }

    public void setCreditoFotografico(double creditoFotografico) {
        this.creditoFotografico = creditoFotografico;
    }

    public String getMidia() {
        return midia;
    }

    public void setMidia(String midia) {
        this.midia = midia;
    }

    public boolean getFotosLiberadas() {
        return fotosLiberadas;
    }

    public void setFotosLiberadas(boolean fotosLiberadas) {
        this.fotosLiberadas = fotosLiberadas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorVista() {
        return valorVista;
    }

    public void setValorVista(double valorVista) {
        this.valorVista = valorVista;
    }

    public double getValorFormando() {
        return valorFormando;
    }

    public void setValorFormando(double valorFormando) {
        this.valorFormando = valorFormando;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
}
