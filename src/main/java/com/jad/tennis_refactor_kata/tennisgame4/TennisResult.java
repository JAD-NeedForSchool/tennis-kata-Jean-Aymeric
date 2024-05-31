package com.jad.tennis_refactor_kata.tennisgame4;

class TennisResult {
    String serverScore;
    String receiverScore;

    TennisResult(String serverScore, String receiverScore) {
        this.serverScore = serverScore;
        this.receiverScore = receiverScore;
    }

    public String format() {
        if ("".equals(this.receiverScore)) {
            return this.serverScore;
        }
        if (this.serverScore.equals(this.receiverScore)) {
            return this.serverScore + "-All";
        }
        return this.serverScore + "-" + this.receiverScore;
    }
}
