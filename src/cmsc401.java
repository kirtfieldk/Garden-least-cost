//Keith Kirtfield
import java.util.Scanner;

public class cmsc401 {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
//        Garden Array

        int sizeArray = in.nextInt();
        garden [] gardenArray = new garden[sizeArray];
        int i = 0;
        while(i < sizeArray){
            int gardenDistance = in.nextInt();
            int gardenSize = in.nextInt();
            garden garden = new garden(gardenDistance, gardenSize);
            gardenArray[i] = garden;
            i++;
        }
        sortArray(gardenArray, 0, gardenArray.length - 1);
        printArr(gardenArray);
        System.out.println(returnMid(gardenArray));
    }
//    To swap the elements
    public static void swap(garden[] array, int a, int b){
        garden dummy = array[a];
        array[a] = array[b];
        array[b] = dummy;


    }
//    For quality we must print the arr
    public static void printArr(garden[] array){
        for(garden x: array){
            System.out.println(x.getDistance() + " " + x.getSize());
        }
    }

    public static int partition(garden[] array, int begining, int end){
        garden dummy = array[end];
        int i = begining - 1;
        for(int j = begining; j <= end-1; j++){
            if(array[j].getDistance() < dummy.getDistance()){

                i++;
                swap(array, i, j);
            }
        }
        swap(array, i+1, end);

        return i+1;
    }
    public static void sortArray(garden[] array, int beginning, int end){
       if(beginning < end) {
           int partition = partition(array, beginning, end);
           sortArray(array, beginning, partition - 1);
           sortArray(array, partition + 1, end);

       }
    }
// Returns the mid with the highest garden size eaither mid, mid + 1, or mid - 1
    public static int returnMid(garden[] array){
        if(array.length == 0)
            return 0;
        int mid = array.length / 2;
        if(array[mid + 1].getSize() >= array[mid].getSize() && array[mid + 1].getSize() >= array[mid - 1].getSize() && mid + 1 != array.length - 1)
            return array[mid+1].getDistance();
        if(array[mid].getSize() >= array[mid-1].getSize())
            return array[mid].getDistance();
        if(array[mid - 1 ].getSize() >= array[mid].getSize())
            return array[mid - 1].getDistance();
        return 0;
    }

// 1 2 12 33
//10 + 4 + 2 + 0 + 18 = 34  CORRECT!!!!!
//6 + 2 + 0 + 4 + 24 = 36

//14 + 15 + 8 + 0 + 1 = 38 CORRECT!!!!
//6 + 3 + 0 + 20 + 10 = 39
}
//96 + 36 + 13 = 115
//57 + 10 + 0 + 26 = 93 INCORRECT!!!


//1 3, 15 2, 20 1, 33 2

//42 + 5 + 36 = 83
//0 + 66 + 55 = 121
//99 + 0+ 22 = 121
//0 + 1 + 88 = 89
//3 + 86 = 89 CORRECT !!

//33 + 10 + 0 + 63 = 106
//3 + 0 + 10 + 93 = 106 CORRECT!!!!!
//Created this object to hold the both data aspects of the garden
class garden{
    private int distance;
    private int size;
    public garden(int aDistance, int aSize){
        distance = aDistance;
        size = aSize;
    }
    public int getDistance(){
        return distance;
    }
    public int getSize(){
        return size;
    }
}
