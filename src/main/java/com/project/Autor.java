package com.project;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Autor", uniqueConstraints = {@UniqueConstraint(columnNames = "autorId")})
public class Autor {
    
    @Id
    @Column(name = "autorId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autorId;

    @Column(name = "nom")
    private String nom;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Llibres_Autor",
        joinColumns = {@JoinColumn(referencedColumnName = "autorId")},
        inverseJoinColumns = {@JoinColumn(referencedColumnName = "llibreId")})
    private Set<Llibre> llibres;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAutorId() {
        return autorId;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    
}
