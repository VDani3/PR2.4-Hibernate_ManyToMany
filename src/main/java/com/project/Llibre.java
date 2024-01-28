package com.project;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Llibre",
    uniqueConstraints = {@UniqueConstraint(columnNames = "llibreId")})
public class Llibre {
    
    @Id
    @Column(name = "llibreId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int llibreid;

    @Column(name = "nom")
    private String nom;

    @Column(name = "editorial")
    private String editorial;

    @ManyToOne
    @JoinColumn(name = "autorId", insertable = false, updatable = false)
    private Autor autor;

    @ManyToMany(mappedBy = "llibres")
    private Set<Biblioteca> biblioteques;

    @ManyToMany(mappedBy = "llibres")
    private Set<Persona> persones;

    public Llibre(String nom, String editorial) {
        this.nom = nom;
        this.editorial = editorial;
    }

    public Llibre(){}

    public int getLlibreid() {
        return llibreid;
    }

    public String getNom() {
        return nom;
    }

    public String getEditorial() {
        return editorial;
    }


    public Set<Biblioteca> getBiblioteques() {
        return biblioteques;
    }

    public Set<Persona> getPersones() {
        return persones;
    }

    public void setLlibreid(int llibreid) {
        this.llibreid = llibreid;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        String resultat;
        resultat = String.format("%s: %s, %s", llibreid, nom, editorial);
        return resultat;
    }
}
