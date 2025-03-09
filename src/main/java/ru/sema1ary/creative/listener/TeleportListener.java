package ru.sema1ary.creative.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {
    @EventHandler
    public void onTeleport(PlayerTeleportEvent event) {
        if(event.getCause().equals(PlayerTeleportEvent.TeleportCause.SPECTATE) &&
        !event.getPlayer().hasPermission("creative.spectator.teleport")) {
            event.setCancelled(true);
        }
    }
}
