package minesweeper.board.exceptions;

public class SteppedOnMineException extends Exception{
    public SteppedOnMineException(String message) {
        super(message);
    }
}
