/*
package fr.doranco.boot_fiche_urgence.dao;

import fr.doranco.boot_fiche_urgence.model.CiviliteEnum;
import fr.doranco.boot_fiche_urgence.model.FonctionEnum;
import fr.doranco.boot_fiche_urgence.model.PersonnelMedical;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonnelMedicalDAOImpl implements PersonnelMedicalDAO {
    public static List<PersonnelMedical> personnels = new ArrayList<PersonnelMedical>();
    static {
        personnels.add(new PersonnelMedical(1,CiviliteEnum.MR, "HOUSE","Gregory",45, FonctionEnum.MEDECIN));
        personnels.add(new PersonnelMedical(2,CiviliteEnum.MME, "GREY","Meredith",40, FonctionEnum.INTERNE));
        personnels.add(new PersonnelMedical(3,CiviliteEnum.MME, "NURSE","Jackie",35, FonctionEnum.INFIRMIER));
    }

    @Override
    public PersonnelMedical findById(int id) {
        for(PersonnelMedical personnelMedical : personnels){
            if(personnelMedical.getId() == id){
                return personnelMedical;
            }
        }
        return null;
    }

    @Override
    public List<PersonnelMedical> findAll() {
        return personnels;
    }

    @Override
    public PersonnelMedical save(PersonnelMedical personnelMedical) {
        personnels.add(personnelMedical);
        return personnelMedical;
    }
}
*/
