package book.introduction.to.algorithms.chapter7;

import java.util.Random;

public class QuickSort {

    public int[] generateRandomInt(int n) {
        int[] a = new int[n];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100);
        }
        return a;
    }

    public boolean isSorted(int[] a) {
        assert a != null && a.length > 1;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }

    private void sort(int[] a) {
        assert a != null && a.length > 1;
        quickSort(a, 0, a.length - 1);
    }

    private void quickSort(int[] a, int firstIdx, int lastIdx) {
        if (firstIdx < lastIdx) {
            int pivot = partition(a, firstIdx, lastIdx);
            quickSort(a, firstIdx, pivot - 1);
            quickSort(a, pivot + 1, lastIdx);
        }
    }

    private int partition(int[] a, int firstIdx, int lastIdx) {
        int pivot = a[lastIdx];
        int i = firstIdx - 1;
        for (int j = firstIdx; j <= lastIdx; j++) {
            if (a[j] <= pivot) {
                swap(a, ++i, j);
            }
        }
        return i;
    }

    private void swap(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] a = q.generateRandomInt(100);
        q.printArray(a);
        q.sort(a);
        assert q.isSorted(a);
        System.out.println(q.isSorted(a));
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
