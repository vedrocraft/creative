package ru.sema1ary.creative.listener;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import ru.sema1ary.spawn.service.SpawnService;
import ru.sema1ary.vedrocraftapi.service.PluginServiceGetter;

public class MoveListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();

        WorldBorder worldBorder = world.getWorldBorder();
        double borderSize = worldBorder.getSize() / 2;
        Location center = worldBorder.getCenter();

        if (player.getLocation().getX() < (center.getX() - borderSize) ||
                player.getLocation().getX() > (center.getX() + borderSize) ||
                player.getLocation().getZ() < (center.getZ() - borderSize) ||
                player.getLocation().getZ() > (center.getZ() + borderSize)) {

            PluginServiceGetter.getServiceFromPlugin("spawn", SpawnService.class)
                    .teleportToSpawn(player);
        }
    }
}
