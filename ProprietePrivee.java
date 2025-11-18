public class ProprietePrivee extends Propriete {
    private int nbPieces;

    public ProprietePrivee(int id, Personne responsable, String adresse, double surface, int nbPieces) {
        super(id, responsable, adresse, surface);
        this.nbPieces = nbPieces;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nombre de pièces: " + nbPieces;
    }

    @Override
    public double calculImpot() {
        return (surface / 100) * 50 + nbPieces * 10;
    }
}
