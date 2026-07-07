package pendu;

public class Pendu {

    private static final String[] DESSIN = {

        // 0 erreur
        "        \n" +
        "        \n" +
        "        \n" +
        "        \n" +
        "        \n" +
        "  ___   \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n",

        // 1 erreur
        "  ____  \n" +
        "  |     \n" +
        "  |     \n" +
        "  |     \n" +
        "  |     \n" +
        "  |___  \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n",

        // 2 erreurs
        "  ____  \n" +
        "  |  |  \n" +
        "  |     \n" +
        "  |     \n" +
        "  |     \n" +
        "  |___  \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n",

        // 3 erreurs
        "  ____  \n" +
        "  |  |  \n" +
        "  |  o  \n" +
        "  |     \n" +
        "  |     \n" +
        "  |___  \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n",

        // 4 erreurs
        "  ____  \n" +
        "  |  |  \n" +
        "  |  o  \n" +
        "  |  |  \n" +
        "  |     \n" +
        "  |___  \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n",

        // 5 erreurs
        "  ____  \n" +
        "  |  |  \n" +
        "  |  o  \n" +
        "  | /|  \n" +
        "  |     \n" +
        "  |___  \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n",

        // 6 erreurs
        "  ____  \n" +
        "  |  |  \n" +
        "  |  o  \n" +
        "  | /|\\ \n" +
        "  |     \n" +
        "  |___  \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n",

        // 7 erreurs
        "  ____  \n" +
        "  |  |  \n" +
        "  |  o  \n" +
        "  | /|\\ \n" +
        "  | /   \n" +
        "  |___  \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n",

        // 8 erreurs
        "  ____  \n" +
        "  |  |  \n" +
        "  |  o  \n" +
        "  | /|\\ \n" +
        "  | / \\ \n" +
        "  |___  \n" +
        " |   |__\n" +
        " |      \n" +
        " |______\n"
    };

    public static void afficher(int nbErreurs) {
        int index = Math.min(nbErreurs, DESSIN.length - 1);
        System.out.println(DESSIN[index]);
    }
}
