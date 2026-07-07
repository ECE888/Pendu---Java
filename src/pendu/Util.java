package pendu;

import java.text.Normalizer;

public class Util {

    public static String supprimerAccents(String texte) {
        String decompose = Normalizer.normalize(texte, Normalizer.Form.NFD);
        return decompose.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
