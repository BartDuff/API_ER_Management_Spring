package fr.doranco.boot_fiche_urgence.model;

public interface Personne {
    public CiviliteEnum getCiviliteEnum();
    public String getNom();
    public String getPrenom();
    public int getAge();

    public void setCiviliteEnum(CiviliteEnum civiliteEnum);
    public void setNom(String nom);
    public void setPrenom(String prenom);
    public void setAge(int age);
}
