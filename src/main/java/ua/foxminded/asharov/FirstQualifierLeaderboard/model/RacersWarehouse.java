package ua.foxminded.asharov.FirstQualifierLeaderboard.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class RacersWarehouse {

    private Map<String, Racer> scoreboard;

    public RacersWarehouse() {
        this.scoreboard = new LinkedHashMap<>();
    }

    public void handleAbbreviationsTxt(Stream<String> abbreviations) {
        abbreviations.forEach(a -> {
            String[] part = a.split("_");
            putRacerName(part[0], part[1]);
            putTeamName(part[0], part[2]);
        });
    }

    public void handleStartLog(Stream<String> start) {
        start.forEach((String item) -> putStartTime(item.substring(0, 3), item.substring(3)));
    }

    public void handleEndLog(Stream<String> end) {
        end.forEach(item -> putFinishTime(item.substring(0, 3), item.substring(3)));
    }

    public void fillLapTime() {
        scoreboard.entrySet().stream().forEach(a -> putLapTime(a.getKey(),
                Duration.between(a.getValue().getStartTime(), a.getValue().getFinishTime()).toMillis()));
    }

    public List<Racer> getScoreboard() {
        return new ArrayList<>(scoreboard.values());
    }

    private void putRacerName(String keyRacer, String racerName) {
        Racer member;

        scoreboard.putIfAbsent(keyRacer, new Racer());
        member = scoreboard.get(keyRacer);
        member.setRacerName(racerName);
        scoreboard.replace(keyRacer, member);
    }

    private void putTeamName(String keyRacer, String teamName) {
        Racer member;

        scoreboard.putIfAbsent(keyRacer, new Racer());
        member = scoreboard.get(keyRacer);
        member.setTeamName(teamName);
        scoreboard.replace(keyRacer, member);
    }

    private void putStartTime(String keyRacer, String startTime) {
        Racer member;

        scoreboard.putIfAbsent(keyRacer, new Racer());
        member = scoreboard.get(keyRacer);
        member.setStartTime(LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS")));
        scoreboard.replace(keyRacer, member);
    }

    private void putFinishTime(String keyRacer, String finishTime) {
        Racer member;

        scoreboard.putIfAbsent(keyRacer, new Racer());
        member = scoreboard.get(keyRacer);
        member.setFinishTime(LocalDateTime.parse(finishTime, DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS")));
        scoreboard.replace(keyRacer, member);
    }

    private void putLapTime(String keyRacer, long lapTime) {
        Racer member;

        scoreboard.putIfAbsent(keyRacer, new Racer());
        member = scoreboard.get(keyRacer);
        member.setLapTime(lapTime);
        scoreboard.replace(keyRacer, member);
    }

}
