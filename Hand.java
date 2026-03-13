public class Hand {
    private Card[] hand;
    public Hand(Deck deck, int currentCard) {
        hand = new Card[6];
        for (int i = 0; i < hand.length; i++) {
            hand[i] = deck.getDeck()[currentCard];
            currentCard++;
        }
        //this.hand = hand;
    }
    public Card[] getHand() {
        return this.hand;
    }
    public String[] print() {
        String[] toPrint = new String[5];
        
            for (int j = 0; j < 5; j++) {
                String toAddToPrint = "";
                for (int k = 0; k < 6; k++) {
                    toAddToPrint += this.hand[k].print()[j];
                }
                toPrint[j] = toAddToPrint;
            }
        
        return toPrint;
        
    }
}