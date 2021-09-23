package fr.robotv2.cinestiaapi.sorting;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingAPI {

    public static class StringAPI {

        public List<String> sort(List<String> list) {
            Collections.sort(list);
            return list;
        }

        public List<String> inversed(List<String> list) {
            List<String> result = new LinkedList<>();
            Collections.sort(list);
            for(int i = 0; i < list.size() - 1; i++) {
                result.add(list.get(list.size() - 1 - i));
            }
            return result;
        }
    }

    public static class IntegerAPI {
    }

    public static class DoubleAPI {
    }

    public static class FloatAPI {
    }

    public static class LongAPI {
    }

    public static class HashMapAPI<T> {
    }
}
