package minesweeper.board;

public class BoardElement {
    private int numberOfBombsNearby;
    private boolean flagged;
    private boolean uncovered;

    public BoardElement() {
        this.numberOfBombsNearby = 0;
        this.flagged = false;
        this.uncovered = false;
    }

    public void setNumberOfBombsNearby(int numberOfBombsNearby) {
        if (numberOfBombsNearby <= 8) {
            this.numberOfBombsNearby = numberOfBombsNearby;
        }
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public void setUncovered(boolean uncovered) {
        this.uncovered = uncovered;
    }

    public int getNumberOfBombsNearby() {
        return this.numberOfBombsNearby;
    }

    public boolean getFlagged() {
        return this.flagged;
    }

    public boolean getUncovered() {
        return this.uncovered;
    }

    public void setAsMine() {
        this.setNumberOfBombsNearby(-1);
    }

    public boolean isMine() {
        return getNumberOfBombsNearby() == -1;
    }

    public void uncover() {
        if (!this.getUncovered()) {
            this.setUncovered(true);
        }
    }

    public void toggleFlag() {
        this.setFlagged(!this.getFlagged());
    }

    public void incrementNumberOfBombsNearby() {
        int bombsNearby = this.getNumberOfBombsNearby();
        this.setNumberOfBombsNearby(++bombsNearby);
    }
}