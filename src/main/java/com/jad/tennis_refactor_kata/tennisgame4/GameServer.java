package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

class GameServer extends TennisResultProvider {

    public GameServer(final TennisGame4 game, final ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    protected boolean isProvided() {
        return this.getServerScore() >= 4 && (this.getServerScore() - this.getReceiverScore()) >= 2;
    }

    @Override
    protected TennisResult provide() {
        return new TennisResult("Win for " + this.getServerName(), "");
    }
}
