public class Tester {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Board board = new Board(deck);
        printBoard(board);
        deck.shuffleDeck();
        // printDeck(deck);
        Hand hand = new Hand(deck, 0);
        printHand(hand);
    }

    public static void printDeck(Deck deck) {
        for (int i = 0; i < deck.getDeck().length; i++) {
            String[] toPrint = deck.getDeck()[i].print();
            for (int j = 0; j < toPrint.length; j++) {
                System.out.println(toPrint[j]);
            }
        }
    }

    public static void printBoard(Board board) {
        String[] boardPrint = board.print();
        for (int i = 0; i < boardPrint.length; i++) {
            System.out.println(boardPrint[i]);
        }
    }

    public static void printHand(Hand hand) {
        String[] handPrint = hand.print();
        for (int i = 0; i < handPrint.length; i++) {
            System.out.println(handPrint[i]);
        }
    }
}