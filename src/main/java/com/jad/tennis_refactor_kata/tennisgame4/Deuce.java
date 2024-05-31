package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

class Deuce extends TennisResultProvider {
    public Deuce(TennisGame4 game, ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    protected boolean isProvided() {
        return (this.game.getServerScore() >= 3) && (this.game.getReceiverScore() >= 3) && (this.game.getServerScore() == this.game.getReceiverScore());
    }

    @Override
    protected TennisResult provide() {
        return new TennisResult("Deuce", "");
    }
}
