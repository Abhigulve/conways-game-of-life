import enums.State;
import entity.Board;
import entity.Cell;
import org.junit.Test;
import processor.CellProcessor;
import rules.Rule;
import rules.RuleImpl;
import strategy.GameStrategy;
import strategy.impl.DefaultGameStrategy;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;


public class RuleRunnerTest {

    @Test
    public void testRuleRunnerWithThreeLiveCells() {

        Cell cell = new Cell(1, 1, State.LIVE);
        Cell cell1 = new Cell(1, 2,  State.LIVE);
        Cell cell2 = new Cell(2, 2, State.LIVE);
        Cell cell3 = new Cell(2, 1, State.DEAD);


        Set<Cell> liveCellSet = new HashSet<>();
        liveCellSet.add(cell);
        liveCellSet.add(cell1);
        liveCellSet.add(cell2);
        liveCellSet.add(cell3);


        GameStrategy strategy = new DefaultGameStrategy(new Rule[]{new RuleImpl()});
        Board board = new Board();
        board.setActiveCellsOnBoard(liveCellSet);
        RuleRunner ruleRunner = new RuleRunner();

        Set<Cell> cells = ruleRunner.applyRules(board, new CellProcessor(strategy));
        assertEquals(4, cells.size());
    }

    @Test
    public void testRuleRunnerWithTWOLiveCells() {

        Cell cell = new Cell(1, 1, State.LIVE);
        Cell cell1 = new Cell(1, 2,  State.LIVE);


        Set<Cell> liveCellSet = new HashSet<>();
        liveCellSet.add(cell);
        liveCellSet.add(cell1);


        GameStrategy strategy = new DefaultGameStrategy(new Rule[]{new RuleImpl()});
        Board board = new Board();
        board.setActiveCellsOnBoard(liveCellSet);
        RuleRunner ruleRunner = new RuleRunner();

        Set<Cell> cells = ruleRunner.applyRules(board, new CellProcessor(strategy));
        assertEquals(0, cells.size());
    }

    @Test
    public void testRuleRunnerWithThreeRandomLiveCells() {

        Cell cell = new Cell(1, 1, State.LIVE);
        Cell cell1 = new Cell(4, 2,  State.LIVE);
        Cell cell2 = new Cell(2, 3, State.LIVE);


        Set<Cell> liveCellSet = new HashSet<>();
        liveCellSet.add(cell);
        liveCellSet.add(cell1);
        liveCellSet.add(cell2);


        GameStrategy strategy = new DefaultGameStrategy(new Rule[]{new RuleImpl()});
        Board board = new Board();
        board.setActiveCellsOnBoard(liveCellSet);
        RuleRunner ruleRunner = new RuleRunner();

        Set<Cell> cells = ruleRunner.applyRules(board, new CellProcessor(strategy));
        assertEquals(0, cells.size());
    }
}
