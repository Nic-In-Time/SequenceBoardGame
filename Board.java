public class Board {
    public Board(Deck deck) {
        if (deck.getDeck().length > 104) {
            throw new IllegalArgumentException("The deck must have 104 or more cards when creating the board.");
        }
        
        board = new Card[10][10];
        /*for (int i = 1; i < deck.getDeck().length + 1; i++) {
            System.out.println((i / 10) + " " +  (i - i / 10));
            board[i / 10][i - i / 10] = new Card(deck.getDeck()[i].getNumber(), deck.getDeck()[i].getSuit());
        }*/
        int currentCard = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 && j == 0) || (i == 9 && j == 0) || (i == 0 && j == 9) || (i == 9 && j == 9)) {
                    board[i][j] = new Card(0, '0');
                    System.out.println("hi");
                    System.out.println(i);
                    System.out.println(j);
                } else {
                    if (deck.getDeck()[currentCard].getNumber() == 11) {currentCard ++;}
                    board[i][j] = new Card(deck.getDeck()[currentCard].getNumber(), deck.getDeck()[currentCard].getSuit());
                    currentCard++;
                }
            
            }
        }
    }
    private Card[][] board;
    public String[] print() {
        String[] toPrint = new String[50];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < 5; j++) {
                String toAddToPrint = "";
                for (int k = 0; k < 10; k++) {
                    toAddToPrint += this.board[i][k].print()[j];
                }
                toPrint[i * 5 + j] = toAddToPrint;
            }
        }
        return toPrint;
    }
    public String toString() {
        return "";
    }
}