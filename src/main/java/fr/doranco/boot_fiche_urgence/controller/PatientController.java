package fr.doranco.boot_fiche_urgence.controller;

import fr.doranco.boot_fiche_urgence.dao.FicheDao;
import fr.doranco.boot_fiche_urgence.dao.PatientDAO;
import fr.doranco.boot_fiche_urgence.model.CiviliteEnum;
import fr.doranco.boot_fiche_urgence.model.Fiche;
import fr.doranco.boot_fiche_urgence.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private FicheDao ficheDao;

    @RequestMapping(value="/patients", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> listePatients() {
        if(patientDAO.findAll().isEmpty()){
            return new ResponseEntity<>(patientDAO.findAll(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patientDAO.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/patients/{id}", method = RequestMethod.GET)
    public ResponseEntity<Patient> recupererPatient(@PathVariable long id){
        Patient patient = patientDAO.getOne(id);
        if(patient.getId() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(patient, HttpStatus.FOUND);
    }

    @RequestMapping(value="/patients", method = RequestMethod.POST)
    public ResponseEntity<Patient> ajouterPatient(@ModelAttribute("patient") Patient patient){
        if(patient == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(patientDAO.save(patient), HttpStatus.CREATED);
    }

    @RequestMapping(value="/patients", method = RequestMethod.PUT)
    public ResponseEntity<Patient> modifierPatient(@ModelAttribute("patient") Patient patient){
        if(patient.getId() == 0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(patientDAO.save(patient), HttpStatus.OK);
    }

    @GetMapping(value="/patients/{id}/fiches")
    public Page<Fiche> recupererFichesPatient(@PathVariable("id") long id, Pageable pageable) {
        return ficheDao.findByPatientId(id, pageable);
    }

    @InitBinder
    public void allowEmptyDateBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat,true));
    }

    @PostMapping(value="/patients/{id}/fiches")
    public Fiche ajouterFichePatient(@PathVariable("id") long id, @Valid @RequestBody Fiche fiche) {
        return patientDAO.findById(id).map( patient -> {
            fiche.setPatient(patient);
            return ficheDao.save(fiche);
        }).orElseThrow(() -> new EntityNotFoundException("patient not found"));
    }
}
