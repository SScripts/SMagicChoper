package SMagicChoper.Node;

import SMagicChoper.Vars.Cons;

import SMagicChoper.Vars.Vars;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.wrappers.node.SceneObject;


public class Chop extends Node {





    @Override
    public boolean activate() {

        return !Inventory.isFull() && Cons.TreeArea.contains(Players.getLocal());


    }

    @Override
    public void execute(){

        SceneObject Magictree = SceneEntities.getNearest(Cons.MAGIC_TREE);



        if(Magictree != null && !Inventory.isFull()){
            if(Magictree.isOnScreen()){
                if(Players.getLocal().isIdle()) {
                    if(Magictree.interact("Chop down")){
                        Vars.Status = "Choping down Tree";
                        Timer t = new Timer(3000);
                        while(t.isRunning()&&Magictree.validate()){
                            sleep(75);
                        }
                    }





                }

            } else  {
                Camera.turnTo(Magictree);
                Vars.Status = "Looking for the Tree";
            }
        } else {
            Timer l = new Timer(2000);
            while (l.isRunning() && !Magictree.validate()){
                sleep(75);

            }
            Vars.Status = "Waiting for Tree";

        }
    }



}
