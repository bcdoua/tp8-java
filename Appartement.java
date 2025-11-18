public class Appartement extends ProprietePrivee {
    private int numEtage;

    public Appartement(int id, Personne responsable, String adresse, double surface, 
                       int nbPieces, int numEtage) {
        super(id, responsable, adresse, surface, nbPieces);  
        this.numEtage = numEtage;
    }

    @Override
    public String toString() {
        return super.toString() + ", Numéro d'étage: " + numEtage;
    }

    @Override
    public double calculImpot() {
        return super.calculImpot();
    }
}
