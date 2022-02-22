package com.guessaword.model;

import java.util.HashMap;
import java.util.Map;

public class Player {
    String name;
    int playerId;
    Map<Integer, Integer> stats;

    public Player(String name) {
        setName(name);
    }

    // accessors for Player() class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId() {
        if (stats != null)
            this.playerId = stats.size() + 1;
        else
            this.playerId = 1;
    }

    public void setStats(int solutionsAttempts) {
        if (stats != null) {
            stats = getStats();
        } else {
            stats = new HashMap<>();
        }

        if (stats.containsKey(solutionsAttempts)) {
            stats.put(solutionsAttempts, stats.get(solutionsAttempts) + 1);
        }
        else {
            stats.put(solutionsAttempts, 1);
        }
        this.stats = stats;
    }

    public Map<Integer, Integer> getStats() {
        return stats;
    }

    @Override
    public String toString() {
        Statistics statistics = new Statistics();
        return String.format(
                "%10d%12s%10d%10d%10d%10d%10d%10d%10d%10d",
                getPlayerId(),
                getName(),
                statistics.getWins(stats),
                statistics.attemptOne(stats),
                statistics.attemptTwo(stats),
                statistics.attemptThree(stats),
                statistics.attemptFour(stats),
                statistics.attemptFive(stats),
                statistics.attemptSix(stats),
                statistics.getLosses(stats));
    }

    public static class Statistics {

        //  static nested class created to track, calculate and store Player() statistics.



        //accessors for Player.Statistics() class

        public int getLosses (Map<Integer, Integer>stats) {
            if (stats != null)
                return stats.get(7);
            else
                return 0;
        }

        public int attemptOne (Map<Integer, Integer>stats) {
            if (stats != null)
                return stats.get(1);
            else
                return 0;
        }

        public int attemptTwo (Map<Integer, Integer>stats) {
            if (stats != null)
                return stats.get(2);
            else
                return 0;
        }

        public int attemptThree (Map<Integer, Integer>stats) {
            if (stats != null)
                return stats.get(3);
            else
                return 0;
        }

        public int attemptFour (Map<Integer, Integer>stats) {
            if (stats != null)
                return stats.get(4);
            else
                return 0;
        }

        public int attemptFive (Map<Integer, Integer>stats) {
            if (stats != null)
                return stats.get(5);
            else
                return 0;
        }

        public int attemptSix (Map<Integer, Integer>stats) {
            if (stats != null)
                return stats.get(6);
            else
                return 0;
        }

        public int getWins (Map<Integer, Integer>stats) {
            if (stats != null)
                return stats.values().stream().mapToInt(Integer::intValue).sum();
            else
                return 0;
        }
    }
}