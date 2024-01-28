package com.project;

import java.util.List;
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

    @OneToMany
    @JoinColumn(name = "autorId")
    private Set<Llibre> llibres;

    public Autor(String n){
        this.nom = n;
    }

    public Autor(){}

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

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    public String queryLlibres() {
        long id = this.getAutorId();
        String queryString = "SELECT DISTINCT l.* FROM Llibre l " +
                            "" +
                            "WHERE l.autorId = " + id;
    
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
        resultat = String.format("%s: %s, Items: %s", autorId, nom, queryLlibres());
        return resultat;
    }
}
