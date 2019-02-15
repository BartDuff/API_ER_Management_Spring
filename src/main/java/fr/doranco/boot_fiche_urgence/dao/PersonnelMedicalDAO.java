package fr.doranco.boot_fiche_urgence.dao;

import fr.doranco.boot_fiche_urgence.model.PersonnelMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelMedicalDAO extends JpaRepository<PersonnelMedical, Long> {
/*    public PersonnelMedical findById(final int id);
    public List<PersonnelMedical> findAll();
    public PersonnelMedical save(final PersonnelMedical personnelMedical);*/
}
