package com.jad.tennis_refactor_kata.tennisgame4;

public class TennisResult implements ITennisResult {
    final String serverScore;
    final String receiverScore;

    TennisResult(String serverScore, String receiverScore) {
        this.serverScore = serverScore;
        this.receiverScore = receiverScore;
    }

    @Override
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
