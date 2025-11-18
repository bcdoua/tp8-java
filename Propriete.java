abstract class Propriete {
    protected int id;
    protected Personne responsable;
    protected String adresse;
    protected double surface;
    public Propriete(int id, Personne responsable, String adresse, double surface) {
        this.id = id;
        this.responsable = responsable;
        this.adresse = adresse;
        this.surface = surface;
    }
    public String toString() {
        return "Id: " + id +
               ", Responsable: " + responsable +
               ", Adresse: " + adresse +
               ", Surface: " + surface + " m2";
    }
    public abstract double calculImpot();
}
