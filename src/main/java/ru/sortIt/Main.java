package ru.sortIt;

import ru.sortIt.workClasses.WorkWithArrayInt;
import ru.sortIt.workClasses.WorkWithArrayString;
import ru.sortIt.workClasses.WorkWithFile;

import java.util.Arrays;
import java.util.Objects;

public class Main {


    public static void main(String[] args) {
        try {
            args = argsWork(args);
            WorkWithFile wwf = new WorkWithFile(args[3], args[4], args[5]);

            if (args[2] == null) args[2] = "out.txt";

            if (Objects.equals(args[0], "-s")) {
                String[] arrOut = stringWork(wwf, args);
                wwf.writeInFile(arrOut, args[2]);
            } else if (Objects.equals(args[0], "-i")) {
                int[] arrOut = intWork(wwf, args);
                wwf.writeInFile(arrOut, args[2]);
            } else if (Objects.equals(args[0], "help"))
                throw new Exception("");
            else
                throw new Exception("Отсутсвуют обязательные аргументы");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
            helpWork();
        }
    }



    private static int[] intWork(WorkWithFile wwf, String[] args) {
        WorkWithArrayInt wwi = new WorkWithArrayInt();
        int[][] arrs = wwf.openFileInt();
        System.out.println("\nСодержание файлов:");
        for (int i = 0; i <= arrs.length - 1; i++) {
            System.out.println("File {" + (i + 1) + "}: " + Arrays.toString(arrs[i]));
        }
        System.out.println("-----\n");

        for (int i = 0; i <= arrs.length - 1; i++) {
            if (arrs[i] != null) System.out.println("File {" + (i + 1) + "}:" + Arrays.toString(wwi.sortMass(arrs[i])));
        }
        System.out.println("-----\n");

        int[] arrOut = wwi.combineMassOut(wwi.sortMass(arrs[0]), wwi.sortMass(arrs[1]), wwi.sortMass(arrs[2]));
        System.out.println("\nСлияние массива: \n" + Arrays.toString(arrOut));
        System.out.println("-----");

        if (Objects.equals(args[1], "-d")) {
            arrOut = wwi.sortMass(arrOut);
            System.out.println("Ответ по убыванию: " + Arrays.toString(arrOut));
        } else {
            arrOut = wwi.reverseMass(arrOut);
            System.out.println("Ответ по возрастанию: " + Arrays.toString(arrOut));
        }
        return arrOut;
    }


    private static String[] stringWork(WorkWithFile wwf, String[] args) {
        String[][] arrs = wwf.openFileString();
        System.out.println("\nСодержание файлов:");
        for (int i = 0; i < arrs.length; i++) {
            System.out.println("File {" + (i + 1) + "}: " + Arrays.toString(arrs[i]));
        }
        System.out.println("-----");

        WorkWithArrayString wws = new WorkWithArrayString();

        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] != null) {
                System.out.println("File {" + (i + 1) + "}: " + Arrays.toString(wws.sortMass(arrs[i])));
            }
        }
        System.out.println("-----");

        String[] arrOut = wws.combineMassOut(arrs[0], arrs[1], arrs[2]);

        if (Objects.equals(args[1], "-d")) {
            arrOut = wws.sortMass(arrOut);
            System.out.println("Ответ по убыванию: " + Arrays.toString(arrOut));
        } else {
            arrOut = wws.reverseMass(arrOut);
            System.out.println("Ответ по возрастанию: " + Arrays.toString(arrOut));
        }

        return arrOut;
    }


    private static String[] argsWork(String[] args) {
        String[] argsNew = new String[7];
        int j = 3;
        for (int i = 0; i < args.length; i++) {
            if (Objects.equals(args[i], "-i") || Objects.equals(args[i], "-s") || Objects.equals(args[i], "help"))
                argsNew[0] = args[i];
            else if (Objects.equals(args[i], "-a") || Objects.equals(args[i], "-d")) argsNew[1] = args[i];
            else if (Objects.equals(args[i], "in.txt") || Objects.equals(args[i], "in1.txt") || Objects.equals(args[i], "in2.txt") || Objects.equals(args[i], "in3.txt")) {
                argsNew[j] = args[i];
                j += 1;
            } else {
                argsNew[2] = args[i];
            }
        }
        return argsNew;
    }

    private static void helpWork() {
        System.out.println("Аргумент 1: \"-i\" - работа с int | \"-s\" - работа с string");
        System.out.println("Аргумент 2: \"-d\" - по убыванию | default - по возрастанию");
        System.out.println("Аргумент 3: \"nameFile.txt\" - наимнование выходного файла | default - выходной файл \"out.txt\"");
        System.out.println("Аргумент 4: \"in1.txt\" - наимнование входного файла");
        System.out.println("Аргумент 5: \"in2.txt\" - наимнование входного файла");
        System.out.println("Аргумент 6: \"in3.txt\" - наимнование входного файла");
    }



    private static void helpWork() {
        System.out.println("Аргумент 1: \"-i\" - работа с int | \"-s\" - работа с string");
        System.out.println("Аргумент 2: \"-d\" - по убыванию | default - по возрастанию");
        System.out.println("Аргумент 3: \"nameFile.txt\" - наимнование выходного файла | default - выходной файл \"out.txt\"");
        System.out.println("Аргумент 4: \"in1.txt\" - наимнование входного файла");
        System.out.println("Аргумент 5: \"in2.txt\" - наимнование входного файла");
        System.out.println("Аргумент 6: \"in3.txt\" - наимнование входного файла");
    }


}