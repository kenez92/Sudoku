package com.kenez92.io;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOService {
    private static final String ERR_BAD_VALUE = "Please put only numbers (x, y and value)";
    private static final String ERR_VALUE_IS_BIGGER_THAN_BOARD_SIZE = "Your number is bigger than board! Put properly numbers :";
    private static final String ERR_INPUT_LIST_IS_NOT_EQUAL_TO_3 = "Please put only three numbers (x, y and value)";

    public List<Integer> convertToIntegers(String input, int boardSize) {
        List<String> numbers = Arrays.asList(input.split(" |,"));
        List<Integer> resultList = new ArrayList<>();
        if (numbers.size() != 3) {
            System.out.println(ERR_INPUT_LIST_IS_NOT_EQUAL_TO_3);
            return new ArrayList<>();
        }
        for (String element : numbers) {
            for (int i = 0; i < element.length(); i++) {
                char character = element.charAt(i);
                byte characterCode = (byte) character;
                if (!(characterCode >= 38 && characterCode <= 57)) {
                    System.out.println(ERR_BAD_VALUE);
                    return new ArrayList<>();
                }
            }
            int number = Integer.parseInt(element);
            if (number > 0 && number <= boardSize) {
                resultList.add(number);
            } else {
                System.out.println(ERR_VALUE_IS_BIGGER_THAN_BOARD_SIZE);
                return new ArrayList<>();
            }
        }
        return resultList;
    }
}
