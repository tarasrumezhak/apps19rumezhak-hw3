package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;
    public BaseArray(Object[] arr) {
        array = Arrays.copyOf(arr, arr.length);
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public String operationDescription() {
        return "Base array.";
    }

    @Override
    public int size() {
        return array.length;
    }
}
