import entity.Board;
import entity.Cell;
import processor.CellProcessor;

import java.util.Set;

public class RuleRunner {

    public Set<Cell> applyRules(Board board, CellProcessor cellProcessor) {
        Set<Cell> neighbouringCells;
        for (Cell cellFromCurrentGeneration : board.getActiveCellsOnBoard()) {
            cellProcessor.processCell(cellFromCurrentGeneration, board);
            neighbouringCells = board.findNeighbours(cellFromCurrentGeneration);
            for (Cell neighbouringCell : neighbouringCells) {
                cellProcessor.processCell(neighbouringCell, board);
            }
        }
        return board.filterDead();
    }


}
