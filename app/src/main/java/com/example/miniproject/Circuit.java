package com.example.miniproject;


public class Circuit {

    private  int IdCircuit ;
    private  String VilleDepart ;
    private  String VilleArrivee ;
    private float Prix;
    private int Duree;

    public Circuit(int idCircuit, String villeDepart, String villeArrivee, float prix, int duree) {
        IdCircuit = idCircuit;
        VilleDepart = villeDepart;
        VilleArrivee = villeArrivee;
        Prix = prix;
        Duree = duree;
    }

    public int getIdCircuit() { return IdCircuit; }

    public String getVilleDepart() { return VilleDepart; }

    public String getVilleArrivee() { return VilleArrivee; }

    public float getPrix() { return Prix; }

    public int getDuree() { return Duree; }

    public void setIdCircuit(int idCircuit) { IdCircuit = idCircuit; }

    public void setVilleDepart(String villeDepart) { VilleDepart = villeDepart; }

    public void setVilleArrivee(String villeArrivee) { VilleArrivee = villeArrivee; }

    public void setPrix(float prix) { Prix = prix; }

    public void setDuree(int duree) { Duree = duree; }

    @Override
    public String toString() {
        return "Circuit { " +
                "IdCircuit = " + IdCircuit +
                ", VilleDepart = '" + VilleDepart + '\'' +
                ", VilleArrivee = '" + VilleArrivee + '\'' +
                ", Prix = " + Prix +
                ", Duree = " + Duree +
                '}';
    }

}
