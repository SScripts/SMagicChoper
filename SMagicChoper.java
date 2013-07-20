package SMagicChoper;


import SClayMiner.Node.*;
import SMagicChoper.Node.Banking;
import SMagicChoper.Node.WalkBank;
import SMagicChoper.Vars.Cons;
import SMagicChoper.Vars.Vars;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;

import SMagicChoper.Node.*;
import org.powerbot.game.api.util.Timer;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;


@Manifest(name = "SMagicChoper", description = "Chops Magics at Seer´s Village", authors = {"SScipts"}, version = 1.0)

public class SMagicChoper extends ActiveScript implements MouseListener,PaintListener {

    private Node[] jobs = new Node[] { new Banking(), new WalkTree(),
            new Chop(), new WalkBank() };


    @Override
    public int loop() {
        for (Node job : jobs) {
            if (job.activate()) {
                job.execute();
                return Random.nextInt(250, 500);
            }
        }
        return Random.nextInt(250, 500);
    }
    @Override
    public void onStart() {

        if (Game.isLoggedIn()){

            Vars.StartEXP = Skills.getExperience(Skills.WOODCUTTING);
            Mouse.setSpeed(Mouse.Speed.FAST);

        }

    }



    private final LinkedList<MousePathPoint> mousePath = new LinkedList<MousePathPoint>();

    @SuppressWarnings("serial")
    private class MousePathPoint extends Point { // All credits to Enfilade

        private long finishTime;
        private double lastingTime;

        public MousePathPoint(int x, int y, int lastingTime) {
            super(x, y);
            this.lastingTime = lastingTime;
            finishTime = System.currentTimeMillis() + lastingTime;
        }

        public boolean isUp() {
            return System.currentTimeMillis() > finishTime;
        }
    }

    private Image getImage(String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch(IOException e) {
            return null;
        }
    }

    private final Image img1 = getImage("http://i.imgur.com/zVgaCcs.png");
    //boolean hide = false;
    Point p;
    Rectangle close = new Rectangle(500, 375, 25, 25);
    Rectangle open = new Rectangle(427, 405, 90, 90);
    Image button = getImage("http://i.imgur.com/H7UBt9i.png");

    @Override
    public void mouseClicked(MouseEvent e) {
        p = e.getPoint();
        if (close.contains(p) && !Vars.hide) {
            Vars.hide = true;
        } else if (open.contains(p) && Vars.hide) {
            Vars.hide = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void onRepaint(Graphics g) {

        if (Game.getClientState()  == 11) {
            if (!Vars.hide) {

                g.drawImage(img1, 1, 380, null);
                g.setColor(Color.BLACK);
                g.setFont(Cons.font1);
                g.drawString("" + Vars.Status,276,414);
                g.drawString("" + Vars.runTime.toElapsedString(), 82, 444);
                g.drawString("" + (getPerHour(Skills.getExperience(Skills.WOODCUTTING)-Vars.StartEXP)),431, 447);
                g.drawString("" + (((Skills.getExperience(Skills.WOODCUTTING)-Vars.StartEXP)/250)*Vars.Gold), 296, 466);
                g.drawString("" + (((Skills.getExperience(Skills.WOODCUTTING)-Vars.StartEXP)/250)*Vars.Gold), 296, 466);
                g.drawString("" + ((getPerHour(Skills.getExperience(Skills.WOODCUTTING)-Vars.StartEXP)/250)*Vars.Gold),300,488);
                g.drawString("" + ((Skills.getExperience(Skills.WOODCUTTING) - Vars.StartEXP)/250),80,470);
                g.drawString("" + (getPerHour(Skills.getExperience(Skills.WOODCUTTING)-Vars.StartEXP)/250),87,494);

            }

            if (Vars.hide) {

                g.drawImage(button, 427, 405, null);
            }
        }

        g.setColor(Color.GREEN);
        g.drawLine(Mouse.getX() - 0, Mouse.getY() - 0, Mouse.getX() + 0, Mouse.getY() + 900);
        g.drawLine(Mouse.getX() - 0, Mouse.getY() + 0, Mouse.getX() + 900, Mouse.getY() - 0);
        g.drawLine(Mouse.getX() - 900, Mouse.getY() + 0, Mouse.getX() + 0, Mouse.getY() - 0);
        g.drawLine(Mouse.getX() - 0, Mouse.getY() + 0, Mouse.getX() + 0, Mouse.getY() - 900);


    }
    private static int getPerHour(final int value) {
        if (Vars.runTime != null && Vars.runTime.getElapsed() > 0) {
            return (int) (value * 3600000d / Vars.runTime.getElapsed());
        } else {
            return 0;
        }
    }

}
