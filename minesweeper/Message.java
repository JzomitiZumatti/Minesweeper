public enum Message {
    CELL_IS_NUMBER("There is a number here"),
    CONGRATULATIONS ("Congratulations! You found all mines!"),
    TURN ("Set/delete mine marks (x and y coordinates): "),
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
