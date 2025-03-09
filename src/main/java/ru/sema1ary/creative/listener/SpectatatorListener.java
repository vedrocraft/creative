package ru.sema1ary.creative.listener;

import com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class SpectatatorListener implements Listener {
    @EventHandler
    public void onSpectate(PlayerStartSpectatingEntityEvent event) {
        if(!event.getPlayer().hasPermission("creative.spectate")) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.SPECTATE) &&
                !event.getPlayer().hasPermission("creative.spectator.teleport")) {
            event.setCancelled(true);
        }
    }
}
