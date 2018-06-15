package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    int[] dynamicArray;
    int[] tempArray;

    @Override
    public String toString() {
        String arrayString = new String();
        for (int i = 0; i < dynamicArray.length; i++) {
            arrayString = arrayString + " " + String.valueOf(dynamicArray[i]);
        }
        return arrayString;
    }


    DynamicIntArray() {
        dynamicArray = new int[0];
    }


    DynamicIntArray(int length) {
        dynamicArray = new int[length];
    }

    private void incrementLengthForAdd() {
        tempArray = new int[dynamicArray.length + 1];
        for (int i = 0; i < dynamicArray.length; i++) {
            tempArray[i] = dynamicArray[i];
        }
        dynamicArray = tempArray;
    }

    private void decrementLength() {
        tempArray = new int[dynamicArray.length - 1];
    }

    void add(int element) {
        incrementLengthForAdd();
        dynamicArray[dynamicArray.length - 1] = element;
    }

    void remove(int element) {
        decrementLength();
        int tempIndex = 0;
        for (int dynamicElement : dynamicArray) {
            if (!(dynamicElement == element)) {
                tempArray[tempIndex] = dynamicElement;
                tempIndex++;
            }
        }
        dynamicArray = tempArray;
    }

    private void incrementLengthForInsert() {
        tempArray = new int[dynamicArray.length + 1];
    }


    void insert(int index, int number) {
        incrementLengthForInsert();
        int tempIndex = 0;
        int insertionIndex = Math.min(index, (tempArray.length - 1));
        for (int dynamicElement : dynamicArray) {
            tempArray[tempIndex] = dynamicElement;
            tempIndex++;
            if (tempIndex == insertionIndex) {
                tempArray[tempIndex] = number;
                tempIndex++;
            }
            dynamicArray = tempArray;
        }
    }
}