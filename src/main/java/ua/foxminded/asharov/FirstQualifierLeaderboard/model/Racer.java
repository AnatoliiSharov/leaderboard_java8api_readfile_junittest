package ua.foxminded.asharov.FirstQualifierLeaderboard.model;

import java.time.LocalDateTime;

public class Racer {

    private String racerName;
    private String teamName;
    private LocalDateTime startTime;
    private LocalDateTime finishTime;
    private long lapTime;

    public Racer() {
        this.racerName = "";
        this.teamName = "";
        this.startTime = null;
        this.finishTime = null;
        this.lapTime = 0;
    }

    public Racer(String racerName, String teamName, long lapTime) {
        this.racerName = racerName;
        this.teamName = teamName;
        this.startTime = null;
        this.finishTime = null;
        this.lapTime = lapTime;
    }

    public Racer(String racerName, String teamName, LocalDateTime startTime, LocalDateTime finishTime, long lapTime) {
        this.racerName = racerName;
        this.teamName = teamName;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.lapTime = lapTime;
    }

    @Override
    public String toString() {
        return String.join(", ", racerName, teamName, String.valueOf(startTime), String.valueOf(finishTime),
                convertTime(lapTime));
    }

    public String convertTime(long millis) {
        return String.format("%02d:%02d.%03d", millis / 60000, (millis % 60000) / 1000, (millis % 60000) % 1000);
    }

    public String getRacerName() {
        return racerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public long getLapTime() {
        return lapTime;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    public void setLapTime(long lapTime) {
        this.lapTime = lapTime;
    }

}
