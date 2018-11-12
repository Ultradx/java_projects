package Ask3;


import java.util.Scanner;

public class ChoiceMessages {
    private String name;
    private int choice;
    private int easyOrDificcultMode;

    /**
     * Δημιουργία αντικειμένων WordList,WordGuess από τις αντίστοιχες κλασεις
     */
    Scanner input = new Scanner(System.in);
    WordList wordList = new WordList();
    WordGuess wordGuess = new WordGuess();

    /**
     * Μήνυμα welcomeMessage για να πάρουμε και να καλωσορίσουμε τον χρήστη
     */

    public void welcomeMessage() {
        System.out.println("Please Enter Your Name: ");
        name = input.next();
        System.out.printf("Welcome To The Game %s%n",name);
        Choice(); //Τρεξε την συναρτηση Choice
    }

    /**
     *
     * @return Μας επιστρέφει την απάντηση του χρήστη που εισήγαγε στο πληκτρολόγιο στην συνάρτηση Choice.
     *  Αυτή την τιμή την χρειαζόμαστε για να μπορέσει το πρόγραμμα
     *  να καταλάβει από ποιον πίνακα πρέπει να πάρουμε την λέξη.
     *  Δηλαδη 1)<<ΙΣΤΟΡΙΚΕΣ ΦΡΑΣΕΙΣ>>, 2)«ΠΑΡΟΙΜΙΕΣ», 3)«ΑΤΑΚΕΣ ΑΠΟ ΤΑΙΝΙΕΣ).
     */
    public int getUserInput() {
        return choice;
    }

    /**
     *
     * @return Το ίδιο με το πάνω πιο επίπεδο θέλει να παίξει εύκολο η δύσκολο.
     */

    public int getUserInputForEasyOrDifficultMode() { return easyOrDificcultMode; }

    /**
     * Ανάλογα με την τιμή που εισήγαγε ο χρήστης το προγραμμα θα εισχωρήσει σε εναν απο τους τρεις πινακες.
     */

    public void displayWord() {
        String word =  ""; // Αρχικοποίηση με κενό τη λέξη word για να μπορέσει να την διαβάσει η getUserInputForEasyOrDifficultMode() συνάρτηση.


        int life = 5;

        //Αν το getUserInput ειναι 1,2 η 3 τοτε παρε την λεξη τον πινακα της κλασης WordList

        if (getUserInput() == 1) {
            word = wordList.getRandomWordFromHistoricalPhraseArray();
        }
        else if (getUserInput() == 2) {
            word = wordList.getRandomWordFromProverbs();
        }
        else if (getUserInput() == 3) {
            word = wordList.getRandomWordFromWatchword();
        }

        //Αν getUserInputForEasyOrDifficultMode ειναι 1 η 2 παρε την συναρτηση displayDashesEasyMode η displayDashesToDifficultMode απο την κλαση WordGuess

        if (getUserInputForEasyOrDifficultMode() == 1) {
            wordGuess.displayDashesEasyMode(word,life);
        }
        else if (getUserInputForEasyOrDifficultMode() == 2) {
            wordGuess.displayDashesToDifficultMode(word,life);
        }

    }

    /**
     *Συναρτηση Choice περιέχει 2 μεταβλητες Scanner τις choice, easyOrDificcultMode τις οποιες τις ανελυσα παραπάνω.
     * Ουσιαστικά αυτο που κανει ειναι να εμφανίζει τα ακόλουθα μνήματα στον χρήστη αναλογα με τις επιλογες που κανει.
     * Στην συνεχεια καλεί την displayWord() οι οποία παίρνει την λέξη από έναν από του ακόλουθους πίνακες.
     */

    public void Choice() {

        boolean exit = true;

        while (exit) {
            System.out.println("What category do you want to play 1)<<ΙΣΤΟΡΙΚΕΣ ΦΡΑΣΕΙΣ>>, 2)«ΠΑΡΟΙΜΙΕΣ», 3)«ΑΤΑΚΕΣ ΑΠΟ ΤΑΙΝΙΕΣ 4)Exit");
            choice = input.nextInt();

            switch (choice)  {
                case 1:
                    System.out.println("You chose <<ΙΣΤΟΡΙΚΕΣ ΦΡΑΣΕΙΣ>>");
                    System.out.println("Select Mode 1)Easy 2)Difficult");
                    easyOrDificcultMode = input.nextInt();
                    System.out.println("You Should Change Your Keyboard From ENGLISH To GREEK If You Want To Play"); //Λογου του οτι τις λεξεις τις εχω θεσει στα Ελληνικα πρεπει να γινει αλλαγή του πληκτολογιου στα ελληνικα
                    displayWord();
                    break;

                case 2:
                    System.out.println("You chose «ΠΑΡΟΙΜΙΕΣ»");
                    System.out.println("Select Mode 1)Easy 2)Difficult");
                    easyOrDificcultMode = input.nextInt();
                    System.out.println("You Should Change Your Keyboard From ENGLISH To GREEK If You Want To Play");
                    displayWord();
                    break;
                case 3:
                    System.out.println("You chose «ΑΤΑΚΕΣ ΑΠΟ ΤΑΙΝΙΕΣ»");
                    System.out.println("Select Mode 1)Easy 2)Difficult");
                    easyOrDificcultMode = input.nextInt();
                    System.out.println("You Should Change Your Keyboard From ENGLISH To GREEK If You Want To Play");
                    displayWord();
                    break;
                case 4:
                    System.out.println("Have a nice day");
                    exit = false;
                    break;
                default:
                    System.out.println("Invalid Input please Try Again");
                    break;

            }
        }
    }

}
