package ru.sema1ary.creative;

import org.bukkit.plugin.java.JavaPlugin;
import ru.sema1ary.creative.listener.EntitySpawnListener;
import ru.sema1ary.creative.listener.PortalCreationListener;
import ru.sema1ary.creative.listener.SpectateListener;
import ru.sema1ary.creative.listener.TeleportListener;

public final class Creative extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TeleportListener(), this);
        getServer().getPluginManager().registerEvents(new SpectateListener(), this);
        getServer().getPluginManager().registerEvents(new EntitySpawnListener(), this);
        getServer().getPluginManager().registerEvents(new PortalCreationListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
