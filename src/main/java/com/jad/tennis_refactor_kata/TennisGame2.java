package com.jad.tennis_refactor_kata;


public class TennisGame2 implements TennisGame {
    public static final String ADVANTAGE_TEXT = "Advantage";
    public static final String WIN_TEXT = "Win for";

    private final String player1Name;
    private final String player2Name;
    private int player1Points = 0;
    private int player2Points = 0;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            this.player1Points++;
        }
        if (playerName.equals(this.player2Name)) {
            this.player2Points++;
        }
    }

    public String getScore() {
        if (this.isPlayersPointsEqual()) {
            return this.getEqualScore();
        }
        if (this.isAPlayerWinner()) {
            return TennisGame2.WIN_TEXT + " " + this.getPlayerNameWhoHasMorePoints();
        }
        if (this.doesAPlayerHaveAdvantage()) {
            return TennisGame2.ADVANTAGE_TEXT + " " + this.getPlayerNameWhoHasMorePoints();
        }
        return PointsScore.getPlayerScoreFromPoints(this.player1Points)
                + "-"
                + PointsScore.getPlayerScoreFromPoints(this.player2Points);
    }

    private boolean isPlayersPointsEqual() {
        return this.player1Points == this.player2Points;
    }

    private String getEqualScore() {
        String score = PointsScore.getPlayerScoreFromPoints(this.player1Points) + "-All";
        if (this.player1Points >= 3) {
            score = "Deuce";
        }
        return score;
    }

    private boolean isAPlayerWinner() {
        return (this.player1Points >= 4 || this.player2Points >= 4)
                && Math.abs(this.player1Points - this.player2Points) >= 2;
    }

    private String getPlayerNameWhoHasMorePoints() {
        if (this.player1Points > this.player2Points) {
            return this.player1Name;
        }
        return this.player2Name;
    }

    private boolean doesAPlayerHaveAdvantage() {
        return (this.player1Points != this.player2Points) && (this.player1Points > 3 || (this.player2Points > 3));
    }

    enum PointsScore {
        LOVE(0, "Love"),
        FIFTEEN(1, "Fifteen"),
        THIRTY(2, "Thirty"),
        FORTY(3, "Forty"),
        OTHER(4, "");

        private final int points;
        private final String score;

        PointsScore(final int points, final String score) {
            this.points = points;
            this.score = score;
        }

        private static String getPlayerScoreFromPoints(int playerPoints) {
            for (PointsScore pointsScore : PointsScore.values()) {
                if (pointsScore.points == playerPoints) {
                    return pointsScore.score;
                }
            }
            return PointsScore.OTHER.score;
        }
    }
}