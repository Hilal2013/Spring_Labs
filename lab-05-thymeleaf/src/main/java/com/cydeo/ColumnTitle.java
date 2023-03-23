package com.cydeo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColumnTitle {
    public static void main(String[] args) {

    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        int digit = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            result += digit * (columnTitle.charAt(i) - 'A' + 1);
            digit *= 26;
        }
        return result;
    }

    @Test//my method is gonna runnable too
    public void testTitleToNumber(){

        Assertions.assertEquals(1,titleToNumber("A"));
        Assertions.assertEquals(27,titleToNumber("AA"));
    }



}