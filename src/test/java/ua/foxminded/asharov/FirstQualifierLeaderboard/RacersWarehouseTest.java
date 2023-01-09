package ua.foxminded.asharov.FirstQualifierLeaderboard;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ua.foxminded.asharov.FirstQualifierLeaderboard.model.Racer;
import ua.foxminded.asharov.FirstQualifierLeaderboard.model.RacersWarehouse;

@TestInstance(Lifecycle.PER_CLASS)
class RacersWarehouseTest {

    RacersWarehouse racersWarehouse;
    Racer racerDTO;
    String actual;
    String expected;
    Stream<String> inputData;

    @BeforeAll
    void initializationAll() {
        racerDTO = new Racer();
    }

    @BeforeEach
    void initializationEach() {
        racersWarehouse = new RacersWarehouse();
    }

    @Test
    void handleAbbreviationsTxt_shouldRacersWarehouseContainsRidersAndTeamsNames_whenPutFullAbbreviationsTxt() {
        inputData = Stream.of("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER", "SVF_Sebastian Vettel_FERRARI",
                "LHM_Lewis Hamilton_MERCEDES");
        expected = "Daniel Ricciardo, RED BULL RACING TAG HEUER, null, null, 00:00.000\n"
                + "Sebastian Vettel, FERRARI, null, null, 00:00.000\n"
                + "Lewis Hamilton, MERCEDES, null, null, 00:00.000";

        racersWarehouse.handleAbbreviationsTxt(inputData);
        actual = racersWarehouse.getScoreboard().stream().map(a -> a.toString()).collect(Collectors.joining("\n"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void handleStartLog_shouldRacersWarehouseContainsStartTimes_whenPutFullStartLog() {
        inputData = Stream.of("SVF2018-05-24_12:02:58.917", "LHM2018-05-24_12:18:20.125", "DRR2018-05-24_12:14:12.054");
        expected = ", , 2018-05-24T12:02:58.917, null, 00:00.000\n"
                + ", , 2018-05-24T12:18:20.125, null, 00:00.000\n"
                + ", , 2018-05-24T12:14:12.054, null, 00:00.000";

        racersWarehouse.handleStartLog(inputData);
        actual = racersWarehouse.getScoreboard().stream().map(a -> a.toString()).collect(Collectors.joining("\n"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void handleEndLog_shouldRacersWarehouseContainsEndTimes_whenPutFullEndLog() {
        inputData = Stream.of("DRR2018-05-24_12:15:24.067", "SVF2018-05-24_12:04:03.332", "LHM2018-05-24_12:19:32.585");
        expected = ", , null, 2018-05-24T12:15:24.067, 00:00.000\n"
                + ", , null, 2018-05-24T12:04:03.332, 00:00.000\n"
                + ", , null, 2018-05-24T12:19:32.585, 00:00.000";

        racersWarehouse.handleEndLog(inputData);
        actual = racersWarehouse.getScoreboard().stream().map(a -> a.toString()).collect(Collectors.joining("\n"));

        Assertions.assertEquals(expected, actual);
    }

}
