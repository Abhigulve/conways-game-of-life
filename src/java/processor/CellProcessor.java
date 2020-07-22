package processor;


import enums.State;
import entity.Board;
import entity.Cell;
import rules.Rule;
import strategy.GameStrategy;

public class CellProcessor {

//    private final GameStrategy gameStrategy;
//
//    public CellProcessor(GameStrategy gameStrategy) {
//        this.gameStrategy = gameStrategy;
//    }
//
//    public void processCell(Cell cell, Board board) {
//
//        if (board.getNextGenerationCell().contains(cell))
//            return; // already processed
//        cell = cell.createCopy();
//        State nextState = cell.getState();
//        cell.setState(getState(cell, board, nextState));
//        board.getNextGenerationCell().add(cell);
//    }
//
//    private State getState(Cell cell, Board board, State nextState) {
//        for (Rule rule : gameStrategy.getRules()) {
//            nextState = rule.nextState(cell.getState(), findLiveNeighbourCount(cell, board));
//            if (!cell.getState().equals(nextState)) {
//                break;
//            }
//        }
//        return nextState;
//    }
//
//    public int findLiveNeighbourCount(Cell cell, Board board) {
//        int count = 0;
//        for (Cell c : board.findNeighbours(cell)) {
//            if (State.LIVE.equals(c.getState())) count++;
//        }
//        return count;
//    }

}
