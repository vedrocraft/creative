package ru.sema1ary.creative;

import com.plotsquared.core.PlotAPI;
import org.bukkit.plugin.java.JavaPlugin;
import ru.sema1ary.creative.listener.EntitySpawnListener;
import ru.sema1ary.creative.listener.BorderListener;
import ru.sema1ary.creative.listener.PortalCreationListener;
import ru.sema1ary.creative.listener.SpectatatorListener;
import ru.sema1ary.creative.placeholder.MarryPlaceholder;

public final class Creative extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SpectatatorListener(), this);
        getServer().getPluginManager().registerEvents(new EntitySpawnListener(), this);
        getServer().getPluginManager().registerEvents(new PortalCreationListener(), this);
        getServer().getPluginManager().registerEvents(new BorderListener(), this);

        if(getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new MarryPlaceholder().register();
        }

        PlotAPI plotAPI = new PlotAPI();
        plotAPI.registerListener(new BorderListener());
    }

    @Override
    public void onDisable() {
    }
}
