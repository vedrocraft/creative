package ru.sema1ary.creative;

import org.bukkit.plugin.java.JavaPlugin;
import ru.sema1ary.creative.listener.EntitySpawnListener;
import ru.sema1ary.creative.listener.MoveListener;
import ru.sema1ary.creative.listener.PortalCreationListener;
import ru.sema1ary.creative.listener.SpectatatorListener;

public final class Creative extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SpectatatorListener(), this);
        getServer().getPluginManager().registerEvents(new EntitySpawnListener(), this);
        getServer().getPluginManager().registerEvents(new PortalCreationListener(), this);
        getServer().getPluginManager().registerEvents(new MoveListener(), this);
    }

    @Override
    public void onDisable() {
    }
}
