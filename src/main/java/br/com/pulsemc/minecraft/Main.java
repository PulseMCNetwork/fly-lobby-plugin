package br.com.pulsemc.minecraft;

import br.com.pulsemc.minecraft.fly.Superman;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import br.com.pulsemc.minecraft.joinflyinglistener.FlyJoinListener;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§a/fly by Mike is active!");
        getCommand("superman").setExecutor(new Superman());
        getServer().getPluginManager().registerEvents(new FlyJoinListener(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c/fly by Mike is off!");
    }
}
