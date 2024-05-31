package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

class AdvantageServer extends TennisResultProvider {
    public AdvantageServer(final TennisGame4 game, final ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    protected boolean isProvided() {
        return this.game.getServerScore() >= 4 && (this.game.getServerScore() - this.game.getReceiverScore()) == 1;
    }

    @Override
    protected TennisResult provide() {
        return new TennisResult("Advantage " + this.game.getServerName(), "");
    }
}
