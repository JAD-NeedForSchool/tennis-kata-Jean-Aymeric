package com.jad.tennis_refactor_kata;


public class TennisGame1 implements TennisGame {
    public static final int POINTS_LIMIT_BEFORE_ADVANTAGE_RULE = 3;

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
            this.pointsPlayer1++;
        }
        if (this.player2Name.equals(playerName)) {
            this.pointsPlayer2++;
        }
    }

    @Override
    public String getScore() {
        if (this.arePointsEquals()) {
            return this.getEqualScore();
        }
        if (this.isAdvantageRuleApply()) {
            return this.getAdvantageRuleScore();
        }
        return this.getNormalScore();
    }

    private boolean arePointsEquals() {
        return this.pointsPlayer1 == this.pointsPlayer2;
    }

    private String getEqualScore() {
        if (this.pointsPlayer1 < TennisGame1.POINTS_LIMIT_BEFORE_ADVANTAGE_RULE) {
            return TennisGame1.pointsToScore(this.pointsPlayer1) + "-All";
        }
        return "Deuce";
    }

    private boolean isAdvantageRuleApply() {
        return this.pointsPlayer1 > TennisGame1.POINTS_LIMIT_BEFORE_ADVANTAGE_RULE
                || this.pointsPlayer2 > TennisGame1.POINTS_LIMIT_BEFORE_ADVANTAGE_RULE;
    }

    private String getAdvantageRuleScore() {
        if (this.isOnePlayerHasAdvantage()) {
            return "Advantage " + this.getPlayerNameWhoHasMorePoints();
        }
        return "Win for " + this.getPlayerNameWhoHasMorePoints();
    }

    private String getNormalScore() {
        return TennisGame1.pointsToScore(this.pointsPlayer1)
                + "-"
                + TennisGame1.pointsToScore(this.pointsPlayer2);
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

    private boolean isOnePlayerHasAdvantage() {
        return Math.abs(this.pointsPlayer1 - this.pointsPlayer2) == 1;
    }

    private String getPlayerNameWhoHasMorePoints() {
        if (this.pointsPlayer1 > this.pointsPlayer2) {
            return this.player1Name;
        }
        return this.player2Name;
    }
}