package br.com.pulsemc.minecraft.joinflyinglistener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class FlyJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.hasPermission("superman.use")) {

            player.setAllowFlight(true);
            player.setFlying(true);

            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("lobby-flight"), () -> {
                Location currentLocation = player.getLocation();
                Location teleportLocation = currentLocation.clone().add(0, 5, 0);
                player.teleport(teleportLocation);
            }, 1L);
        }
    }
}
