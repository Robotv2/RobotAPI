package fr.robotv2.robotapi.misc;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListConverter<T, R> {

    public List<R> convert(List<T> values, Function<? super T, ? extends R> mapper) {
        return values.stream().map(mapper).collect(Collectors.toList());
    }

    public List<T> reverse(List<R> values, Function<? super R, ? extends T> mapper) {
        return new ListConverter<R, T>().convert(values, mapper);
    }
}
