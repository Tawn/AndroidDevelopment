package project01.csc214.duogames;


import java.util.Random;

public class HangmanGame {

    private String[] alreadyGuessed = new String[26];
    private String[] words = new String[10];
    private String wordToGuess;
    private int count;

    public HangmanGame() {
        words[0] = "BUTTER";
        words[1] = "GINGER";
        words[2] = "MILK";
        words[3] = "BREAD";
        words[4] = "EGGS";
        words[5] = "LETTUCE";
        words[6] = "POTATOES";
        words[7] = "CARROT";
        words[8] = "GRAPES";
        words[9] = "APPLES";

        count = 0;
        generateWord();
    }

    public void reset() {
        alreadyGuessed = new String[26];
        count = 0;
    }
    public void generateWord() {
        Random rand = new Random();
        wordToGuess = words[rand.nextInt(10)];
    }

    public String[] getGuessedLetters() {
        return alreadyGuessed;
    }

    public int getLetterCount() {
        return count;
    }

    public int wordLength() {
        return wordToGuess.length();
    }

    public int check(String guess) {

        /**
         * Legend:
         * 0: already guessed letter
         * 1: correct word
         * 2: correct letter
         * 3: incorrect word
         * 4: incorrect letter
         */

        // Convert to Uppercase
        guess = guess.toUpperCase();


        // Guessing the word
        if(guess.length() > 1) {
            if (guess.equals(wordToGuess)) { // if Guess correctly
                return 1;
            } else { // Incorrect word
                return 3;

            }


            // Guessing a letter
        } else {

            for(int i = 0; i < count; i++) { // If already guessed
                if (alreadyGuessed[i].equals(guess)) {
                    return 0;
                }
            }

            // Insert new guess into array of already guessed
            alreadyGuessed[count] = guess;
            count++;

            if(wordToGuess.contains(guess)) { // Correct letter

                // returns 1 for complete 2 for not complete
                return checkCompleteLetters();

            } else { // Incorrect Letter
                return 4;

            }

        }

    }

    public String getStatusDisplay() {
        String setup = "Word: ";

        for(int i = 0; i < wordToGuess.length(); i++) {
            String letter = Character.toString(wordToGuess.charAt(i));
            if(contains(letter)) {
                    setup += letter + " ";

            } else {
                if(i == wordToGuess.length()-1)
                    setup += "_";
                else
                    setup += "_ ";
            }
        }
        return setup;

    }

    public boolean contains(String guess) {
        for(int i = 0; i < count; i++) {
            if(alreadyGuessed[i].equals(guess)) {
                return true;
            }
        }
        return false;
    }

    public int checkCompleteLetters() {
        if (getStatusDisplay().contains("_")) { // Incomplete
            return 2;
        } else { // Complete
            return 1;
        }
    }

}
