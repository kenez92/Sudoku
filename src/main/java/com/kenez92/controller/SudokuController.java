package com.kenez92.controller;

import com.kenez92.board.SudokuBoard;
import com.kenez92.io.IO;
import com.kenez92.io.IOEnum;

import java.util.List;

public class SudokuController {
    IO io = new IO();

    public SudokuBoard createSudokuBoard() {
        return new SudokuBoard(io.getSudokuSize());
    }

    public List<Integer> getPlayerMove(int boardSize) {
        return io.getPlayerMove(boardSize);
    }

    public void badPlayerMove() {
        io.badPlayerMove();
    }

    public boolean playAgain() {
        return io.playAgain();
    }

    public IOEnum getPlayerChoice() {
        return io.getPlayerChoice();
    }
}