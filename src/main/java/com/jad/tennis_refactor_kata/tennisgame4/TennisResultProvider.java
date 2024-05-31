package com.jad.tennis_refactor_kata.tennisgame4;

import com.jad.tennis_refactor_kata.TennisGame4;

public abstract class TennisResultProvider implements ResultProvider {
    static final int ADVANTAGE_RULE_POINTS = 4;

    private final TennisGame4 game;
    private final ResultProvider nextResult;

    TennisResultProvider(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    public static String provide(final TennisGame4 game) {
        ITennisResult result = new Deuce(
                game, new GameServer(
                game, new GameReceiver(
                game, new AdvantageServer(
                game, new AdvantageReceiver(
                game, new DefaultResult(game)))))).getResult();
        return TennisResultProvider.getFormattedResult(result);
    }

    @Override
    final public ITennisResult getResult() {
        if (this.isProvided()) {
            return this.provide();
        }
        return this.nextResult.getResult();
    }

    public static String getFormattedResult(ITennisResult result) {
        return result.format();
    }

    protected abstract boolean isProvided();

    protected abstract TennisResult provide();

    final protected int getServerScore() {
        return this.game.getServerScore();
    }

    final protected int getReceiverScore() {
        return this.game.getReceiverScore();
    }

    final protected String getServerName() {
        return this.game.getServerName();
    }

    final protected String getReceiverName() {
        return this.game.getReceiverName();
    }
}
