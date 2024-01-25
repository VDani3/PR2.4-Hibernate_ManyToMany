package com.project;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Persona", uniqueConstraints = {@UniqueConstraint(columnNames = "personaId")})
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personaId", unique = true, nullable = false)
    private int personaId;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nom")
    private String nom;

    @Column(name = "telefon")
    private String telefon;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Llibres_Persona",
        joinColumns = {@JoinColumn(referencedColumnName = "personaId")},
        inverseJoinColumns = {@JoinColumn(referencedColumnName = "llibreId")})
    private Set<Llibre> llibres;

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    public Persona(String d, String n, String t) {
        this.dni = d;
        this.nom = n;
        this.telefon = t;
    }

    public Persona(){}

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public String toString() {
        String resultat;
        resultat = String.format("%s: %s, %s, Llibres: ", personaId, dni, telefon);
        return resultat;
    }
    
}
