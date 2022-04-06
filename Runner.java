public class Runner{
    public static void main(String[] args) {
        MemoryGameGUI x = new MemoryGameGUI();
        boolean isHard = x.Easy_Hard();
        //If player agrees to hard difficulty, present hard home of game (V2)
        if(isHard){
            MemoryGame y = new MemoryGame();
            y.V2();
        }
        //If player wants to play normal mode, present normal mode (V1)
        else{
            MemoryGame y = new MemoryGame();
            y.v1();
        }
    }
}