package SMagicChoper.Vars;


import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;


import java.awt.*;


public class Cons {

    public static Font font1 = new Font("Verdana", 0, 16);

    public static final int MAGIC_TREE = 63176;

    public static final Area TreeArea = new Area(new Tile[] {
            new Tile(2688, 3428, 0), new Tile(2687, 3420, 0),
            new Tile(2700, 3418, 0), new Tile(2699, 3427, 0)
    });

    public static final Tile[] WalkTree = {
            new Tile(2725, 3487, 0), new Tile(2725, 3480, 0),
            new Tile(2725, 3474, 0), new Tile(2724, 3467, 0),
            new Tile(2724, 3460, 0), new Tile(2721, 3453, 0),
            new Tile(2716, 3447, 0), new Tile(2711, 3442, 0),
            new Tile(2706, 3437, 0), new Tile(2701, 3433, 0),
            new Tile(2697, 3429, 0), new Tile(2696, 3424, 0),
            new Tile(2693, 3420, 0)
    };

    public static final Tile[] WalkBank = {
            new Tile(2696, 3426, 0), new Tile(2699, 3430, 0),
            new Tile(2703, 3434, 0), new Tile(2707, 3438, 0),
            new Tile(2711, 3442, 0), new Tile(2715, 3446, 0),
            new Tile(2718, 3450, 0), new Tile(2720, 3455, 0),
            new Tile(2721, 3461, 0), new Tile(2721, 3467, 0),
            new Tile(2722, 3472, 0), new Tile(2722, 3478, 0),
            new Tile(2723, 3482, 0), new Tile(2724, 3487, 0),
            new Tile(2725, 3490, 0)
    };

    public static final Area BankArea = new Area(new Tile[] {
            new Tile(2719, 3496, 0), new Tile(2720, 3487, 0),
            new Tile(2730, 3488, 0), new Tile(2729, 3496, 0)
    });
}
