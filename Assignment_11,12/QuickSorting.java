import java.util.Random;

import javax.print.event.PrintJobAdapter;

class TeacherQuickSort {
    static void quickSort(int keys[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(keys, begin, end);
    
            quickSort(keys, begin, partitionIndex-1);
            quickSort(keys, partitionIndex+1, end);
        }
    }

    static int partition(int keys[], int begin, int end) {
        int pivot = keys[end];
        int i = (begin-1);
    
        for (int j = begin; j < end; j++) {
            if (keys[j] <= pivot) {
                i++;
    
                int swapTemp = keys[i];
                keys[i] = keys[j];
                keys[j] = swapTemp;
            }
        }
    
        int swapTemp = keys[i+1];
        keys[i+1] = keys[end];
        keys[end] = swapTemp;
    
        return i+1;
    }

    static void sort(int keys[]) {
        quickSort(keys, 0, keys.length-1);
    }
}

class StudentQuickSort {
    static void quickSort(int keys[], int begin, int end) {
        // your code here
    }

    static int partition(int keys[], int begin, int end) {
        // your code here
        return keys[0]; // just a place holder, remove this
    }

    // you may add any method(s) as you see fit

    static void sort(int keys[]) {
        quickSort(keys, 0, keys.length-1);
    }
}


class QuickSorting {

    static void printArray(int arr[]) {        
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static boolean isDiffer(int arr1[], int arr2[]) {
        if(arr1.length!=arr2.length) return true;
        for(int i=0; i<arr1.length; i++) {
            if(arr1[i]!=arr2[i]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        final int N = 200000000;
        Random r = new Random(28253);
        
        int keys[] = new int[N];

        for(int i=0; i<N; i++) {
            keys[i] = (int)(r.nextGaussian()*N/2);
        }

        int keys2[] = keys.clone();
        

        long startTime = System.currentTimeMillis();
        TeacherQuickSort.sort(keys);
        long teacherTime = System.currentTimeMillis()-startTime;
        System.out.println("Teacher Sorting time: "+teacherTime);

        
        startTime = System.currentTimeMillis();
        StudentQuickSort.sort(keys2);
        long studentTime = System.currentTimeMillis()-startTime;
        System.out.println("Student Sorting time: "+studentTime);
        
        System.out.println("ratio is "+(teacherTime/(double)studentTime));
        
        startTime = System.currentTimeMillis();
        if(isDiffer(keys,keys2)) {
            System.out.println("Error: keys2 is not sorted!");
        } else {
            System.out.println("Sorting ok!");
        }
        System.out.println("Differ time: "+(System.currentTimeMillis()-startTime));

    }
}