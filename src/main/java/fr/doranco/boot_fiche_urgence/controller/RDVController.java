package fr.doranco.boot_fiche_urgence.controller;

import fr.doranco.boot_fiche_urgence.dao.FicheDao;
import fr.doranco.boot_fiche_urgence.dao.PatientDAO;
import fr.doranco.boot_fiche_urgence.dao.RDVDAO;
import fr.doranco.boot_fiche_urgence.model.Fiche;
import fr.doranco.boot_fiche_urgence.model.Patient;
import fr.doranco.boot_fiche_urgence.model.RDV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RDVController {
    @Autowired
    private RDVDAO rdvdao;

    @RequestMapping(value="/rdvs", method = RequestMethod.GET)
    public ResponseEntity<List<RDV>> listeRdvs() {
        if(rdvdao.findAll().isEmpty()){
            return new ResponseEntity<>(rdvdao.findAll(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rdvdao.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value="/rdvs/{id}", method = RequestMethod.GET)
    public ResponseEntity<RDV> recupererRdv(@PathVariable long id){
        RDV rdv = rdvdao.getOne(id);
        if(rdv.getId() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rdv, HttpStatus.FOUND);
    }

    @RequestMapping(value="/rdvs", method = RequestMethod.POST)
    public ResponseEntity<RDV> ajouterPatient(@ModelAttribute("rdv") RDV rdv){
        if(rdv == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(rdvdao.save(rdv), HttpStatus.CREATED);
    }

    @RequestMapping(value="/rdvs", method = RequestMethod.PUT)
    public ResponseEntity<RDV> modifierPatient(@ModelAttribute("rdv") RDV rdv){
        if(rdv.getId() == 0){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(rdvdao.save(rdv), HttpStatus.OK);
    }


/*    @GetMapping(value="/patients/{id}/fiches")
    public List<Fiche> recupererFichesPatient(@PathVariable("id") long id) {
        return ficheDao.findByPatientId(id);
    }*/
}
