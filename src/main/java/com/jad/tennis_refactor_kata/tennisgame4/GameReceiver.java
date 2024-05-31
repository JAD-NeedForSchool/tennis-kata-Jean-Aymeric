package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

class GameReceiver extends TennisResultProvider {
    public GameReceiver(final TennisGame4 game, final ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    protected boolean isProvided() {
        return this.getReceiverScore() >= TennisResultProvider.ADVANTAGE_RULE_POINTS
                && (this.getReceiverScore() - this.getServerScore()) >= 2;
    }

    @Override
    protected TennisResult provide() {
        return new TennisResult("Win for " + this.getReceiverName(), "");
    }

}
