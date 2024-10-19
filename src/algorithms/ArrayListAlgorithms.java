package algorithms;

import structures.linked.list.MyArrayList;

public class ArrayListAlgorithms {

// -------------------------- Return the second max -----------------------------------//
    public int secondMax(int[] array){
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int j : array) {
            if (j > max) {
                secondMax = max;
                max = j;
            } else if (j > secondMax && j != max) {
                secondMax = j;
            }
        }
        return secondMax;
    }


    public int secondMax(MyArrayList<Integer> array){
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) > max){
                secondMax = max;
                max = array.get(i);
            } else if (array.get(i) > secondMax && array.get(i) != max){
                secondMax = array.get(i);
            }
        }
        return secondMax;
    }


}
