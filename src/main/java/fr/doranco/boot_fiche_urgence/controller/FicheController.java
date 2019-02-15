package fr.doranco.boot_fiche_urgence.controller;

import fr.doranco.boot_fiche_urgence.dao.FicheDao;
import fr.doranco.boot_fiche_urgence.dao.PatientDAO;
import fr.doranco.boot_fiche_urgence.model.Fiche;
import fr.doranco.boot_fiche_urgence.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FicheController {
    @Autowired
    FicheDao ficheDao;

    @Autowired
    PatientDAO patientDAO;

    @RequestMapping(value="/fiches", method = RequestMethod.GET)
    public ResponseEntity<List<Fiche>> listeFiches() {
        if(ficheDao.findAll().isEmpty()){
            return new ResponseEntity<>(ficheDao.findAll(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ficheDao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/fiches/{id}", method = RequestMethod.GET)
    public ResponseEntity<Fiche> recupererFiche(@PathVariable long id){
        Fiche fiche = ficheDao.getOne(id);
        if(fiche.getId() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(fiche, HttpStatus.FOUND);
    }

    @RequestMapping(value="/fiches", method = RequestMethod.POST)
    public ResponseEntity<Fiche> ajouterFiche(@ModelAttribute("fiche") Fiche fiche){
        if(fiche == null || fiche.getPatient() == null || fiche.getPatient().getId() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        Patient patient = patientDAO.getOne(fiche.getPatient().getId());
        fiche.setPatient(patient);
        return new ResponseEntity<>(ficheDao.save(fiche), HttpStatus.CREATED);
    }

}
