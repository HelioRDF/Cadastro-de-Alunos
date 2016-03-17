/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author helio
 */
@Entity
@Table(name = "ALUNO", catalog = "teste", schema = "")
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByCod", query = "SELECT a FROM Aluno a WHERE a.cod = :cod"),
    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
    @NamedQuery(name = "Aluno.findBySobrenome", query = "SELECT a FROM Aluno a WHERE a.sobrenome = :sobrenome"),
    @NamedQuery(name = "Aluno.findByCodcidade", query = "SELECT a FROM Aluno a WHERE a.codcidade = :codcidade")})
public class Aluno implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD")
    private Integer cod;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "SOBRENOME")
    private String sobrenome;
    @Column(name = "CODCIDADE")
    private Integer codcidade;

    public Aluno() {
    }

    public Aluno(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        Integer oldCod = this.cod;
        this.cod = cod;
        changeSupport.firePropertyChange("cod", oldCod, cod);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        String oldSobrenome = this.sobrenome;
        this.sobrenome = sobrenome;
        changeSupport.firePropertyChange("sobrenome", oldSobrenome, sobrenome);
    }

    public Integer getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Integer codcidade) {
        Integer oldCodcidade = this.codcidade;
        this.codcidade = codcidade;
        changeSupport.firePropertyChange("codcidade", oldCodcidade, codcidade);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gui.Aluno[ cod=" + cod + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
