package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

class DefaultResult extends TennisResultProvider {

    private static final String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public DefaultResult(final TennisGame4 game) {
        super(game, null);
    }

    @Override
    protected boolean isProvided() {
        return true;
    }

    @Override
    protected TennisResult provide() {
        return new TennisResult(DefaultResult.scores[this.game.getServerScore()],
                                DefaultResult.scores[this.game.getReceiverScore()]);
    }
}
