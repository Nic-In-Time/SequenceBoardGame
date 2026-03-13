public class BoardTile {
    private char tileOwner;

    private Card tileCard;
    
    public Card getTileCard() {
        return tileCard;
    }

    public char getTileOwner() {
        return tileOwner;
    }

    public void setTileOwner(char tileOwner) {
        this.tileOwner = tileOwner;
    }

    public BoardTile(Card card) {
        tileCard = card;
        tileOwner = 'n';
    }

    public String[] print() {
        return tileCard.print();
    }

}