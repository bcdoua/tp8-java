public class Lotissement implements GestionPropriete {
    protected Propriete[] tabProp;
    protected int nombre;      
    protected int capacite;    

    public Lotissement(int capacite) {
        this.capacite = capacite;
        this.tabProp = new Propriete[capacite];
        this.nombre = 0;
    }

    public Propriete getProprieteByIndex(int i) {
        if (i >= 0 && i < nombre) {
            return tabProp[i];
        }
        return null;
    }

    public int getNbPieces() {
        int total = 0;
        for (int i = 0; i < nombre; i++) {
            if (tabProp[i] instanceof ProprietePrivee) {
                total += ((ProprietePrivee) tabProp[i]).getNbPieces();
            }
        }
        return total;
    }

    @Override
    public void afficherProprietes() {
        for (int i = 0; i < nombre; i++) {
            System.out.println(tabProp[i].toString() + ", Impôts: " + tabProp[i].calculImpot());
        }
    }

    @Override
    public boolean ajouter(Propriete p) {
        if (nombre >= capacite) {
            return false; 
        }
        for (int i = 0; i < nombre; i++) {
            if (tabProp[i].getId() == p.getId()) {
                return false; 
            }
        }
        tabProp[nombre] = p;
        nombre++;
        return true;
    }

    @Override
    public boolean supprimer(Propriete p) {
        for (int i = 0; i < nombre; i++) {
            if (tabProp[i].getId() == p.getId()) {
                for (int j = i; j < nombre - 1; j++) {
                    tabProp[j] = tabProp[j + 1];
                }
                tabProp[nombre - 1] = null;
                nombre--;
                return true;
            }
        }
        return false; 
    }
}
