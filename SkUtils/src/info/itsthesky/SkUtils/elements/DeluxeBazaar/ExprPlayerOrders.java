package info.itsthesky.SkUtils.elements.DeluxeBazaar;

import ch.njol.skript.doc.*;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.sedattr.bazaar.api.BazaarAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import javax.annotation.Nullable;
@Name("Bazaar Player Orders")
@Description("Return all orders made by a specific player")
@Since("alpha-0.1")
@RequiredPlugins("DeluxeBazaar")
@Examples("all bazaar orders of player")

public class ExprPlayerOrders extends SimpleExpression<String> {


    private Expression<Player> player;

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public boolean isSingle() {
        //2
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parser) {
        this.player = (Expression<Player>) exprs[0];
        return true;
    }

    @Override
    public String toString(@Nullable Event event, boolean debug) {
        //4
        return null;
    }

    @Override
    @Nullable
    protected String[] get(Event event) {
        final Player p = player.getSingle(event);
        if (p != null) {
            String[] array = new BazaarAPI().getPlayerOrders(p).toArray(new String[0]);
            if (array[0] == null) {
                return new String[0];
            }
            return array;
        }
        return null;
    }
}