package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

class GameReceiver extends TennisResultProvider {
    public GameReceiver(final TennisGame4 game, final ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    protected boolean isProvided() {
        return this.game.getReceiverScore() >= 4 && (this.game.getReceiverScore() - this.game.getServerScore()) >= 2;
    }

    @Override
    protected TennisResult provide() {
        return new TennisResult("Win for " + this.game.getReceiverName(), "");
    }
}
