package SMagicChoper.Vars;


import org.powerbot.game.api.util.Timer;

public class Vars {

    public static boolean hide = false;

    public static String Status;
    public static int Gold = 1600;
    public static int StartEXP;

    public static Timer runTime = new Timer(0);
    public static Timer currTime = new Timer(0);

    /*public static int expGained = Skills.getExperience(Skills.WOODCUTTING) - StartEXP;
    public static int expHour = (int) ((3600000.0 / startTime) * expGained);
    public static int profit = ((Skills.getExperience(Skills.WOODCUTTING) - StartEXP)/250) * Gold;
    public static int profitHour = (int) ((3600000.0 / startTime) * profit);
    public static int logsHour= (int) ((3600000.0 / startTime) * ((Skills.getExperience(Skills.WOODCUTTING) - StartEXP)/250));
    */

}
