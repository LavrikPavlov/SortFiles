package org.example;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class SortFilesInfo {

    public static void main(String[] args) throws FileNotFoundException {

        WorkWithFile wwf = new WorkWithFile("in1.txt", "in2.txt", "in3.txt");
        WorkWithArrayInt wwa = new WorkWithArrayInt();



        int[][] arrs = wwf.openFile();
        int[] arr1 = arrs[0];
        int[] arr2 = arrs[1];
        int[] arr3 = arrs[2];


//
//        for (int i = 0; i < arr1.length; i++) {
//            arr1[i] = RandNumber();
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            arr2[i] = RandNumber();
//        }
//        for (int i = 0; i < arr3.length; i++) {
//            arr3[i] = RandNumber();
//        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println("-----\n");

        arr1 = wwa.SortMass(arr1);
        arr2 = wwa.SortMass(arr2);
        arr3 = wwa.SortMass(arr3);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println("-----\n");

        int[] arrOut = wwa.combineMassOut(arr1, arr2, arr3);



        System.out.println(Arrays.toString(arrOut));
        arrOut = wwa.SortMass(arrOut);
        System.out.println("Ответ по убыванию: " + Arrays.toString(arrOut));
        arrOut = wwa.reverseMass(arrOut);
        System.out.println("Ответ по возрастанию: " + Arrays.toString(arrOut));

        wwf.writeInFile(arrOut);

    }

    private static int RandNumber() {
        double num = Math.random();
        num *= 10;
        return (int) num;
    }



}