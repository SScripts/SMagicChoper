package SMagicChoper.Node;

import SMagicChoper.Vars.Cons;
import SMagicChoper.Vars.Vars;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.SceneObject;


public class WalkTree extends Node {
    SceneObject Magictree = SceneEntities.getNearest(Cons.MAGIC_TREE);

    @Override
    public boolean activate(){

        return !Inventory.isFull() && !Cons.TreeArea.contains(Players.getLocal());



    }

    @Override
    public void execute() {

        Walking.newTilePath(Cons.WalkTree).traverse();
        Vars.Status = "Walking to Tree´s";


    }

}
