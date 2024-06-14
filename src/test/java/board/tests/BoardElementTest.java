package board.tests;

import minesweeper.board.BoardElement;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class BoardElementTest {
    BoardElement boardElement = new BoardElement();

    @Test
    @DisplayName("Initialised board elements should be covered and not flagged")
    void testInitialisation() {
        assertFalse(boardElement.getUncovered());
        assertFalse(boardElement.getFlagged());
    }

    @Test
    @DisplayName("Testing mine assignment and recognition")
    void testMine() {
        assertFalse(boardElement.isMine());

        boardElement.setAsMine();
        assertTrue(boardElement.isMine());
    }

    @Test
    @DisplayName("If we uncover an element it should stay uncovered.")
    void testUncovering() {
        assertFalse(boardElement.getUncovered());

        boardElement.uncover();
        assertTrue(boardElement.getUncovered());

        boardElement.uncover();
        assertTrue(boardElement.getUncovered());
    }

    @Test
    @DisplayName("An element should be able to be un-flagged if flagged")
    void testFlagged() {
        assertFalse(boardElement.getFlagged());

        boardElement.toggleFlag();
        assertTrue(boardElement.getFlagged());

        boardElement.toggleFlag();
        assertFalse(boardElement.getFlagged());
    }

    @Test
    @DisplayName("Incrementing the bomb number should work")
    void testIncrement() {
        assertEquals(0, boardElement.getNumberOfBombsNearby());

        boardElement.incrementNumberOfBombsNearby();
        assertEquals(1, boardElement.getNumberOfBombsNearby());

        boardElement.incrementNumberOfBombsNearby();
        boardElement.incrementNumberOfBombsNearby();
        boardElement.incrementNumberOfBombsNearby();
        assertEquals(4, boardElement.getNumberOfBombsNearby());
    }

    @Test
    @DisplayName("Number of bombs should not be higher than 8")
    void testHigher() {
        assertEquals(0, boardElement.getNumberOfBombsNearby());

        for(int i = 0; i < 8; i++) {
            boardElement.incrementNumberOfBombsNearby();
        }

        assertEquals(8, boardElement.getNumberOfBombsNearby());

        boardElement.incrementNumberOfBombsNearby();
        assertEquals(8, boardElement.getNumberOfBombsNearby());
    }
}
