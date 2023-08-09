package org.example;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFile {


    private File file1, file2, file3;
    private final String path = "E:\\SortFiles\\src\\files\\";

    public WorkWithFile() {
        OpenFile();
    }

    public WorkWithFile(String name1, String name2, String name3) throws FileNotFoundException {
        this.file1 = new File(path + name1);
        this.file2 = new File(path + name2);
        this.file3 = new File(path + name3);
        openFile();
    }

    public WorkWithFile(String name1, String name2) {
        this.file1 = new File(path + name1);
        this.file2 = new File(path + name2);
        openFile();
    }

    public WorkWithFile(String name) {
        this.file1 = new File(path + name);
        openFile();
    }

    public void writeInFile(int[] arr) {
        String nameFile = "out.txt";
        try {
            File fileOut = new File(path + nameFile);
            if (!fileOut.exists()) {
                fileOut.createNewFile();
            }

            FileWriter fw = new FileWriter(path + nameFile);
            if(arr != null) {
                for (int num : arr)
                    fw.write(num + "\n");
            } else
                fw.write("null");
            fw.close();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }

    public void writeNameFile(String nameOne, String nameTwo, String nameThree) {
        if (!nameOne.isEmpty()) {
            this.file1 = new File(path + nameOne);
        }
        if (!nameTwo.isEmpty()) {
            this.file2 = new File(path + nameTwo);
        }
        if (!nameThree.isEmpty()) {
            this.file3 = new File(path + nameThree);
        }
    }

    protected int[][] openFile() {
        int[] arr1;
        if (file1 != null)
            arr1 = workWithFile(file1);
        else
            arr1 = null;

        int[] arr2;
        if (file2 != null)
            arr2 = workWithFile(file2);
        else
            arr2 = null;

        int[] arr3;
        if (file3 != null)
            arr3 = workWithFile(file3);
        else
            arr3 = null;

        return new int[][]{arr1, arr2, arr3};
    }

    private static void OpenFile() {
        System.out.println("Не были указаны файлы");
    }

    private static int[] workWithFile(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<String> lines = new ArrayList<String>();
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();

            int[] arr = new int[lines.size()];
            for (int i = 0; i < lines.size(); i++)
                arr[i] = Integer.parseInt(lines.get(i));
            return arr;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка: " + e);
            return null;
        }
    }

}
