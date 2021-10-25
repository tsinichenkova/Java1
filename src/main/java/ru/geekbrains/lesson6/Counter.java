package ru.geekbrains.lesson6;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    private static final Map<Class<?>, Integer> sTotalCounts = new HashMap<Class<?>, Integer>();
    
    public int getTotalCount() {
        return sTotalCounts.get(this.getClass());
    }

    public Counter()
    {
        int count = 0;
        if(sTotalCounts.containsKey(this.getClass()))
        {
            count = sTotalCounts.get(this.getClass());
        }
        sTotalCounts.put(this.getClass(), ++count);
    }

}
