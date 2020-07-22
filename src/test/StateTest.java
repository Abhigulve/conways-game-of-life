import enums.State;
import org.junit.Assert;
import org.junit.Test;

public class StateTest {

    @Test
    public void testLiveCell() {
        Assert.assertEquals(State.LIVE, State.LIVE.getNextState(3));
    }

    @Test
    public void testDeadCell() {
        Assert.assertEquals(State.DEAD, State.LIVE.getNextState(1));
    }

    @Test
    public void testDeadToLive() {
        Assert.assertEquals(State.LIVE, State.LIVE.getNextState(3));
    }

    @Test
    public void testDeadToDead() {
        Assert.assertEquals(State.DEAD, State.LIVE.getNextState(1));
    }

}

