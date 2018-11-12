package Ask3;


import java.util.Random;

public class WordList {
    Random randomWord = new Random(); // Δημιουργια τυχαιου αριθμου

    /**
     * 3 Διαφορετικοι πινακες αναλογα με τη λεξεις θελει να πεξει ο χρηστης
     */

    private String[] historicalPhraseArray = {"Μολων λαβε", "Γενηθητω Φως", "Ευρηκα Ευρηκα"};
    private String[] proverbs = {"Κοντα στο νου κι η γνωση", "Όσα ξερει ο Κωνσταντης, δεν τα ξερει αλλος κανεις", "Χιλια ξερε κι ενα ρωτα"};
    private String[] watchword = {" Θα σας εξαφανισομεν", " Σοδομα και Γομορα", "Μπουρλοτο", "Πορτοκαλαδα απο πορτοκαλια θετε"};

    /**
     *
     * @param array
     * @return
     * Η αλήθεια είναι οτι εδω κάνω τρεις φορές την ιδια επανάληψη δεν μου ερχόταν κάποια ιδέα πως θα μπορούσα να
     * πάρω έναν απο τους τρεις πίνακες αλλιώς.
     *
     * Αρχικά αυτο που κάνει η getRandomWord ειναι να δημιουργεί εναν τυχαίο αριθμό (getWord) εντος των οριων του πινακα και στην συνεχεια
     * να επιστρέψει μια τιμη απο τον πινακα που θέλουμε.
     */

    public String getRandomWord(String[] array) {
        int getWord = randomWord.nextInt(array.length);
        return array[getWord];
    }

    /**
     * Έπειτα ανάλογα με την επιλογή του χρήστη καλούμε μια απο τις τρεις συναρτήσεις για να παρουμε μια τυχαια λεξη απο τον πινακα.
     * @return την παραπανω συναρτηση και στην θεση το array βαλε historicalPhraseArray,proverbs η watchword.
     */

    public String getRandomWordFromHistoricalPhraseArray() {

    return  getRandomWord(historicalPhraseArray).toUpperCase();
}

    public String getRandomWordFromProverbs() {

        return  getRandomWord(proverbs).toUpperCase();
    }
    public String getRandomWordFromWatchword() {

        return  getRandomWord(watchword).toUpperCase();
    }


}
