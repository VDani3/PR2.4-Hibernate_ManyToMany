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

    public Biblioteca(String n, String c) {
        this.nom = n;
        this.ciutat = c;
    }

    public Biblioteca(){}

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

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    public String queryLlibres() {
        long id = this.getBibliotecaId();
        String queryString = "SELECT DISTINCT l.* FROM Llibre l " +
                            "JOIN Llibres_Biblioteca lb ON l.llibreId = lb.llibres_llibreId " +
                            "WHERE lb.biblioteques_bibliotecaId = " + id;
    
        List<Object[]> results = Manager.queryTable(queryString);
    
        StringBuilder resultString = new StringBuilder();
        
        resultString.append("[");
        for (Object[] row : results) {
            for (Object column : row) {
                resultString.append(column).append(", ");
            }
           resultString.append("| ");
        }
        resultString.append("]");
    
        return resultString.toString();
    }

    public String toString() {
        String resultat;
        resultat = String.format("%s: %s, %s, Llibres: %s", bibliotecaId, nom, ciutat, queryLlibres());
        return resultat;
    }


}
