/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.math.BigDecimal;
import java.util.Date;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
import java.util.List;
import javax.persistence.Column;
=======
>>>>>>> parent of 9baeb29... Mudanças do Front End:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
=======
import javax.persistence.Table;
>>>>>>> parent of 9baeb29... Mudanças do Front End:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java

/**
 *
 * @author awsilva
 */
@Entity
public class Contrato {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private int status;
    
    @Column(length = 50, nullable = false)
    private String universidade;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
    
    @Column(length = 20, nullable = false)
    private String semestre;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
=======
    private int semestre;
>>>>>>> parent of 9baeb29... Mudanças do Front End:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
    private Date data;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horario;
    
    @Column(length = 32, nullable = false)
    private String senha;
    
    @Column(nullable = false)
    private int festas;
    
    @Column(nullable = false)
    private int fotos;    
    
    @Column(nullable = false)
    private boolean toga;
    
    @Column(nullable = false)
    private boolean teaser;
    
    @Column(nullable = false)
    private double creditoFotografico;
<<<<<<< HEAD:Implementacao/SistemaDifoccus/src/main/java/br/com/difoccus/sistemadifoccus/modelo/Contrato.java
    
//    @ManyToMany
//    @JoinTable()
//    private List<Midia> midia;
    
    @Column(nullable = false)
=======
    private Midia midia;
>>>>>>> parent of 9baeb29... Mudanças do Front End:Implementacao/SistemaDifoccus/src/main/java/modelo/Contrato.java
    private boolean fotosLiberadas;
    
    @Column(nullable = false, precision = 8, scale = 2)
    private int valorTotal;
    
    @Column(nullable = false, precision = 8, scale = 2)
    private int valorVista;
    
    @Column(nullable = false, precision = 7, scale = 2)
    private int valorFormando;
    
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

//    public String getMidia() {
//        return midia;
//    }
//
//    public void setMidia(String midia) {
//        this.midia = midia;
//    }

    public boolean getFotosLiberadas() {
        return fotosLiberadas;
    }

    public void setFotosLiberadas(boolean fotosLiberadas) {
        this.fotosLiberadas = fotosLiberadas;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getValorVista() {
        return valorVista;
    }

    public void setValorVista(int valorVista) {
        this.valorVista = valorVista;
    }

    public int getValorFormando() {
        return valorFormando;
    }

    public void setValorFormando(int valorFormando) {
        this.valorFormando = valorFormando;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
}
