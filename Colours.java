/**Represents the colours needed for Sequence. */
public enum Colours {
    RED("\u001B[31m"), BLUE("\u001B[34m"), TEAM1("\u001B[33m"/*Yellow */), TEAM2("\u001B[35m"/*Purple */), RESET("\u001B[0m");

    private final String colourCode;
    
    private Colours(String colourCode) {
        this.colourCode = colourCode;
    }
    
    public String getColourCode() {
        return this.colourCode;
    }
}