package com.jad.tennis_refactor_kata;


public class TennisGame1 implements TennisGame {

    private final String player1Name;
    private final String player2Name;
    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (this.player1Name.equals(playerName)) {
            this.pointsPlayer1 += 1;
        }
        if (this.player2Name.equals(playerName)) {
            this.pointsPlayer2 += 1;
        }
    }

    @Override
    public String getScore() {
        if (this.pointsPlayer1 == this.pointsPlayer2) {
            return this.getEqualScore();
        }
        if (this.pointsPlayer1 > 3 || this.pointsPlayer2 > 3) {
            return this.getAbove40Score();
        }
        return this.getLessThan40Score();
    }

    private String getEqualScore() {
        if (this.pointsPlayer1 < 3) {
            return TennisGame1.pointsToScore(this.pointsPlayer1) + "-All";
        }
        return "Deuce";
    }

    private String getAbove40Score() {
        String score;
        int minusResult = this.pointsPlayer1 - this.pointsPlayer2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }

    private String getLessThan40Score() {
        String score = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = this.pointsPlayer1;
            } else {
                score += "-";
                tempScore = this.pointsPlayer2;
            }
            score += TennisGame1.pointsToScore(tempScore);
        }
        return score;
    }

    private static String pointsToScore(final int points) {
        return switch (points) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }
}