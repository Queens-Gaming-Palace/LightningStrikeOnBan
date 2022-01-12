package me.gameguykiler.lightningstrikeonban;

import java.util.StringTokenizer;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BanListener implements Listener {
    public static LightningStrikeOnBan plugin;

    public BanListener(LightningStrikeOnBan instance) {
        plugin = instance;
    }

    @EventHandler(
            priority = EventPriority.LOWEST
    )
    public void playerBanned(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String said = event.getMessage();
        StringTokenizer token = new StringTokenizer(said);
        String banCmd = token.nextToken();
        if (banCmd.equalsIgnoreCase(plugin.getConfig().getString("Ban Command")) && player.hasPermission(plugin.getConfig().getString("Ban Node"))) {
            try {
                String playerName = token.nextToken();
                Player target = Bukkit.getPlayer(playerName);
                World world = target.getWorld();
                world.strikeLightningEffect(target.getLocation());
            } catch (Exception var9) {
                World world = player.getWorld();
                world.strikeLightningEffect(world.getSpawnLocation());
            }
        }

    }
}
