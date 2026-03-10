public class Card {
    private int number;
    private char suit;
    //TODO change colours to apply to which player owns that tile on the board, or default if none have it (for sequence specifically)
    private static final String BLUE = "\u001B[34m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public Card(int number, char suit) {
        validateNumber(number);
        validateSuit(suit);
        this.number = number;
        this.suit = suit;
    }
    public String[] print() {
        String suitIcon = "";
        String numberIcon = "";
        
        String colour = RESET;
        switch (this.suit) {
            case 'H':
                suitIcon = "";
                colour = RED;
                break;
            case 'S':
                suitIcon = "󰣑";
                colour = BLUE;
                break;
            case 'D':
                suitIcon = "󰣏";
                colour = RED;
                break;
            case 'C':
                suitIcon = "󰣎";
                colour = BLUE;
                break;
            case '0':
                suitIcon = "";
                break;
        }
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
    public int getNumber() {
        return this.number;
    }
    public char getSuit() {
        return this.suit;
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
}

// Spade: 󰣑, heart: , diamond: 󰣏, clubs: 󰣎