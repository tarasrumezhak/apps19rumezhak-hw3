package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray arr) {
        super(arr);
    }

    public Object[] delRepeats(Object[] arr) {
        ArrayList<Object> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (!arr[i].equals(arr[j]) && !result.contains(arr[i])) {
                    result.add(arr[i]);
                }
            }
        }
        return result.toArray();
    }
    @Override
    public Object[] toArray() {
        return delRepeats(smartArray.toArray());
    }

    @Override
    public String operationDescription() {
        return "Deleted repeated elements" + smartArray.operationDescription();
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
