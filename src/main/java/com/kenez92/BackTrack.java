package com.kenez92;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackTrack {
    public static BackTrack instance = null;
    private final Deque<SudokuBoard> sudokuBoards;
    private final Deque<LastMove> lastMoves;

    private BackTrack() {
        sudokuBoards = new ArrayDeque<>();
        lastMoves = new ArrayDeque<>();
    }

    public static BackTrack getInstance() {
        if (instance == null) {
            synchronized (BackTrack.class) {
                if (instance == null) {
                    instance = new BackTrack();
                }
            }
        }
        return instance;
    }

    public Deque<SudokuBoard> getSudokuBoards() {
        return sudokuBoards;
    }

    public Deque<LastMove> getLastMoves() {
        return lastMoves;
    }

    public boolean addBackTrack(SudokuBoard sudokuBoard, LastMove lastMove) throws SudokuException {
        if (instance != null) {
            try {
                SudokuBoard clonedSudokuBoard = sudokuBoard.deepClone();
                clonedSudokuBoard.getSudokuRowList().get(lastMove.getPositionY()).getSudokuElementList().get(lastMove.getPositionX())
                        .getAvailableNumbers().remove(Integer.valueOf(lastMove.getValue()));
                sudokuBoards.offerFirst(sudokuBoard.deepClone());
                lastMoves.offerFirst(lastMove);
            } catch (CloneNotSupportedException e) {
                throw new SudokuException(SudokuException.ERR_SOMETHING_WENT_WRONG);
            }
            return true;
        } else {
            return false;
        }
    }
}