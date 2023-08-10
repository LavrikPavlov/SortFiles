package ru.sortIt;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class WorkWithFile {


    private File file1, file2, file3;
    private final String path = new File(SortFiles.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent() + "//";


    public WorkWithFile(String name1, String name2, String name3) {
        if (name1 != null && name2 != null && name3 != null) {
            initializeFiles(name1, name2, name3);
        }

        if (name1 == null && name2 == null && name3 == null) {
            openFile();
        } else if (name2 == null && name3 == null) {
            initializeFiles(name1);
            openFile();
        } else if (name3 == null) {
            initializeFiles(name1, name2);
            openFile();
        }
    }


    private void initializeFiles(String name1, String name2, String name3) {
        this.file1 = new File(path + name1);
        this.file2 = new File(path + name2);
        this.file3 = new File(path + name3);
    }


    private void initializeFiles(String name1, String name2) {
        this.file1 = new File(path + name1);
        this.file2 = new File(path + name2);
    }


    private void initializeFiles(String name1) {
        this.file1 = new File(path + name1);
    }


    public void writeInFile(int[] arr, String nameFile) {
        File fileOut = new File(path + nameFile);
        try {
            if (!fileOut.exists()) {
                fileOut.createNewFile();
            }

            FileWriter fw = new FileWriter(path + nameFile);
            if (arr != null) {
                for (int num : arr)
                    fw.write(num + "\n");
            } else
                fw.write("null");
            fw.close();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            int[] arrEx = new int[]{0};
            writeInFile(arrEx, path + "outEx.txt");
        }
    }


    protected int[][] openFile() {
        int[] arr1;
        if (file1 != null)
            arr1 = workWithFileInt(file1);
        else
            arr1 = null;

        int[] arr2;
        if (file2 != null)
            arr2 = workWithFileInt(file2);
        else
            arr2 = null;

        int[] arr3;
        if (file3 != null)
            arr3 = workWithFileInt(file3);
        else
            arr3 = null;

        return new int[][]{arr1, arr2, arr3};
    }


    private static int[] workWithFileInt(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<String> lines = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                if (!isNumeric(line)) {
                    String[] numbAndString = splitString(line);
                    if (!numbAndString[0].isEmpty())
                        lines.add(numbAndString[0]);
                } else
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


    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    private static String[] splitString(String s) {
        String numbers = "", letters = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i)) || (s.charAt(i) == '-' && numbers.isEmpty()))
                numbers += s.charAt(i);
            else
                letters += s.charAt(i);
            i++;
        }
        return new String[]{numbers, letters};
    }
}

