package fr.doranco.boot_fiche_urgence.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Fiche {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Patient patient;
    private int niveauDouleur;
    private String symptomes;
    @Column(name = "arrivee")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateArrivee;
    @Column(name = "sortie")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateSortie;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDateArrivee() {
        return dateArrivee;
    }

    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public String getSymptomes() {
        return symptomes;
    }

    public void setSymptomes(String symptomes) {
        this.symptomes = symptomes;
    }

    public int getNiveauDouleur() {
        return niveauDouleur;
    }

    public void setNiveauDouleur(int niveauDouleur) {
        this.niveauDouleur = niveauDouleur;
    }
}
