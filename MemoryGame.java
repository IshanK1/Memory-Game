public class MemoryGame {
    MemoryGame() {

    }

    // Regular (normal difficulty) verison of the game (V1)
    public void v1() {
        // Letters that can appear on panes.
        String[] memString = { "a", "b", "c" };
        // Creates a new GUI and gameboard.
        MemoryGameGUI x = new MemoryGameGUI();
        x.createBoard(3, false);
        boolean isPlay = true;
        // Keeps track of rounds and score to be displayed at the end.
        int rounds = 0;
        int score = 0;

        while (isPlay) {
            // stores random sequence of STRINGS
            String[] rand = new String[3];
            // stores random sequence of INDICES (1 to 3 in this game mode)
            int[] randNum = RandomPermutation.next(3);
            // decrements all INDICES by 1 (0 to 2)
            for (int i = 0; i < randNum.length; i++) {
                randNum[i] -= 1;
            }
            // creates random sequence of STRINGS (stored in rand)
            for (int i = 0; i < randNum.length; i++) {
                rand[i] = memString[randNum[i]];
            }
            // displays values to the user with half second delay, gets response from user.
            String response = x.playSequence(rand, 0.5);
            // if user responds with an empty string, prompt again
            while (response.isEmpty()) {
                response = x.playSequence(rand, 0.5);
            }

            boolean doesMatch = true;
            // game ends if user input doesn't match sequence.
            for (int i = 0; i < rand.length; i++) {
                if (!(rand[i].equals(response.substring(i, i + 1)))) {
                    doesMatch = false;
                    break;
                }
            }
            // game continues if user input matches
            if (doesMatch == true) {
                x.matched();
                score++;
                rounds++;
            } else {
                x.tryAgain();
                rounds++;

            }
            // Allows players to have multiple rounds
            // If player wishes to exit (hits cancel), isPlay set to false.
            isPlay = x.playAgain();

        }

        // Displays score+rounds at end of match
        x.showScore(score, rounds);
    }

    // All Subsequent code pertains to the hard mode version of the game (V2)
    public void V2() {
        // extended list of letters that can appear on panes.
        String[] memString = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m" };
        // initial size of memory game panels, increments each round.
        int initial = 3;
        // maximum size of memory game panels
        int ending = 8;
        // Keeps track of rounds and score to be displayed at the end.
        int rounds = 0;
        int score = 0;
        // Creates a new GUI
        MemoryGameGUI x = new MemoryGameGUI();
        boolean isPlay = true;
        double delay = 0.5;
        while (isPlay && initial <= ending) {
            // New board is created after each round,the length initial increases by 1
            // everytime sequence is answered correctly
            x.createBoard(initial, false);
            // stores random sequence of STRINGS (length initial)
            String[] rand = new String[initial];
            // stores random sequence of INDICES (1 to "initial" in this game mode)
            int[] randNum = RandomPermutation.next(initial);
            // decrements all INDICES by 1 (0 to 'initial'-1)
            for (int i = 0; i < randNum.length; i++) {
                randNum[i] -= 1;
            }
            // creates random sequence of STRINGS (stored in rand)

            for (int i = 0; i < randNum.length; i++) {
                rand[i] = memString[randNum[i]];
            }
            // displays values with a delay, gets response from user.

            String response = x.playSequence(rand, delay);
            // if user responds with an empty string, prompt again
            while (response.isEmpty()) {
                response = x.playSequence(rand, 0.5);
            }
            boolean doesMatch = true;
            // game ends if user input doesn't match sequence.

            for (int i = 0; i < rand.length; i++) {
                if (!(rand[i].equals(response.substring(i, i + 1)))) {
                    doesMatch = false;
                    break;
                }
            }
            // game continues if user input matches

            if (doesMatch == true) {
                x.matched();
                score++;
                rounds++;
                initial++;
                delay -= 0.05;
            } else {
                x.tryAgain();
                rounds++;
                initial++;
                delay -= 0.05;

            }
            // Allows players to have multiple rounds
            // If player wishes to exit (hits cancel), isPlay set to false.

            isPlay = x.playAgain();

        }
        // Displays score+rounds at end of match

        x.showScore(score, rounds);
    }
}