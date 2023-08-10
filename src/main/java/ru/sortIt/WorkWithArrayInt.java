package ru.sortIt;

public class WorkWithArrayInt {

    public int[] combineMassOut(int[] arr1, int[] arr2, int[] arr3) {
        try {
            return checkNullArrays(arr1, arr2, arr3);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    public int[] reverseMass(int[] arr) {
        try {
            int[] arrayRevers = new int[arr.length];
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


    public static int[] combineMassOut() {
        try {
            return new int[0];
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    public int[] sortMass(int[] arr) {
        try {
            for (int i = 0; i < arr.length; i++) {
                int num;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        num = arr[i];
                        arr[i] = arr[j];
                        arr[j] = num;
                    }
                }
            }
            arr = deleteDublicateArray(arr);
            return arr;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    private static int[] deleteDublicateArray(int[] arr) {
        try {
            int countDouble = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    countDouble++;
                }
            }

            int[] arrNew = new int[arr.length - countDouble];
            arrNew[0] = arr[0];
            int newIndex = 1;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    arrNew[newIndex] = arr[i];
                    newIndex++;
                }
            }

            return arrNew;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


    private static int[] checkNullArrays(int[]... arrays) {
        try {
            int totalLength = 0;
            for (int[] arr : arrays) {
                if (arr != null) {
                    totalLength += arr.length;
                }
            }
            if (totalLength == 0) {
                return combineMassOut();
            }

            int[] MassOut = new int[totalLength];
            int i = 0;

            for (int[] arr : arrays) {
                if (arr != null) {
                    for (int num : arr) {
                        MassOut[i++] = num;
                    }
                }
            }

            return MassOut;
        } catch (Exception e) {
            System.out.println("Ошибка: " + e + "\n");
            return null;
        }
    }


}
