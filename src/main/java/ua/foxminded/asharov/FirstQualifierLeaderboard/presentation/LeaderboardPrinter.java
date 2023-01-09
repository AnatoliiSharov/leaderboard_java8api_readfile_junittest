package ua.foxminded.asharov.FirstQualifierLeaderboard.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import ua.foxminded.asharov.FirstQualifierLeaderboard.model.Racer;

public class LeaderboardPrinter {
    
    public static final int DIVIDIN_LINE_POSITION = 15;
    public static final int RANK_ADDITION_INTERVAL = 4;

    public String printLeaderboard(List<Racer> sb) {
        sb = sortedLapTime(sb);
        addRankFirstColum(sb);

        return String.join("\n", makeLeaderboard(sb, DIVIDIN_LINE_POSITION, RANK_ADDITION_INTERVAL));
    }

    private void addRankFirstColum(List<Racer> sb) {
        int rank = 0;

        for (Racer racer : sb) {
            rank++;
            racer.setRacerName(String.join(". ", String.valueOf(rank), racer.getRacerName()));
        }

    }

    private List<String> makeLeaderboard(List<Racer> sb, int DIVIDIN_LINE_POSITION, int RANK_ADDITION_INTERVAL) {
        List<String> leaderboard = new ArrayList<>();
        int rank = 1;

        for (Racer racer : sb) {
            leaderboard
                    .add(String.join("|", createColumCell(racer.getRacerName(), findMaxFirstColum(sb, RANK_ADDITION_INTERVAL)),
                            createColumCell(racer.getTeamName(), findMaxSecondColum(sb, RANK_ADDITION_INTERVAL)),
                            racer.convertTime(racer.getLapTime())));

            if (rank == DIVIDIN_LINE_POSITION) {
                leaderboard.add(String.join("", Collections.nCopies(leaderboard.get(0).length(), "-")));
            }
            rank++;
        }
        return leaderboard;
    }

    private int findMaxSecondColum(List<Racer> sb, int RANK_ADDITION_INTERVAL) {
        return sb.stream().map(a -> a.getTeamName().length()).max(Integer::compare).orElse(RANK_ADDITION_INTERVAL);
    }

    private int findMaxFirstColum(List<Racer> sb, int RANK_ADDITION_INTERVAL) {
        return sb.stream().map(a -> a.getRacerName().length()).max(Integer::compare).orElse(RANK_ADDITION_INTERVAL);
    }

    private List<Racer> sortedLapTime(List<Racer> sb) {
        return sb.stream().sorted((a, b) -> Long.compare(a.getLapTime(), b.getLapTime()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private String createColumCell(String data, int lengthMaxData) {
        return data + String.join("", Collections.nCopies(lengthMaxData - data.length(), " "));
    }

}
