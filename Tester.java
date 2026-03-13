public class Tester {
    public static void main(String[] args) {
        /*Deck deck = new Deck();
        Board board = new Board(deck);
        printBoard(board);
        deck.shuffleDeck();
        // printDeck(deck);
        Hand hand = new Hand(deck, 0);
        printHand(hand);*/
        CardManager manager = new CardManager(2);
        manager.printBoard();
        manager.printHands();
    }

}