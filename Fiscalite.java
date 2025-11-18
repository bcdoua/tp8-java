public class Fiscalite {
    public static void main(String[] args) {
        Personne p1 = new Personne(123456, "Ben Charef", "Douaa");
        Personne p2 = new Personne(234567, "Trabelsi", "Sami");
        Personne p3 = new Personne(345678, "Haddad", "Lina");
        Lotissement lot = new Lotissement(10);
        lot.ajouter(new ProprietePrivee(1, p1, "Corniche", 350, 4));
        lot.ajouter(new Villa(2, p2, "Dar Chaabane", 400, 6, true));
        lot.ajouter(new Appartement(3, p2, "Hammamet", 1200, 8, 3));
        lot.ajouter(new ProprieteProfessionnelle(4, p3, "Korba", 1000, 50, true));
        lot.ajouter(new ProprieteProfessionnelle(5, p1, "Bir Bouragba", 2500, 400, false));
        System.out.println("=== Toutes les propriétés ===");
        lot.afficherProprietes();
        int totalPieces = lot.getNbPieces();
        System.out.println("\nNombre total de pièces dans les propriétés privées : " + totalPieces);
        ProprietePrivee minImpotProp = null;
        double minImpot = Double.MAX_VALUE;

        for (int i = 0; i < lot.nombre; i++) {
            if (lot.getProprieteByIndex(i) instanceof ProprietePrivee) {
                ProprietePrivee p = (ProprietePrivee) lot.getProprieteByIndex(i);
                double impot = p.calculImpot();
                if (impot < minImpot) {
                    minImpot = impot;
                    minImpotProp = p;
                }
            }
        }

        if (minImpotProp != null) {
            System.out.println("\nPropriété privée qui paye le moins d'impôts :");
            System.out.println(minImpotProp.toString());
            System.out.println("Impôts à payer : " + minImpot);
        }
        for (int i = 0; i < lot.nombre; i++) {
            Propriete p = lot.getProprieteByIndex(i);
            if (p instanceof Appartement && p.getAdresse().equals("Hammamet")) {
                lot.supprimer(p);
                break;
            }
        }
        System.out.println("\n=== Propriétés après suppression de l'appartement Hammamet ===");
        lot.afficherProprietes();
    }
}
