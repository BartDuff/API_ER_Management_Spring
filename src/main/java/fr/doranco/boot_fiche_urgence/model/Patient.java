package fr.doranco.boot_fiche_urgence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient implements Personne {

    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "civilite_enum")
    private CiviliteEnum civiliteEnum;
    private String nom;
    private String prenom;
    private int age;
    @Transient private List<Fiche> fiches;

    public Patient() {
        super();
    }

    public Patient(long id, CiviliteEnum civiliteEnum, String nom, String prenom, int age) {
        this.id = id;
        this.civiliteEnum = civiliteEnum;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CiviliteEnum getCiviliteEnum() {
        return civiliteEnum;
    }

    public void setCiviliteEnum(CiviliteEnum civiliteEnum) {
        this.civiliteEnum = civiliteEnum;
    }

    /*public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    } */

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
