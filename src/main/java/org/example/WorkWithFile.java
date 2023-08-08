package org.example;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkWithFile {


    private File file1, file2, file3;

    public WorkWithFile() {
        OpenFile();
    }

    public WorkWithFile(String name1, String name2, String name3) {
        this.file1 = new File(name1);
        this.file2 = new File(name2);
        this.file3 = new File(name3);
        openFile(true);
    }

    public WorkWithFile(String name1, String name2) {
        this.file1 = new File(name1);
        this.file2 = new File(name2);
        openFile(true);
    }

    public WorkWithFile(String name) {
        this.file1 = new File(name);;
        openFile(true);
    }


    public void writeNameFile(String nameOne, String nameTwo, String nameThree){
        if (!nameOne.isEmpty()) {
            this.file1 = new File(nameOne);
        }
        if (!nameTwo.isEmpty()) {
            this.file2 = new File(nameTwo);
        }
        if (!nameThree.isEmpty()) {
            this.file3 = new File(nameThree);
        }
    }

    public int[][] openFile(boolean res) {
        int[] arr1;
        if(file1 != null)
            arr1 = WorkWithFile(file1);
        else
            arr1 = null;

        int[] arr2;
        if(file2 != null)
            arr2 = WorkWithFile(file2);
        else
            arr2 = null;

        int[] arr3;
        if(file3 != null)
            arr3 = WorkWithFile(file3);
        else
            arr3 = null;

        return new int[][]{arr1, arr2, arr3};
    }

    public static void OpenFile() {
        System.out.println("Не были указаны файлы");
    }

    public static int[] WorkWithFile(File file) {
        List<Integer> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int data = Integer.parseInt(line);
                dataList.add(data);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e);
        }

        int[] dataArray = new int[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            dataArray[i] = dataList.get(i);
        }
        return dataArray;
    }
}
