package com.sguess.service.impl;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BinTest {
    public static void main(String[] args) {
        BinTest test = new BinTest();
        test.test();
    }

    public void test() {
        int[] arrays = {1, 2, 3, 5, 6, 7, 8};
        Arrays.sort(arrays);

        assertEquals(-1,findLocation(0, arrays));
        assertEquals(0,findLocation(1, arrays));
        assertEquals(-1,findLocation(4, arrays));
        assertEquals(3,findLocation(5, arrays));
        assertEquals(6,findLocation(8, arrays));
        assertEquals(-1,findLocation(9, arrays));

    }

    private int findLocation(int num, int[] arrays) {
        return findInBin(num, arrays, 0, arrays.length - 1);
    }

    private int findInBin(int number, int[] arrays, int start, int end) {
        if (start > end) {
            return -1;
        }
        int halfLocation = start + (end - start) / 2;
        int midVal = arrays[halfLocation];
        if (number < midVal) {
            return findInBin(number, arrays, start, halfLocation - 1);
        } else if (number > midVal) {
            return findInBin(number, arrays, halfLocation + 1, end);
        } else if (number == midVal) {
            return halfLocation;
        } else {
            return -2;
        }
    }
}
