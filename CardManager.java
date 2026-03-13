public class CardManager {
    private int currentCard = 0;
    private Deck deck;
    private Board board;
    private Hand[] hands;
    public CardManager(int playerCount) {
        this.deck = new Deck();
        this.board = new Board(this.deck);
        deck.shuffleDeck();
        hands = new Hand[playerCount];
        for (int i = 0; i < playerCount; i++) {
            hands[i] = new Hand(deck, currentCard);
            currentCard += 6;
        }
    }
    public void printDeck() {
        for (Card card : this.deck.getDeck()) {
            String[] toPrint = card.print();
            for (String string : toPrint) {
                System.out.println(string);
            }
        }
    }

    public void printBoard() {
        String[] boardPrint = board.print();
        for (String string : boardPrint) {
            System.out.println(string);
        }
    }

    public void printHands() {
        for (int i = 0; i < this.hands.length; i++) {
            printHand(i);
        }
    }
    
    public void printHand(int handPos) {
        String[] handPrint = this.hands[handPos].print();
        for (String string : handPrint) {
            System.out.println(string);
        }
    }
}