package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

class Deuce extends TennisResultProvider {
    public Deuce(TennisGame4 game, ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    protected boolean isProvided() {
        return (this.getServerScore() >= TennisResultProvider.ADVANTAGE_RULE_POINTS - 1)
                && (this.getReceiverScore() >= TennisResultProvider.ADVANTAGE_RULE_POINTS - 1)
                && (this.getServerScore() == this.getReceiverScore());
    }

    @Override
    protected TennisResult provide() {
        return new TennisResult("Deuce", "");
    }
}
