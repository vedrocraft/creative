package ru.sema1ary.creative.listener;

import com.google.common.eventbus.Subscribe;
import com.plotsquared.core.events.PlayerAutoPlotEvent;
import com.plotsquared.core.events.PlayerClaimPlotEvent;
import com.plotsquared.core.events.Result;
import com.plotsquared.core.plot.Plot;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import ru.sema1ary.spawn.Spawn;
import ru.sema1ary.spawn.service.SpawnService;

import java.util.function.Consumer;

public class BorderListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();

        WorldBorder worldBorder = world.getWorldBorder();
        double borderSize = worldBorder.getSize() / 2;
        Location center = worldBorder.getCenter();

        accept(player, player1 -> {
            Spawn spawn = (Spawn) Bukkit.getPluginManager().getPlugin("spawn");
            assert spawn != null;
            spawn.getService(SpawnService.class).teleportToSpawn(player);
        });
    }

    @Subscribe
    public void onPlotClaim(PlayerClaimPlotEvent event) {
        Player player = Bukkit.getPlayer(event.getPlotPlayer().getName());

        if(player == null || !player.isOnline()) {
            return;
        }

        event.getPlot().getCenter(location ->
                accept(player, player1 -> event.setEventResult(Result.DENY)));
    }

    @Subscribe
    public void onPlotAuto(PlayerAutoPlotEvent event) {
        Player player = Bukkit.getPlayer(event.getPlayer().getName());

        Plot plot = event.getPlot();
        if(player == null || !player.isOnline() || plot == null) {
            return;
        }

        plot.getCenter(location ->
                accept(player, player1 -> event.setEventResult(Result.DENY)));
    }

    private void accept(Player player, Consumer<Player> consumer) {
        World world = player.getWorld();

        WorldBorder worldBorder = world.getWorldBorder();
        double borderSize = worldBorder.getSize() / 2;
        Location center = worldBorder.getCenter();

        if (player.getLocation().getX() < (center.getX() - borderSize) ||
                player.getLocation().getX() > (center.getX() + borderSize) ||
                player.getLocation().getZ() < (center.getZ() - borderSize) ||
                player.getLocation().getZ() > (center.getZ() + borderSize)) {
            consumer.accept(player);
        }
    }
}
