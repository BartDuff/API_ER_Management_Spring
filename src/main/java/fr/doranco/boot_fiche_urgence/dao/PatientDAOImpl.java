/*package fr.doranco.boot_fiche_urgence.dao;

import fr.doranco.boot_fiche_urgence.model.CiviliteEnum;
import fr.doranco.boot_fiche_urgence.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDAOImpl implements PatientDAO {
    public static List<Patient> patients = new ArrayList<Patient>();

    @Override
    public Patient findById(int id) {
        for(Patient patient : patients){
            if(patient.getId() == id){
                return patient;
            }
        }
        return null;
    }

    @Override
    public List<Patient> findAll() {

        return patients;
    }

    @Override
    public Patient save(Patient patient) {
        patients.add(patient);
        return patient;
    }


}*/
