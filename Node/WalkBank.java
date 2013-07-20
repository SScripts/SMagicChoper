package SMagicChoper.Node;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import SMagicChoper.Vars.*;

public class WalkBank extends Node {
    @Override
    public boolean activate() {

        return Inventory.isFull() && !Cons.BankArea.contains(Players.getLocal());


    }

    @Override
    public void execute(){

        Walking.newTilePath(Cons.WalkBank).traverse();
        Vars.Status = "Walking to Bank";


    }
}
