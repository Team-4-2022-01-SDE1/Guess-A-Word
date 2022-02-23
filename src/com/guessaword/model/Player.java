package com.guessaword.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Player implements Serializable {
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

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setStats(int solutionsAttempts) {
        if (stats != null) {
            stats = getStats();
        } else {
            stats = new HashMap<>();
        }

        if (stats.containsKey(solutionsAttempts)) {
            stats.put(solutionsAttempts, stats.get(solutionsAttempts) + 1);
        } else {
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

        public int attemptOne(Map<Integer, Integer> stats) {
            if (stats == null || stats.get(1) == null) {
                return 0;
            }
            return stats.get(1);
        }

        public int attemptTwo(Map<Integer, Integer> stats) {
            if (stats == null || stats.get(2) == null) {
                return 0;
            }
            return stats.get(2);
        }

        public int attemptThree(Map<Integer, Integer> stats) {
            if (stats == null || stats.get(3) == null) {
                return 0;
            }
            return stats.get(3);
        }

        public int attemptFour(Map<Integer, Integer> stats) {
            if (stats == null || stats.get(4) == null) {
                return 0;
            }
            return stats.get(4);
        }

        public int attemptFive(Map<Integer, Integer> stats) {
            if (stats == null || stats.get(5) == null) {
                return 0;
            }
            return stats.get(5);
        }

        public int attemptSix(Map<Integer, Integer> stats) {
            if (stats == null || stats.get(6) == null) {
                return 0;
            }
            return stats.get(6);
        }

        public int getLosses(Map<Integer, Integer> stats) {
            if (stats == null || stats.get(7) == null) {
                return 0;
            }
            return stats.get(7);
        }

        public int getWins(Map<Integer, Integer> stats) {
            if (stats == null || stats.get(0) == null) {
                return 0;
            }
            if (stats.size() > 0) {
                stats.put(0, stats.values().stream().mapToInt(Integer::intValue).sum());
            }
            return stats.get(0);
        }
    }
}