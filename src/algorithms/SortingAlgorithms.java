package algorithms;

import structures.linked.list.MyArrayList;

public class SortingAlgorithms {

    public void bubbleSort(MyArrayList<Integer> list) {
        for (int i = 0; i < list.size()-1; i++){
            for (int j = 0; j < list.size()-2; j++) {
                int temp;
                if (list.get(j) > list.get(j + 1)) {
                    temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }


    public void insertionSort(MyArrayList<Integer> list){

    }



}
