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
    private int id_autor;

    @ManyToMany(mappedBy = "llibres")
    private Set<Biblioteca> biblioteques;

    @ManyToMany(mappedBy = "llibres")
    private Set<Persona> persones;

    public int getLlibreid() {
        return llibreid;
    }

    public String getNom() {
        return nom;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getId_autor() {
        return id_autor;
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

    
}
