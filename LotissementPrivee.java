public class LotissementPrivee extends Lotissement {

    public LotissementPrivee(int capacite) {
        super(capacite);
    }

    @Override
    public boolean ajouter(Propriete p) {
        if (!(p instanceof ProprietePrivee)) {
            return false;
        }
        return super.ajouter(p);
    }

    @Override
    public ProprietePrivee getProprieteByIndex(int i) {
        Propriete p = super.getProprieteByIndex(i);
        if (p instanceof ProprietePrivee) {
            return (ProprietePrivee) p;
        }
        return null;
    }

    @Override
    public int getNbPieces() {
        int total = 0;
        for (int i = 0; i < nombre; i++) {
            Propriete p = tabProp[i];
            if (p instanceof ProprietePrivee) {
                total += ((ProprietePrivee) p).getNbPieces();
            }
        }
        return total;
    }
}
