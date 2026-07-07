package pendu;

import java.util.ArrayList;
import java.util.List;

public class Partie {

    private char[] mot;
    private char[] motCache;
    private List<Character> lettresEssayees;
    private int nbErreurs;
    private int maxErreurs;

    public Partie(String mot, int maxErreurs) {
        String motNormalise = Util.supprimerAccents(mot).toUpperCase();
        this.mot = motNormalise.toCharArray();
        this.motCache = new char[motNormalise.length()];
        this.lettresEssayees = new ArrayList<>();
        this.nbErreurs = 0;
        this.maxErreurs = maxErreurs;

        for (int i = 0; i < motCache.length; i++) {
            motCache[i] = '_';
        }
    }

    public boolean proposerLettre(char lettre) {
        lettresEssayees.add(lettre);
        boolean trouvee = false;

        for (int i = 0; i < mot.length; i++) {
            if (mot[i] == lettre) {
                motCache[i] = lettre;
                trouvee = true;
            }
        }

        if (!trouvee) {
            nbErreurs++;
        }

        return trouvee;
    }

    public boolean aDejaEssaye(char lettre) {
        return lettresEssayees.contains(lettre);
    }

    public boolean estGagne() {
        for (char c : motCache) {
            if (c == '_') return false;
        }
        return true;
    }

    public boolean estTerminee() {
        return estGagne() || nbErreurs >= maxErreurs;
    }

    public String getMotCache() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < motCache.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(motCache[i]);
        }
        return sb.toString();
    }

    public String getLettresEssayees() {
        if (lettresEssayees.isEmpty()) return "aucune";
        StringBuilder sb = new StringBuilder();
        for (char c : lettresEssayees) {
            if (sb.length() > 0) sb.append(", ");
            sb.append(c);
        }
        return sb.toString();
    }

    public int getNbErreurs() {
        return nbErreurs;
    }
}
