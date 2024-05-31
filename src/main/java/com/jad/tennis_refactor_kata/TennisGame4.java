package com.jad.tennis_refactor_kata;

interface ResultProvider {
    TennisResult getResult();
}

public class TennisGame4 implements TennisGame {

    private final String server;
    private final String receiver;
    private int serverScore;
    private int receiverScore;

    public TennisGame4(String server, String receiver) {
        this.server = server;
        this.receiver = receiver;
    }

    public String getServer() {
        return this.server;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public int getServerScore() {
        return this.serverScore;
    }

    public int getReceiverScore() {
        return this.receiverScore;
    }

    @Override
    public void wonPoint(String playerName) {
        if (this.server.equals(playerName)) {
            this.serverScore++;
        }
        if (this.receiver.equals(playerName)) {
            this.serverScore++;
        }
    }

    @Override
    public String getScore() {
        TennisResult result = new Deuce(
                this, new GameServer(
                this, new GameReceiver(
                this, new AdvantageServer(
                this, new AdvantageReceiver(
                this, new DefaultResult(this)))))).getResult();
        return result.format();
    }

    boolean receiverHasAdvantage() {
        return this.receiverScore >= 4 && (this.receiverScore - this.serverScore) == 1;
    }

    boolean serverHasAdvantage() {
        return this.serverScore >= 4 && (this.serverScore - this.receiverScore) == 1;
    }

    boolean receiverHasWon() {
        return this.receiverScore >= 4 && (this.receiverScore - this.serverScore) >= 2;
    }

    boolean serverHasWon() {
        return this.serverScore >= 4 && (this.serverScore - this.receiverScore) >= 2;
    }

    boolean isDeuce() {
        return this.serverScore >= 3 && this.receiverScore >= 3 && (this.serverScore == this.receiverScore);
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

class Deuce implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public Deuce(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (this.game.isDeuce()) {
            return new TennisResult("Deuce", "");
        }
        return this.nextResult.getResult();
    }
}

class GameServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GameServer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (this.game.serverHasWon()) {
            return new TennisResult("Win for " + this.game.getServer(), "");
        }
        return this.nextResult.getResult();
    }
}

class GameReceiver implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public GameReceiver(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (this.game.receiverHasWon()) {
            return new TennisResult("Win for " + this.game.getReceiver(), "");
        }
        return this.nextResult.getResult();
    }
}

class AdvantageServer implements ResultProvider {
    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantageServer(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (this.game.serverHasAdvantage()) {
            return new TennisResult("Advantage " + this.game.getServer(), "");
        }
        return this.nextResult.getResult();
    }
}

class AdvantageReceiver implements ResultProvider {

    private final TennisGame4 game;
    private final ResultProvider nextResult;

    public AdvantageReceiver(TennisGame4 game, ResultProvider nextResult) {
        this.game = game;
        this.nextResult = nextResult;
    }

    @Override
    public TennisResult getResult() {
        if (this.game.receiverHasAdvantage()) {
            return new TennisResult("Advantage " + this.game.getReceiver(), "");
        }
        return this.nextResult.getResult();
    }
}

class DefaultResult implements ResultProvider {

    private static final String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};

    private final TennisGame4 game;

    public DefaultResult(TennisGame4 game) {
        this.game = game;
    }

    @Override
    public TennisResult getResult() {
        return new TennisResult(DefaultResult.scores[this.game.getServerScore()],
                                DefaultResult.scores[this.game.getReceiverScore()]);
    }
}
