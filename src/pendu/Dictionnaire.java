package pendu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dictionnaire {

    private static final String MOT_SECOURS = "pendu";

    private static List<String> mots = null;
    private static Random random = new Random();

    private static void charger() {
        mots = new ArrayList<>();

        // Tentative 1 : words.txt embarque dans le classpath (src/resources/)
        InputStream is = Dictionnaire.class.getClassLoader().getResourceAsStream("words.txt");
        if (is != null) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
                String ligne;
                while ((ligne = br.readLine()) != null) {
                    ligne = ligne.trim();
                    if (!ligne.isEmpty()) {
                        mots.add(ligne.toLowerCase());
                    }
                }
                return;
            } catch (IOException e) {
                mots.clear();
            }
        }

        // Tentative 2 : words.txt dans le dossier courant ou les parents
        String[] emplacements = {
            "words.txt",
            "../words.txt",
            "../../words.txt"
        };

        for (String chemin : emplacements) {
            File f = new File(chemin);
            if (f.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    String ligne;
                    while ((ligne = br.readLine()) != null) {
                        ligne = ligne.trim();
                        if (!ligne.isEmpty()) {
                            mots.add(ligne.toLowerCase());
                        }
                    }
                    if (!mots.isEmpty()) return;
                } catch (IOException e) {
                    mots.clear();
                }
            }
        }

        // Aucun fichier trouve
        System.out.println("words.txt introuvable, mot de secours utilise.");
        mots.add(MOT_SECOURS);
    }

    public static String getMotAleatoire() {
        if (mots == null) {
            charger();
        }
        return mots.get(random.nextInt(mots.size()));
    }
}
