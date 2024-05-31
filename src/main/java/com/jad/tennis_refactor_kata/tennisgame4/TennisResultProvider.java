package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

public abstract class TennisResultProvider implements ResultProvider {
    protected final TennisGame4 game;
    private final ResultProvider nextResult;

    public TennisResultProvider(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    public static String provide(final TennisGame4 game) {
        TennisResult result = new Deuce(
                game, new GameServer(
                game, new GameReceiver(
                game, new AdvantageServer(
                game, new AdvantageReceiver(
                game, new DefaultResult(game)))))).getResult();
        return TennisResultProvider.getFormattedResult(result);
    }

    @Override
    final public TennisResult getResult() {
        if (this.isProvided()) {
            return this.provide();
        }
        return this.nextResult.getResult();
    }

    public static String getFormattedResult(TennisResult result) {
        return result.format();
    }

    protected abstract boolean isProvided();

    protected abstract TennisResult provide();
}
