package processor;


import enums.State;
import entity.Board;
import entity.Cell;
import rules.Rule;
import strategy.GameStrategy;

public class CellProcessor {

    private GameStrategy gameStratedy;

    public CellProcessor(GameStrategy gameStratedy) {
        this.gameStratedy = gameStratedy;
    }

    public void processCell(Cell cell, Board board) {

        if (board.getNextGenrationCell().contains(cell))
            return; // already processed
        cell = cell.createCopy();
        State nextState = cell.getState();
        cell.setState(getState(cell, board, nextState));
        board.getNextGenrationCell().add(cell);
    }

    private State getState(Cell cell, Board board, State nextState) {
        for (Rule rule : gameStratedy.getRules()) {
            nextState = rule.nextState(cell.getState(), findLiveNeighbourCount(cell, board));
            if (!cell.getState().equals(nextState)) {
                break;
            }
        }
        return nextState;
    }

    public int findLiveNeighbourCount(Cell cell, Board board) {
        int count = 0;
        for (Cell c : board.findNeighbours(cell)) {
            if (State.LIVE.equals(c.getState())) count++;
        }
        return count;
    }

}
