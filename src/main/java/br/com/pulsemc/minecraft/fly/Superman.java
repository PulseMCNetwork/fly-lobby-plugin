package br.com.pulsemc.minecraft.fly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Superman implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Verifica se o comando foi enviado por um jogador
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem usar este comando!");
            return true;
        }

        Player player = (Player) sender;

        // Verifica permissão
        if (!player.hasPermission("superman.use")) {
            player.sendMessage("§cVocê não tem permissão para usar este comando!");
            return true;
        }

        // Alterna o modo de voo
        if (player.getAllowFlight()) {
            player.setAllowFlight(false); // Desativa voo
            player.setFlying(false);
            player.sendMessage("§eModo de voo desativado.");
        } else {
            player.setAllowFlight(true); // Ativa voo
            player.setFlying(true);
            player.sendMessage("§aModo de voo ativado.");
        }

        // Exibe qual comando foi usado (alias ou comando principal)
        player.sendMessage("§aVocê usou o comando: " + label);
        return true;

        }
    }
