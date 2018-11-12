package Ask3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class WordGuess {

    private char[] display; //Δημιουργια πινακα χαρακτηρων


    /**
     * Δημιουργια συναρτησης για το δυσκολο επιπεδο και αυτο που κανει ειναι να δεχετε μια λεξη (που θα την παρουμε αυτοματα
     * απο τους πινακες που δημιουργησαμε προηγουμενος στην κλαση WordList) και εναν ακεραιο που αντιπροσοπευει τις ευκεριες.
     *Στην συνεχεια μεσω της while του λεμε να εμφανησει αστερακια αναλογα με το μεγεθος της λεξης και αν εχει κενα η λεξη να εμφανησει κανονικα το κενο.
     * @param word
     * @param life
     */


    public void displayDashesToDifficultMode(String word, int life) {

        display = new char[word.length()];
        int i = 0;

        while (i<word.length()) {
            display[i] = '*';
            if (word.charAt(i) == ' '){
                display[i] = ' ';
            }
            i++;
        }

        //Κανουμε εμφανησει με ατερακια την λεξη και καλουμε την guess που θα την αναλυσουμε παρακατω

        System.out.println(display);
        guess(word,life);

    }

    /**
     * Ιδια υλοποιηση με την πανω με την διαφορα πως μας εμφανιζει τρεια τυχαια γραμματα τις λεξεις
     * @param word
     * @param life
     */

    public void displayDashesEasyMode(String word, int life) {

        display = new char[word.length()];
        int i = 0;

        String[] wordsAsArray = word.split(""); // χωρισε την λεξη σε γραμματα για να μπορεσουμε να παρουμε ενα τυχαιο γραμμα
        for ( i = 0; i<3; i++) {
            int index = new Random().nextInt(wordsAsArray.length); //Επιλογη τυχαιας θεσεις
            char  randomWord = wordsAsArray[index].charAt(0); // Επιλογη του γραμματος και την θετουμε στην display.
            display[i] = randomWord;
        }


        while (i<word.length()) {

            display[i] = '*';
            if (word.charAt(i) == ' '){
                display[i] = ' ';
            }
            i++;
        }
        System.out.println(display);
        guess(word,life);

    }

    /**
     * Η συναρτηση guess δεχετε 2 μεταβλητες String, int οπως και η displayDashesToDifficultMode
     * και αυτο που κανει ειναι να δεχεται ενα Scanner input απο τον χρηστη και να αποθηκευη μονο το πρωτο γραμμα
     * (σε περιπτωση που ο χρηστης εισαγει συμβολοσειρα).
     * Αν το γραμμα το εχει ξανατοποθετηση προηγουμενος τοτε εμφανισε του μηνυμα System.out.println("Already entered").
     * Αλλιως αποθηκευσε τον χαρακτηρα σε μια λιστα για μελλοντικη χρηση της ιf (characters.contains(userCharacter)).
     * Στην συνεχεια αν το γραμμα του χρηση περιεχεται μεσα στον πινακα εμφανησε το γραμμα στην οθονη αλλιως μειωσε του τις ζωες.
     * Τελος αν ο χρηστης ολοκληρωση την λεξη η δεν εχει καμια ζωη εμφανησε το αντιστοιχο μηνυμα
     * και πηγαινε στο αρχικο μενου.
     * @param word
     * @param life
     */


    public void guess(String word, int life) {
        System.out.println(" Life remaining = " + life);

        Scanner input = new Scanner(System.in); // to read characters

        ArrayList<Character> characters = new ArrayList<>();

        while (true) {
            //boolean WinOrLose = true;
            char userCharacter = input.next().toUpperCase().charAt(0);  //character input user

            if (characters.contains(userCharacter))
            {
                System.out.println("Already entered");
                continue;    // while loop continues
            }

            characters.add(userCharacter);

            if (word.contains(userCharacter + "")) {
                for (int y=0; y<word.length(); y++) {
                    if (word.charAt(y)==userCharacter) {
                        display[y] = userCharacter;
                    }
                }
            } else {
                life--;         //life decreases if character entered isn't there in word
            }
            if (word.equals(String.valueOf(display))){
                System.out.println(display);
                System.out.println("You Won!!");
                System.out.println();
                break;
            }

            System.out.println(display);
            System.out.println(" Life remaining = " + life);

            if (life==0) {
                System.out.println("You lose!!");
                System.out.println();
                break;

            }
        }

    }


}
