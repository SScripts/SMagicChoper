package SMagicChoper.Node;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import SMagicChoper.Vars.*;
import org.powerbot.game.api.methods.widget.Bank;


public class Banking extends Node {



    @Override
    public boolean activate(){

        return Inventory.isFull() && Cons.BankArea.contains(Players.getLocal());



    }

    @Override
    public void execute(){
        Vars.Status = "Banking";
        if (Bank.open()) {
            Task.sleep(200, 450);
            Bank.depositInventory();
        }


    }
}
