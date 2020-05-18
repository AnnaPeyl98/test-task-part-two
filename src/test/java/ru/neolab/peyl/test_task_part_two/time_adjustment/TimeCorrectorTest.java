package ru.neolab.peyl.test_task_part_two.time_adjustment;

import org.junit.Before;
import org.junit.Test;
import ru.neolab.peyl.test_tasks_part_two.time_adjustment.TimeCorrector;
import ru.neolab.peyl.test_tasks_part_two.time_adjustment.TimeCorrectorException;

import static org.junit.Assert.assertEquals;

public class TimeCorrectorTest {
    private TimeCorrector timeCorrector;

    @Before
    public void init(){
        timeCorrector = new TimeCorrector();
    }

    @Test
    public void testCorrectTime() throws TimeCorrectorException {
        String expectedTime = "09:10:01";
        String inputTime = "09:10:01";
        String actualTime = timeCorrector.correctTime(inputTime);

        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMoreMinutes() throws TimeCorrectorException {
        String expectedTime = "12:10:10";
        String inputTime = "11:70:10";
        String actualTime = timeCorrector.correctTime(inputTime);

        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMoreMinutesAndSeconds() throws TimeCorrectorException {
        String expectedTime = "20:40:39";
        String inputTime = "19:99:99";
        String actualTime = timeCorrector.correctTime(inputTime);

        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMoreHours() throws TimeCorrectorException {
        String expectedTime = "00:01:01";
        String inputTime = "24:01:01";
        String actualTime = timeCorrector.correctTime(inputTime);

        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMoreMinutesSecondsAndHours() throws TimeCorrectorException {
        String expectedTime = "01:11:24";
        String inputTime = "24:70:84";
        String actualTime = timeCorrector.correctTime(inputTime);

        assertEquals(expectedTime, actualTime);
    }

    @Test(expected = TimeCorrectorException.class)
    public void testNullString() throws TimeCorrectorException {
        String inputTime = null;
        timeCorrector.correctTime(inputTime);
    }

    @Test(expected = TimeCorrectorException.class)
    public void testEmptyString() throws TimeCorrectorException {
        String inputTime = "";
        timeCorrector.correctTime(inputTime);
    }

    @Test(expected = TimeCorrectorException.class)
    public void testMoreThreeElementsInTime() throws TimeCorrectorException {
        String inputTime = "59:78:56:78";
        timeCorrector.correctTime(inputTime);
    }

    @Test(expected = TimeCorrectorException.class)
    public void testLessThreeElementsInTime() throws TimeCorrectorException {
        String inputTime = "59:78";
        timeCorrector.correctTime(inputTime);
    }

    @Test(expected = TimeCorrectorException.class)
    public void testStringInTime() throws TimeCorrectorException {
        String inputTime = "hello:78:56";
        timeCorrector.correctTime(inputTime);
    }

    @Test(expected = TimeCorrectorException.class)
    public void testBadDelimeter() throws TimeCorrectorException {
        String inputTime = "84;76;98";
        timeCorrector.correctTime(inputTime);
    }

    @Test(expected = TimeCorrectorException.class)
    public void testNegativeNumbers() throws TimeCorrectorException {
        String inputTime = "-84:76:-98";
        timeCorrector.correctTime(inputTime);
    }

    @Test(expected = TimeCorrectorException.class)
    public void testNotIntegerNumbers() throws TimeCorrectorException {
        String inputTime = "84:76.5:98";
        timeCorrector.correctTime(inputTime);
    }

    @Test
    public void testAllZeroInTime() throws TimeCorrectorException {
        String expectedTime = "00:00:00";
        String inputTime = "00:00:00";
        String actualTime = timeCorrector.correctTime(inputTime);

        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void testMoreThatTwoDigit() throws TimeCorrectorException {
        String expectedTime = "07:14:07";
        String inputTime = "1895:478:967";
        String actualTime = timeCorrector.correctTime(inputTime);

        assertEquals(expectedTime, actualTime);
    }



}
