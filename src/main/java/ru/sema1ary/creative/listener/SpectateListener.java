package ru.sema1ary.creative.listener;

import com.destroystokyo.paper.event.player.PlayerStartSpectatingEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class SpectateListener implements Listener {
    @EventHandler
    public void onSpectate(PlayerStartSpectatingEntityEvent event) {
        if(!event.getPlayer().hasPermission("creative.spectate")) {
            event.setCancelled(true);
        }
    }
}
