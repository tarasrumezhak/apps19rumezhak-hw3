package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicat;
    public FilterDecorator(SmartArray arr, MyPredicate pred) {
        super(arr);
        this.predicat = pred;
    }

    private Object[] satisfyPredicat(Object[] arr, MyPredicate pred) {
        ArrayList<Object> result = new ArrayList<>();
        for (Object o : arr) {
            if (pred.test(o)) {
                result.add(o);
            }
        }
        return result.toArray();
    }
    @Override
    public Object[] toArray() {
        return satisfyPredicat(smartArray.toArray(), predicat);
    }

    @Override
    public String operationDescription() {
        return "Only satisfying elements left";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
