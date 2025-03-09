package ru.sema1ary.creative.listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.inventory.ItemStack;

public class PortalCreationListener implements Listener {
    @EventHandler
    public void onNetherPortalCreate(PortalCreateEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    private void onEndPortalCreate(PlayerInteractEvent event) {
        if(!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        Block clickedBlock = event.getClickedBlock();
        if(clickedBlock == null || !clickedBlock.getType().equals(Material.END_PORTAL_FRAME)) {
            return;
        }

        ItemStack heldItem = event.getItem();
        if(heldItem == null || heldItem.getType().equals(Material.AIR) ||
                !heldItem.getType().equals(Material.ENDER_EYE)) {
            return;
        }

        event.setCancelled(true);
    }
}
