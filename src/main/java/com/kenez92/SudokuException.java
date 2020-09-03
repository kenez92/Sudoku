package com.kenez92;

public class SudokuException extends RuntimeException {
    public static final String ERR_SOMETHING_WENT_WRONG = "Something went wrong !";

    public SudokuException(String message) {
        super(message);
    }
}