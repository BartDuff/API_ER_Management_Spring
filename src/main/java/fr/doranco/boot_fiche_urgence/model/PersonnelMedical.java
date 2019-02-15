package fr.doranco.boot_fiche_urgence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personnel_medical")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PersonnelMedical implements Personne {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "civilite_enum")
    private CiviliteEnum civiliteEnum;
    private String nom;
    private String prenom;
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "fonction_enum")
    private FonctionEnum fonctionEnum;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "rdv_personnel",
            joinColumns = { @JoinColumn(name = "personnel_medical_id") },
            inverseJoinColumns = { @JoinColumn(name = "rdv_id") }
    )
    Set<RDV> rdvs = new HashSet<>();

    public PersonnelMedical() {
        super();
    }

    public PersonnelMedical(long id, CiviliteEnum civiliteEnum, String nom, String prenom, int age, FonctionEnum fonctionEnum) {
        this.id = id;
        this.civiliteEnum = civiliteEnum;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.fonctionEnum = fonctionEnum;
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

    public FonctionEnum getFonctionEnum() {
        return fonctionEnum;
    }

    public void setFonctionEnum(FonctionEnum fonctionEnum) {
        this.fonctionEnum = fonctionEnum;
    }

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
