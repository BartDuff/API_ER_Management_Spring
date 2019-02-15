package fr.doranco.boot_fiche_urgence.controller;

import fr.doranco.boot_fiche_urgence.dao.PersonnelMedicalDAO;
import fr.doranco.boot_fiche_urgence.model.PersonnelMedical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnelMedicalController {
    @Autowired
    private PersonnelMedicalDAO personnelMedicalDAO;

    @RequestMapping(value="/personnels", method = RequestMethod.GET)
    public List<PersonnelMedical> listePersonnels() {
        return personnelMedicalDAO.findAll();
    }

    @RequestMapping(value="/personnels/{id}", method = RequestMethod.GET)
    public PersonnelMedical recupererPersonnel(@PathVariable long id){
       return personnelMedicalDAO.getOne(id);
    }

    @RequestMapping(value="/personnels", method = RequestMethod.POST)
    public PersonnelMedical ajouterPersonnel(@ModelAttribute("personnel") PersonnelMedical personnelMedical){
        personnelMedicalDAO.save(personnelMedical);
        return personnelMedical;
    }

    @RequestMapping(value="/personnels", method = RequestMethod.PUT)
    public PersonnelMedical modifierPersonnel(@ModelAttribute("personnel") PersonnelMedical personnelMedical){
        personnelMedicalDAO.save(personnelMedical);
        return personnelMedical;
    }
}
