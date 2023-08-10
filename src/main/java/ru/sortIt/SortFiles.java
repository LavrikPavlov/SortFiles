package ru.sortIt;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;

public class SortFiles {

    public static void main(String[] args) throws FileNotFoundException {

        args = argsWork(args);

        for (int i = 0; i < args.length; i++) {
            System.out.println("Аргумент: " + i + " - " + args[i]);
        }
        System.out.print("\n");

        WorkWithFile wwf = new WorkWithFile(args[3], args[4], args[5]);
        WorkWithArrayInt wwa = new WorkWithArrayInt();

        int[][] arrs = wwf.openFile();

        System.out.println("\nСодержание файлов:");
        for(int i = 0; i <= arrs.length - 1; i++) {
            System.out.println("File {"+ (i+1) +"}: " + Arrays.toString(arrs[i]));
        }
        System.out.print("-----\n");

        for(int i = 0; i <= arrs.length - 1; i++) {
            if(arrs[i] != null)
                System.out.println("File {"+(i+1)+"}:" + Arrays.toString(wwa.SortMass(arrs[i])));
        }
        System.out.print("-----\n");

        int[] arrOut = wwa.combineMassOut(wwa.SortMass(arrs[0]), wwa.SortMass(arrs[1]), wwa.SortMass(arrs[2]));
        System.out.println("Слияние массива: \n" + Arrays.toString(arrOut));
        System.out.println("-----\n");

        if (Objects.equals(args[1], "-d")) {
            arrOut = wwa.SortMass(arrOut);
            System.out.println("Ответ по убыванию: " + Arrays.toString(arrOut));
        } else {
            arrOut = wwa.reverseMass(arrOut);
            System.out.println("Ответ по возрастанию: " + Arrays.toString(arrOut));
        }

        wwf.writeInFile(arrOut, args[2]);
    }

    private static String[] argsWork(String[] args) {
        String[] argsNew = new String[6];
        int j = 3;
        for (int i = 0; i <= (args.length - 1); i++) {
            if (Objects.equals(args[i], "-i") || Objects.equals(args[i], "-s"))
                argsNew[0] = args[i];
            else if (Objects.equals(args[i], "-a") || Objects.equals(args[i], "-d"))
                argsNew[1] = args[i];
            else if (Objects.equals(args[i], "in.txt") || Objects.equals(args[i], "in1.txt") ||
                    Objects.equals(args[i], "in2.txt") || Objects.equals(args[i], "in3.txt")) {
                argsNew[j] = args[i];
                j += 1;
            } else {
                argsNew[2] = args[i];
            }
        }
        return argsNew;
    }

    private static int RandNumber() {
        double num = Math.random();
        num *= 10;
        return (int) num;
    }


}