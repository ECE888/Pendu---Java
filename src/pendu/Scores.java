package pendu;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Scores {

    private static final String FICHIER = "scores.txt";
    private static final int LIMITE = 10;

    public static void enregistrer(String nom, int score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHIER, true))) {
            bw.write(nom + ";" + score);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Impossible de sauvegarder le score.");
        }
    }

    public static void afficherTop10() {
        List<String[]> scores = lire();
        if (scores.isEmpty()) return;

        Collections.sort(scores, (a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));

        System.out.println("--- Top " + LIMITE + " ---");
        int limite = Math.min(LIMITE, scores.size());
        for (int i = 0; i < limite; i++) {
            System.out.println((i + 1) + ". " + scores.get(i)[0] + " - " + scores.get(i)[1] + " pts");
        }
        System.out.println();
    }

    private static List<String[]> lire() {
        List<String[]> scores = new ArrayList<>();
        File f = new File(FICHIER);
        if (!f.exists()) return scores;

        try (BufferedReader br = new BufferedReader(new FileReader(FICHIER))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                String[] parts = ligne.split(";");
                if (parts.length == 2) {
                    try {
                        Integer.parseInt(parts[1].trim());
                        scores.add(new String[]{parts[0].trim(), parts[1].trim()});
                    } catch (NumberFormatException e) {
                        // ligne invalide, on passe
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Impossible de lire les scores.");
        }

        return scores;
    }
}
