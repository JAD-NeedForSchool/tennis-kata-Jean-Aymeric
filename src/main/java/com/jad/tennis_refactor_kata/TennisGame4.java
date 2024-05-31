package com.jad.tennis_refactor_kata;

interface ResultProvider {
    TennisResult getResult();
}

public class TennisGame4 implements TennisGame {

    private final String serverName;
    private final String receiverName;
    private int serverScore;
    private int receiverScore;

    public TennisGame4(String serverName, String receiverName) {
        this.serverName = serverName;
        this.receiverName = receiverName;
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

    @java.lang.Override
    public void wonPoint(String playerName) {
        if (this.serverName.equals(playerName)) {
            this.serverScore++;
        }
        if (this.receiverName.equals(playerName)) {
            this.receiverScore++;
        }
    }

    @java.lang.Override
    public String getScore() {
        TennisResult result = new Deuce(
                this, new GameServer(
                this, new GameReceiver(
                this, new AdvantageServer(
                this, new AdvantageReceiver(
                this, new DefaultResult(this)))))).getResult();
        return result.format();
    }
}

class TennisResult {
    String serverScore;
    String receiverScore;

    TennisResult(String serverScore, String receiverScore) {
        this.serverScore = serverScore;
        this.receiverScore = receiverScore;
    }

    String format() {
        if ("".equals(this.receiverScore)) {
            return this.serverScore;
        }
        if (this.serverScore.equals(this.receiverScore)) {
            return this.serverScore + "-All";
        }
        return this.serverScore + "-" + this.receiverScore;
    }
}

abstract class AbstractResultProvider implements ResultProvider {
    protected final TennisGame4 game;
    protected final ResultProvider nextResult;

    public AbstractResultProvider(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }
}

class Deuce extends AbstractResultProvider {

    public Deuce(TennisGame4 game, ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    public TennisResult getResult() {
        if (this.isDeuce()) {
            return new TennisResult("Deuce", "");
        }
        return this.nextResult.getResult();
    }

    boolean isDeuce() {
        return (this.game.getServerScore() >= 3) && (this.game.getReceiverScore() >= 3) && (this.game.getServerScore() == this.game.getReceiverScore());
    }
}

class GameServer extends AbstractResultProvider {

    public GameServer(final TennisGame4 game, final ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    public TennisResult getResult() {
        if (this.isServerGameWinner()) {
            return new TennisResult("Win for " + this.game.getServerName(), "");
        }
        return this.nextResult.getResult();
    }

    private boolean isServerGameWinner() {
        return this.game.getServerScore() >= 4 && (this.game.getServerScore() - this.game.getReceiverScore()) >= 2;
    }
}

class GameReceiver extends AbstractResultProvider {
    public GameReceiver(final TennisGame4 game, final ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    public TennisResult getResult() {
        if (this.isServerGameWinner()) {
            return new TennisResult("Win for " + this.game.getReceiverName(), "");
        }
        return this.nextResult.getResult();
    }

    private boolean isServerGameWinner() {
        return this.game.getReceiverScore() >= 4 && (this.game.getReceiverScore() - this.game.getServerScore()) >= 2;
    }
}

class AdvantageServer extends AbstractResultProvider {
    public AdvantageServer(final TennisGame4 game, final ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    public TennisResult getResult() {
        if (this.doesServerHaveAdvantage()) {
            return new TennisResult("Advantage " + this.game.getServerName(), "");
        }
        return this.nextResult.getResult();
    }

    private boolean doesServerHaveAdvantage() {
        return this.game.getServerScore() >= 4 && (this.game.getServerScore() - this.game.getReceiverScore()) == 1;
    }
}

class AdvantageReceiver extends AbstractResultProvider {
    public AdvantageReceiver(final TennisGame4 game, final ResultProvider nextResult) {
        super(game, nextResult);
    }

    @Override
    public TennisResult getResult() {
        if (this.doesReceiverHaveAdvantage()) {
            return new TennisResult("Advantage " + this.game.getReceiverName(), "");
        }
        return this.nextResult.getResult();
    }

    private boolean doesReceiverHaveAdvantage() {
        return this.game.getReceiverScore() >= 4 && (this.game.getReceiverScore() - this.game.getServerScore()) == 1;
    }
}

class DefaultResult extends AbstractResultProvider {

    private static final String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    public DefaultResult(final TennisGame4 game) {
        super(game, null);
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult(DefaultResult.scores[this.game.getServerScore()],
                                DefaultResult.scores[this.game.getReceiverScore()]);
    }
}
