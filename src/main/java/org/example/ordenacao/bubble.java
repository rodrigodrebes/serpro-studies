package org.example.ordenacao;

import java.awt.*;
import java.util.ArrayList;

public class bubble {
    public static void main(String[] args) {

        int[] array = {11,22,955,300,2,5,85,340};

        for (int i=0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

       for(int arr : array){
           System.out.println(arr);
       }
    }


}
