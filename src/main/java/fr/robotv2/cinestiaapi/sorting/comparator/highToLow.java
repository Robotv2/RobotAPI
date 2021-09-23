package fr.robotv2.cinestiaapi.sorting.comparator;

import java.util.Comparator;
import java.util.Map;

public class highToLow {

    public static class HashMap implements Comparator<Map.Entry<?, Class<? extends Number>>> {

        @Override
        public int compare(Map.Entry<?, Class<? extends Number>> o1, Map.Entry<?, Class<? extends Number>> o2) {
            return o1.getValue().getModifiers();
        }

        @Override
        public Comparator<Map.Entry<?, Class<? extends Number>>> reversed() {
            return Comparator.super.reversed();
        }
    }
}
