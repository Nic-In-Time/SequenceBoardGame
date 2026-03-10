public class CardManager {
    private int currentCard;
    Deck deck = new Deck();
    Board board = new Board(deck);
    //Shuffle the deck, also move all this to a constructor method
    Hand hand = new Hand(deck, currentCard);
}