package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray array, MyComparator compar) {
        super(array);
        comparator = compar;
    }

    private Object[] sortByComparator(Object[] array, MyComparator compar) {
        ArrayList<Object> result = new ArrayList<>(Arrays.asList(array));
        result.sort(compar);
        return result.toArray();
    }
    @Override
    public Object[] toArray() {
        return sortByComparator(smartArray.toArray(), comparator);
    }

    @Override
    public String operationDescription() {
        return "Sorted by comparator";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
