package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private MyFunction function;

    public MapDecorator(SmartArray array, MyFunction function) {
        super(array);
        this.function = function;
    }

    private Object[] mapElements(Object[] array, MyFunction function) {
        ArrayList<Object> result = new ArrayList<>();
        for (Object o: array) {
            result.add(function.apply(o));
        }
        return result.toArray();
    }

    @Override
    public Object[] toArray() {
        return mapElements(smartArray.toArray(), function);
    }

    @Override
    public String operationDescription() {
        return "Applied function to all elements";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }
}
