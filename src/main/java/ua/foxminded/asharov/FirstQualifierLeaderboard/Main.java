package ua.foxminded.asharov.FirstQualifierLeaderboard;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import ua.foxminded.asharov.FirstQualifierLeaderboard.model.RacersWarehouse;
import ua.foxminded.asharov.FirstQualifierLeaderboard.presentation.LeaderboardPrinter;

public class Main {

    public static final String ABBREVIATIONS_FILE = "/abbreviations.txt";
    public static final String START_FILE = "/start.log";
    public static final String END_FILE = "/end.log";

    public static void main(String[] args) throws IOException, URISyntaxException {
        LeaderboardPrinter leaderboardPrinter = new LeaderboardPrinter();
        RacersWarehouse racersWarehouse = new RacersWarehouse();
        Stream<String> stream;
        URL url;

        url = Main.class.getResource(ABBREVIATIONS_FILE);
        stream = Files.lines(Paths.get(url.toURI()));
        racersWarehouse.handleAbbreviationsTxt(stream);
        stream.close();

        url = Main.class.getResource(START_FILE);
        stream = Files.lines(Paths.get(url.toURI()));
        racersWarehouse.handleStartLog(stream);
        stream.close();

        url = Main.class.getResource(END_FILE);
        stream = Files.lines(Paths.get(url.toURI()));
        racersWarehouse.handleEndLog(stream);
        stream.close();

        racersWarehouse.fillLapTime();
        System.out.println(leaderboardPrinter.printLeaderboard(racersWarehouse.getScoreboard()));
    }

}
