package ru.neolab.peyl.test_tasks_part_two.time_adjustment;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Class for correcting time
 */
public class TimeCorrector {

    private static final int[] WHOLE_PART_ELEMENTS = {24, 60, 60};
    private static final int COUNT_TIME_ELEMENTS = 3;
    private static final String DELIMETER = ":";

    /**
     * Method convert elements time from string in integer elements time in array
     *
     * @param time - time in string
     * @return array with elements time
     * @throws TimeCorrectorException - If will be  problems:
     *                                1. Delimeter int string not ":";
     *                                2. Count elements in string more or less that 3;
     *                                3. Element in string not integer;
     *                                4. Element in string - negative integer.
     */
    private static int[] getArrayElementsTime(final String time) throws TimeCorrectorException {
        int[] timeElementsInteger;

        try {
            timeElementsInteger = Stream.of(time)
                    .flatMapToInt(element -> Arrays.stream(element.split(DELIMETER))
                            .mapToInt(Integer::parseInt))
                    .filter(element -> element >= 0)
                    .toArray();
        } catch (NumberFormatException e) {
            throw new TimeCorrectorException("Time element is not integer", e);
        }

        if (timeElementsInteger.length != 3) {
            throw new TimeCorrectorException("Count time elements is not 3");
        }

        return timeElementsInteger;
    }

    /**
     * Method corrected time in format HH:mm:ss. Can pass numbers more that 99
     *
     * @param time - time in string
     * @return correct time
     * @throws TimeCorrectorException if was trouble with checking or string null or empty
     */
    public String correctTime(final String time) throws TimeCorrectorException {

        if (time == null || "".equals(time)) {
            throw new TimeCorrectorException("Input string is null or empty");
        }

        int[] timeElementsInteger = getArrayElementsTime(time);

        for (int i = COUNT_TIME_ELEMENTS - 1; i >= 0; i--) {
            int countNextTimeElement = timeElementsInteger[i] / WHOLE_PART_ELEMENTS[i];
            timeElementsInteger[i] = timeElementsInteger[i] % WHOLE_PART_ELEMENTS[i];
            if (i != 0) {
                timeElementsInteger[i - 1] += countNextTimeElement;
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return LocalTime.of(timeElementsInteger[0], timeElementsInteger[1], timeElementsInteger[2]).format(formatter);

    }
}
