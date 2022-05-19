package fr.robotv2.robotapi;

import java.text.DecimalFormat;

public class NumberAPI {

    private static final long THOUSAND = 1000;
    private static final long MILLION = THOUSAND * THOUSAND;
    private static final long BILLION = MILLION * THOUSAND;
    private static final long TRILLION = BILLION * THOUSAND;

    private static final String THOUSAND_PREFIX = "k";
    private static final String MILLION_PREFIX = "M";
    private static final String BILLION_PREFIX = "B";
    private static final String TRILLION_PREFIX = "T";

    private static DecimalFormat format;

    public static String formatted(Float value) {
        return formatted(value.doubleValue());
    }

    public static String formatted(Long value) {
        return formatted(value.doubleValue());
    }

    public static String formatted(Integer value) {
        return formatted(value.doubleValue());
    }


    public static String formatted(Double value) {
        if(format == null)
            format = new DecimalFormat("###,##");

        String SUFFIX;

        if(value < MILLION) {
            value = value / THOUSAND;
            SUFFIX = THOUSAND_PREFIX;
        } else if(value < BILLION) {
            value = value / MILLION;
            SUFFIX = MILLION_PREFIX;
        } else if(value < TRILLION) {
            value = value / BILLION;
            SUFFIX = BILLION_PREFIX;
        } else {
            value = value / TRILLION;
            SUFFIX = TRILLION_PREFIX;
        }
        return format.format(value) + SUFFIX;
    }
}
