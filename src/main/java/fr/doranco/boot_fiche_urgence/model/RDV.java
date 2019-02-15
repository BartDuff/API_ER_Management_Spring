package fr.doranco.boot_fiche_urgence.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rdv")
public class RDV {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fiche_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Fiche fiche;
    @ManyToMany(mappedBy = "rdvs")
    private Set<PersonnelMedical> personnelMedicals = new HashSet<>();
    @Column(name = "prise_en_charge")
    private Date priseEnCharge;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<PersonnelMedical> getPersonnelMedicals() {
        return personnelMedicals;
    }

    public void setPersonnelMedicals(Set<PersonnelMedical> personnelMedicals) {
        this.personnelMedicals = personnelMedicals;
    }

    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }

    public Date getPriseEnCharge() {
        return priseEnCharge;
    }

    public void setPriseEnCharge(Date priseEnCharge) {
        this.priseEnCharge = priseEnCharge;
    }
}
