package ru.sema1ary.creative.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.List;

public class EntitySpawnListener implements Listener {
    List<CreatureSpawnEvent.SpawnReason> spawnReasonList = List.of(
            CreatureSpawnEvent.SpawnReason.BUILD_IRONGOLEM,
            CreatureSpawnEvent.SpawnReason.BUILD_SNOWMAN,
            CreatureSpawnEvent.SpawnReason.BUILD_WITHER
    );

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if(spawnReasonList.contains(event.getEntity().getEntitySpawnReason())) {
            event.setCancelled(true);
        }
    }
}
