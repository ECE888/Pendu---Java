package pendu;

import java.util.Scanner;

public class Jeu {

    private static final int MAX_ERREURS = 8;

    private Scanner scanner;

    public Jeu() {
        this.scanner = new Scanner(System.in);
    }

    public void lancer() {
        System.out.println("=== LE PENDU ===");
        System.out.println();

        boolean rejouer = true;
        while (rejouer) {
            jouerUnePartie();
            rejouer = demanderRejouer();
        }

        System.out.println("Au revoir !");
        scanner.close();
    }

    private void jouerUnePartie() {
        System.out.print("Entrez votre prenom : ");
        String nom = scanner.nextLine().trim();

        String mot = Dictionnaire.getMotAleatoire();
        Partie partie = new Partie(mot, MAX_ERREURS);

        System.out.println("Le mot a deviner contient " + mot.length() + " lettre(s).");
        System.out.println();

        while (!partie.estTerminee()) {
            Pendu.afficher(partie.getNbErreurs());
            System.out.println("Mot    : " + partie.getMotCache());
            System.out.println("Lettres essayees : " + partie.getLettresEssayees());

            char lettre = demanderLettre(partie);

            if (partie.proposerLettre(lettre)) {
                System.out.println("Bonne lettre !");
            } else {
                System.out.println("Mauvaise lettre. (" + partie.getNbErreurs() + "/" + MAX_ERREURS + ")");
            }
            System.out.println();
        }

        Pendu.afficher(partie.getNbErreurs());
        System.out.println("Mot    : " + partie.getMotCache());

        if (partie.estGagne()) {
            System.out.println("Bravo " + nom + " ! Vous avez trouve le mot en " + partie.getNbErreurs() + " erreur(s).");
            int score = mot.length() * 10 - partie.getNbErreurs() * 5;
            Scores.enregistrer(nom, score);
        } else {
            System.out.println("Perdu " + nom + "... Le mot etait : " + mot.toUpperCase());
        }

        System.out.println();
        Scores.afficherTop10();
    }

    private char demanderLettre(Partie partie) {
        while (true) {
            System.out.print("Proposez une lettre : ");
            String saisie = scanner.nextLine().trim().toUpperCase();

            if (saisie.length() != 1 || !Character.isLetter(saisie.charAt(0))) {
                System.out.println("Entrez une seule lettre.");
                continue;
            }

            char lettre = saisie.charAt(0);

            if (partie.aDejaEssaye(lettre)) {
                System.out.println("Vous avez deja essaye cette lettre.");
                continue;
            }

            return lettre;
        }
    }

    private boolean demanderRejouer() {
        System.out.print("Voulez-vous rejouer ? (o/n) : ");
        String rep = scanner.nextLine().trim().toLowerCase();
        return rep.equals("o") || rep.equals("oui");
    }
}
