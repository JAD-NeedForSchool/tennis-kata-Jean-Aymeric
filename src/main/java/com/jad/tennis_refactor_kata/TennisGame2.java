package com.jad.tennis_refactor_kata;


public class TennisGame2 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    public int player1Points = 0;
    public int player2Points = 0;
    public String player1Score = "";
    public String player2Score = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(this.player1Name)) {
            this.incrementPlayer1Points();
        }
        if (playerName.equals(this.player2Name)) {
            this.incrementPlayer2Points();
        }
    }

    public void incrementPlayer1Points() {
        this.player1Points++;
    }

    public void incrementPlayer2Points() {
        this.player2Points++;
    }

    public String getScore() {
        String score = "";
        if (this.player1Points == this.player2Points && this.player1Points < 4) {
            if (this.player1Points == 0) {
                score = "Love";
            }
            if (this.player1Points == 1) {
                score = "Fifteen";
            }
            if (this.player1Points == 2) {
                score = "Thirty";
            }
            score += "-All";
        }
        if (this.player1Points == this.player2Points && this.player1Points >= 3) {
            score = "Deuce";
        }

        if (this.player1Points > 0 && this.player2Points == 0) {
            if (this.player1Points == 1) {
                this.player1Score = "Fifteen";
            }
            if (this.player1Points == 2) {
                this.player1Score = "Thirty";
            }
            if (this.player1Points == 3) {
                this.player1Score = "Forty";
            }

            this.player2Score = "Love";
            score = this.player1Score + "-" + this.player2Score;
        }
        if (this.player2Points > 0 && this.player1Points == 0) {
            if (this.player2Points == 1) {
                this.player2Score = "Fifteen";
            }
            if (this.player2Points == 2) {
                this.player2Score = "Thirty";
            }
            if (this.player2Points == 3) {
                this.player2Score = "Forty";
            }

            this.player1Score = "Love";
            score = this.player1Score + "-" + this.player2Score;
        }

        if (this.player1Points > this.player2Points && this.player1Points < 4) {
            if (this.player1Points == 2) {
                this.player1Score = "Thirty";
            }
            if (this.player1Points == 3) {
                this.player1Score = "Forty";
            }
            if (this.player2Points == 1) {
                this.player2Score = "Fifteen";
            }
            if (this.player2Points == 2) {
                this.player2Score = "Thirty";
            }
            score = this.player1Score + "-" + this.player2Score;
        }
        if (this.player2Points > this.player1Points && this.player2Points < 4) {
            if (this.player2Points == 2) {
                this.player2Score = "Thirty";
            }
            if (this.player2Points == 3) {
                this.player2Score = "Forty";
            }
            if (this.player1Points == 1) {
                this.player1Score = "Fifteen";
            }
            if (this.player1Points == 2) {
                this.player1Score = "Thirty";
            }
            score = this.player1Score + "-" + this.player2Score;
        }

        if (this.player1Points > this.player2Points && this.player2Points >= 3) {
            score = "Advantage player1";
        }

        if (this.player2Points > this.player1Points && this.player1Points >= 3) {
            score = "Advantage player2";
        }

        if (this.player1Points >= 4 && this.player2Points >= 0 && (this.player1Points - this.player2Points) >= 2) {
            score = "Win for player1";
        }
        if (this.player2Points >= 4 && this.player1Points >= 0 && (this.player2Points - this.player1Points) >= 2) {
            score = "Win for player2";
        }
        return score;
    }
}