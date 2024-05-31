package com.jad.tennis_refactor_kata;

import com.jad.tennis_refactor_kata.tennisgame4.TennisResultProvider;

public class TennisGame4 implements TennisGame {
    private final String serverName;
    private final String receiverName;
    private int serverScore;
    private int receiverScore;

    public TennisGame4(String serverName, String receiverName) {
        this.serverName = serverName;
        this.receiverName = receiverName;
    }

    @Override
    public void wonPoint(String playerName) {
        if (this.serverName.equals(playerName)) {
            this.serverScore++;
        }
        if (this.receiverName.equals(playerName)) {
            this.receiverScore++;
        }
    }

    @Override
    public String getScore() {
        return TennisResultProvider.provide(this);
    }

    public int getServerScore() {
        return this.serverScore;
    }

    public int getReceiverScore() {
        return this.receiverScore;
    }

    public String getServerName() {
        return this.serverName;
    }

    public String getReceiverName() {
        return this.receiverName;
    }
}

