

public class Card {

    private enum Suits {
        SPADE(Colours.BLUE, "󰣑", 'S'), HEART(Colours.RED, "", 'H'), DIAMOND(Colours.RED, "󰣏", 'D'), CLUB(Colours.BLUE, "󰣎", 'C'), NULL(Colours.RESET, "   ", '0');

        private final Colours colour;

        private final String icon;

        private final char singleLetterValue;

        private Suits(Colours colour, String icon, char singleLetterValue) {
            this.colour = colour;
            this.icon = icon;
            this.singleLetterValue = singleLetterValue;
        }

        public String getIcon() {
            return icon;
        }

        public Colours getColour() {
            return colour;
        }

        public char getSingleLetterValue() {
            return singleLetterValue;
        }
    }

    private final int number;
    private final char suit;
    private Colours colour;
    private String suitIcon;
    private static final String RESET = "\u001B[0m";
    private char claimed = 'n';
    
    public Card(int number, char suit, Colours colour) {
        validateNumber(number);
        validateSuit(suit);
        for (Suits iterSuits : Suits.values()) {
            if (iterSuits.getSingleLetterValue() == suit) {
                suitIcon = iterSuits.getIcon();
            }
        }
        this.colour = colour;
        this.number = number;
        this.suit = suit;
    }

    public Card(int number, char suit) {
        validateNumber(number);
        validateSuit(suit);
        
        for (Suits iterSuits : Suits.values()) {
            if (iterSuits.getSingleLetterValue() == suit) {
                suitIcon = iterSuits.getIcon();
                this.colour = iterSuits.getColour();
            }
        }
        
        this.number = number;
        this.suit = suit;
    }
    
    /**Default constructor that creates a blank card */
    public Card() {
        number = 0;
        suit = '0';
        colour = Colours.RESET;
        suitIcon = "";
    }

    public String[] print() {
        String numberIcon = "";
        String colour = this.colour.getColourCode();
        // TODO Replace this switch with the enum values and in the constructor
        
        switch (this.number) {
            case 0:
                numberIcon = "   ";
                break;
            case 1:
                numberIcon = " A";
                break;
            case 10:
                numberIcon = this.number + "";
                break;
            case 11:
                numberIcon = " J";
                break;
            case 12:
                numberIcon = " Q";
                break;
            case 13:
                numberIcon = " K";
                break;
            default:
                numberIcon = " " + this.number;
                break;
        }
        String[] card = {
            colour + "┌------┐" + RESET, 
            colour + "|      |" + RESET,
            colour + "| " + numberIcon + "" + suitIcon + "  |" + RESET,
            colour + "|      |" + RESET,
            colour + "└------┘" + RESET
        };
        //System.out.println(this.suit);
        //System.out.println(this.number);
        return card;
    }
    
    /**Returns the card number as an int.
     *  Special Cases: <p>
     * <ul>
     *      <li>0: blank card <p>
     *      <li>11 - 13 and 1: Ace and Jack to king
     */
    public int getNumber() {
        return this.number;
    }

    /**Returns the suit of the card as a char */
    public char getSuit() {
        return this.suit;
    }

    /**Returns the value of the team that has the card claimed. */
    public char getClaimed() {
        return claimed;
    }

    private void validateNumber(int number) {
        if (number < 0 || number > 13) {
            throw new IllegalArgumentException("The card number must be between 0 and 13");
        }
    }

    private void validateSuit(char suit) {
        if (!(suit == 'H' || suit == 'S' || suit == 'D' || suit == 'C' || suit == '0')) {
            throw new IllegalArgumentException("The card suit must be either 0, H, D, C or S");
        }
    }
    
    public void setClaimed(char claimed) {
        if (!(claimed == 'p' || claimed == 'y')) {
            throw new IllegalArgumentException("Claimed must be either p for pink or y for yellow");
        }
        this.claimed = claimed;
        if (claimed == 'y') {
            this.colour = Colours.TEAM1;
        } else {
            this.colour = Colours.TEAM2;
        }

    }

    public void setColour(Colours colour) {
        this.colour = colour;
    }
    
}

// Spade: 󰣑, heart: , diamond: 󰣏, clubs: 󰣎