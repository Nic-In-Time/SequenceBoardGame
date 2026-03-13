public class Board {

    public Board(Deck deck) {

        if (deck.getDeck().length > 104) {
            throw new IllegalArgumentException("The deck must have 104 or more cards when creating the board.");
        }
        
        board = new BoardTile[10][10];
        /*for (int i = 1; i < deck.getDeck().length + 1; i++) {
            System.out.println((i / 10) + " " +  (i - i / 10));
            board[i / 10][i - i / 10] = new Card(deck.getDeck()[i].getNumber(), deck.getDeck()[i].getSuit());
        }*/
        int currentCard = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 && j == 0) || (i == 9 && j == 0) || (i == 0 && j == 9) || (i == 9 && j == 9)) {
                    Card card = new Card();
                    board[i][j] = new BoardTile(card);
                } else {
                    if (deck.getDeck()[currentCard].getNumber() == 11) {currentCard ++;}
                    Card card = new Card(deck.getDeck()[currentCard].getNumber(), deck.getDeck()[currentCard].getSuit(), Colours.RESET);
                    board[i][j] = new BoardTile(card);//new Card(deck.getDeck()[currentCard].getNumber(), deck.getDeck()[currentCard].getSuit(), "");
                    currentCard++;
                }
            
            }
        }
    }

    private BoardTile[][] board;

    public String[] print() {
        String[] toPrint = new String[50];
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < 5; j++) {
                String toAddToPrint = "";
                for (int k = 0; k < 10; k++) {
                    String inateColour = "\u001B[0m";//"";
                    if (!(this.board[i][k].getTileOwner() == 'n')) {
                        
                        if (this.board[i][k].getTileOwner() == 'y') {
                            inateColour = "\u001B[33m";
                        } else {
                            inateColour = "\u001B[35m";
                        }
                    }
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