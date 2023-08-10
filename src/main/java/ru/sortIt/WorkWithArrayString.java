package ru.sortIt;

import java.util.ArrayList;
import java.util.List;

public class WorkWithArrayString {

    public String[] combineMassOut(String[] arr1, String[] arr2, String[] arr3) {
        try {
            return checkNullArrays(arr1, arr2, arr3);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    public String[] reverseMass(String[] arr) {
        try {
            String[] arrayRevers = new String[arr.length];
            int j = 0;
            for (int i = (arr.length - 1); i >= 0; i--) {
                arrayRevers[j] = arr[i];
                j++;
            }
            return arrayRevers;
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    public static String[] combineMassOut() {
        try {
            return new String[0];
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    public String[] sortMass(String[] arr) {
        try {
            mergeSort(arr, 0, arr.length - 1);
            arr = deleteDuplicateArray(arr);
            return arr;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    private static void mergeSort(String[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }


    private static void merge(String[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        String[] leftArr = new String[n1];
        String[] rightArr = new String[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }


    private static String[] deleteDuplicateArray(String[] arr) {
        try {
            List<String> newList = new ArrayList<>();
            newList.add(arr[0]);

            for (int i = 1; i < arr.length; i++) {
                if (!arr[i].equals(arr[i - 1])) {
                    newList.add(arr[i]);
                }
            }

            return newList.toArray(new String[0]);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    private static String[] checkNullArrays(String[]... arrays) {
        try {
            int totalLength = 0;
            for (String[] arr : arrays) {
                if (arr != null) {
                    totalLength += arr.length;
                }
            }
            if (totalLength == 0) {
                return combineMassOut();
            }

            String[] massOut = new String[totalLength];
            int i = 0;

            for (String[] arr : arrays) {
                if (arr != null) {
                    for (String str : arr) {
                        massOut[i++] = str;
                    }
                }
            }

            return massOut;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }
}
