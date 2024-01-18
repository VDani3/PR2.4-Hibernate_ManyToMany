package com.project;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Contact", uniqueConstraints = {@UniqueConstraint(columnNames = "bibliotecaId")})
public class Biblioteca {
    
    @Id
    @Column(name = "bibliotecaId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bibliotecaId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "ciutat")
    private String ciutat;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Llibres_Biblioteca",
        joinColumns = {@JoinColumn(referencedColumnName = "bibliotecaId")}, 
        inverseJoinColumns = {@JoinColumn(referencedColumnName = "llibreId")})
    private Set<Llibre> llibres;

    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public String getNom() {
        return nom;
    }

    public String getCiutat() {
        return ciutat;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    





}
