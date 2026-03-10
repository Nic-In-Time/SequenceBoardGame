import java.util.Random;
public class Deck {
    public Deck() {
        // Create deck with 2 packs of cards.
        this.deck = new Card[104];
        char[] suits = {'H', 'S', 'D', 'C', 'H', 'S', 'D', 'C'};
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < 13; j++) {
                deck[i * 13 + j] = new Card(j + 1, suits[i]);
            }
        }
        /*for (int i = 0; i < deck.length; i++) {
            String[] currentCard = this.deck[i].print();
            for (int j = 0; j < currentCard.length; j++) {
                System.out.println(currentCard[j]);
            }
        }*/
        
    }
    public Card[] getDeck() {
        return this.deck;
    }
    public void shuffleDeck() {
        Random rand = new Random();
        
        for (int i = 0; i < this.deck.length - 2; i++) {
            int newPos = rand.nextInt(i, this.deck.length);
            
            Card tempCard = this.deck[i];
            this.deck[i] = this.deck[newPos];
            this.deck[newPos] = tempCard;
        }
    }
    private Card[] deck;
}