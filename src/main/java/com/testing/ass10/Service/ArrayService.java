package com.testing.ass10.Service;

import org.springframework.stereotype.Service;

@Service
public class ArrayService {

    public int[] ArrayFlattener(int[][] twoDimArray) {

        if(twoDimArray == null)
            return null;

        // Calculate the total number of elements
        int totalElements = 0;
        for (int[] row : twoDimArray) {
            totalElements += row.length;
        }

        // Create a new 1D array
        int[] oneDimArray = new int[totalElements];

        // Fill the 1D array
        int index = 0;
        for (int[] row : twoDimArray) {
            for (int value : row) {
                oneDimArray[index++] = value;
            }
        }

        return oneDimArray;
    }
}
