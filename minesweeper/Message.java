public enum Message {
    HOW_MANY_MINES("How many mines you want on the field?"),
    CONGRATULATIONS ("Congratulations! You found all mines!"),
    TURN ("Set/delete mine marks (x and y coordinates): "),
    MINE_STEPPED("You stepped on a mine and failed!"),
    CELL_IS_OUT_OF_BOUNDS("You should to choosing from 1 to 9! Try again.");
    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
