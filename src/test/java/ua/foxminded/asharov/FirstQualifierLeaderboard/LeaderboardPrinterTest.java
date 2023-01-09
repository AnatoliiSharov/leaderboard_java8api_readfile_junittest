package ua.foxminded.asharov.FirstQualifierLeaderboard;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ua.foxminded.asharov.FirstQualifierLeaderboard.model.Racer;
import ua.foxminded.asharov.FirstQualifierLeaderboard.presentation.LeaderboardPrinter;

@TestInstance(Lifecycle.PER_CLASS)
class LeaderboardPrinterTest {

    private LeaderboardPrinter leaderboardPrinter;
    private String actual;
    private String expected;

    @BeforeAll
    void initialization() {
        leaderboardPrinter = new LeaderboardPrinter();
    }

    @Test
    void printLeaderboard_shouldExpectationArrangByLapTime_whenDiferentLapTime() {
        List<Racer> sb = Arrays.asList(new Racer("nameRacer_1", "nameTeam_1", (long) 61001),
                new Racer("nameRacer_2", "nameTeam_2", (long) 61003),
                new Racer("nameRacer_3", "nameTeam_3", (long) 61002),
                new Racer("nameRacer_4", "nameTeam_4", (long) 61005),
                new Racer("nameRacer_5", "nameTeam_5", (long) 61006),
                new Racer("nameRacer_6", "nameTeam_6", (long) 61007),
                new Racer("nameRacer_7", "nameTeam_7", (long) 61009),
                new Racer("nameRacer_8", "nameTeam_8", (long) 61008),
                new Racer("nameRacer_9", "nameTeam_9", (long) 61011),
                new Racer("nameRacer10", "nameTeam10", (long) 61010),
                new Racer("nameRacer11", "nameTeam11", (long) 61004),
                new Racer("nameRacer12", "nameTeam12", (long) 61019),
                new Racer("nameRacer13", "nameTeam13", (long) 61018),
                new Racer("nameRacer14", "nameTeam14", (long) 61017),
                new Racer("nameRacer15", "nameTeam15", (long) 61016),
                new Racer("nameRacer16", "nameTeam16", (long) 61015),
                new Racer("nameRacer17", "nameTeam17", (long) 61014),
                new Racer("nameRacer18", "nameTeam18", (long) 61013),
                new Racer("nameRacer19", "nameTeam19", (long) 61012));

        actual = leaderboardPrinter.printLeaderboard(sb);
        expected = "1. nameRacer_1 |nameTeam_1|01:01.001\n" + "2. nameRacer_3 |nameTeam_3|01:01.002\n"
                + "3. nameRacer_2 |nameTeam_2|01:01.003\n" + "4. nameRacer11 |nameTeam11|01:01.004\n"
                + "5. nameRacer_4 |nameTeam_4|01:01.005\n" + "6. nameRacer_5 |nameTeam_5|01:01.006\n"
                + "7. nameRacer_6 |nameTeam_6|01:01.007\n" + "8. nameRacer_8 |nameTeam_8|01:01.008\n"
                + "9. nameRacer_7 |nameTeam_7|01:01.009\n" + "10. nameRacer10|nameTeam10|01:01.010\n"
                + "11. nameRacer_9|nameTeam_9|01:01.011\n" + "12. nameRacer19|nameTeam19|01:01.012\n"
                + "13. nameRacer18|nameTeam18|01:01.013\n" + "14. nameRacer17|nameTeam17|01:01.014\n"
                + "15. nameRacer16|nameTeam16|01:01.015\n" + "------------------------------------\n"
                + "16. nameRacer15|nameTeam15|01:01.016\n" + "17. nameRacer14|nameTeam14|01:01.017\n"
                + "18. nameRacer13|nameTeam13|01:01.018\n" + "19. nameRacer12|nameTeam12|01:01.019";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printLeaderboard_shouldExpectationSwellsNameTeamsColumn_whenDiferentSizeNameTeams() {
        List<Racer> sb = Arrays.asList(new Racer("nameRacer_1", "nameTeam_1", (long) 61001),
                new Racer("nameRacer_2", "nameTeam_2nameTeam_2", (long) 61003),
                new Racer("nameRacer_3", "nameTeam_3", (long) 61002),
                new Racer("nameRacer_4", "nameTeam_4", (long) 61005),
                new Racer("nameRacer_5", "nameTeam_5", (long) 61006),
                new Racer("nameRacer_6", "nameTeam_6", (long) 61007),
                new Racer("nameRacer_7", "nameTeam_7", (long) 61009),
                new Racer("nameRacer_8", "nameTeam_8", (long) 61008),
                new Racer("nameRacer_9", "nameTeam_9", (long) 61011),
                new Racer("nameRacer10", "nameTeam10", (long) 61010),
                new Racer("nameRacer11", "nameTeam11", (long) 61004),
                new Racer("nameRacer12", "nameTeam12", (long) 61019),
                new Racer("nameRacer13", "nameTeam13", (long) 61018),
                new Racer("nameRacer14", "nameTeam14", (long) 61017),
                new Racer("nameRacer15", "nameTeam15", (long) 61016),
                new Racer("nameRacer16", "nameTeam16", (long) 61015),
                new Racer("nameRacer17", "nameTeam17", (long) 61014),
                new Racer("nameRacer18", "nameTeam18", (long) 61013),
                new Racer("nameRacer19", "nameTeam19", (long) 61012));

        actual = leaderboardPrinter.printLeaderboard(sb);
        expected = "1. nameRacer_1 |nameTeam_1          |01:01.001\n"
                + "2. nameRacer_3 |nameTeam_3          |01:01.002\n"
                + "3. nameRacer_2 |nameTeam_2nameTeam_2|01:01.003\n"
                + "4. nameRacer11 |nameTeam11          |01:01.004\n"
                + "5. nameRacer_4 |nameTeam_4          |01:01.005\n"
                + "6. nameRacer_5 |nameTeam_5          |01:01.006\n"
                + "7. nameRacer_6 |nameTeam_6          |01:01.007\n"
                + "8. nameRacer_8 |nameTeam_8          |01:01.008\n"
                + "9. nameRacer_7 |nameTeam_7          |01:01.009\n"
                + "10. nameRacer10|nameTeam10          |01:01.010\n"
                + "11. nameRacer_9|nameTeam_9          |01:01.011\n"
                + "12. nameRacer19|nameTeam19          |01:01.012\n"
                + "13. nameRacer18|nameTeam18          |01:01.013\n"
                + "14. nameRacer17|nameTeam17          |01:01.014\n"
                + "15. nameRacer16|nameTeam16          |01:01.015\n"
                + "----------------------------------------------\n"
                + "16. nameRacer15|nameTeam15          |01:01.016\n"
                + "17. nameRacer14|nameTeam14          |01:01.017\n"
                + "18. nameRacer13|nameTeam13          |01:01.018\n" + "19. nameRacer12|nameTeam12          |01:01.019";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printLeaderboard_shouldExpectationSwellsNameRacersColumn_whenDiferentSizeNameRacers() {
        List<Racer> sb = Arrays.asList(new Racer("nameRacer_1", "nameTeam_1", (long) 61001),
                new Racer("nameRacer_2nameRacer_2", "nameTeam_2", (long) 61003),
                new Racer("nameRacer_3", "nameTeam_3", (long) 61002),
                new Racer("nameRacer_4", "nameTeam_4", (long) 61005),
                new Racer("nameRacer_5", "nameTeam_5", (long) 61006),
                new Racer("nameRacer_6", "nameTeam_6", (long) 61007),
                new Racer("nameRacer_7", "nameTeam_7", (long) 61009),
                new Racer("nameRacer_8", "nameTeam_8", (long) 61008),
                new Racer("nameRacer_9", "nameTeam_9", (long) 61011),
                new Racer("nameRacer10", "nameTeam10", (long) 61010),
                new Racer("nameRacer11", "nameTeam11", (long) 61004),
                new Racer("nameRacer12", "nameTeam12", (long) 61019),
                new Racer("nameRacer13", "nameTeam13", (long) 61018),
                new Racer("nameRacer14", "nameTeam14", (long) 61017),
                new Racer("nameRacer15", "nameTeam15", (long) 61016),
                new Racer("nameRacer16", "nameTeam16", (long) 61015),
                new Racer("nameRacer17", "nameTeam17", (long) 61014),
                new Racer("nameRacer18", "nameTeam18", (long) 61013),
                new Racer("nameRacer19", "nameTeam19", (long) 61012));

        actual = leaderboardPrinter.printLeaderboard(sb);
        expected = "1. nameRacer_1           |nameTeam_1|01:01.001\n"
                + "2. nameRacer_3           |nameTeam_3|01:01.002\n"
                + "3. nameRacer_2nameRacer_2|nameTeam_2|01:01.003\n"
                + "4. nameRacer11           |nameTeam11|01:01.004\n"
                + "5. nameRacer_4           |nameTeam_4|01:01.005\n"
                + "6. nameRacer_5           |nameTeam_5|01:01.006\n"
                + "7. nameRacer_6           |nameTeam_6|01:01.007\n"
                + "8. nameRacer_8           |nameTeam_8|01:01.008\n"
                + "9. nameRacer_7           |nameTeam_7|01:01.009\n"
                + "10. nameRacer10          |nameTeam10|01:01.010\n"
                + "11. nameRacer_9          |nameTeam_9|01:01.011\n"
                + "12. nameRacer19          |nameTeam19|01:01.012\n"
                + "13. nameRacer18          |nameTeam18|01:01.013\n"
                + "14. nameRacer17          |nameTeam17|01:01.014\n"
                + "15. nameRacer16          |nameTeam16|01:01.015\n"
                + "----------------------------------------------\n"
                + "16. nameRacer15          |nameTeam15|01:01.016\n"
                + "17. nameRacer14          |nameTeam14|01:01.017\n"
                + "18. nameRacer13          |nameTeam13|01:01.018\n" + "19. nameRacer12          |nameTeam12|01:01.019";

        Assertions.assertEquals(expected, actual);
    }

}
