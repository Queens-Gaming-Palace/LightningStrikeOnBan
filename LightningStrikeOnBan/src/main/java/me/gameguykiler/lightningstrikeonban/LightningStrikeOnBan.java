package me.gameguykiler.lightningstrikeonban;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class LightningStrikeOnBan extends JavaPlugin {
    public final Logger log = Logger.getLogger("Minecraft");
    public static LightningStrikeOnBan plugin;

    public LightningStrikeOnBan() {
    }

    public void onEnable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.log.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has been Enabled!");
        this.getServer().getPluginManager().registerEvents(new BanListener(this), this);
        this.getConfig().options().copyDefaults(true);
        if (!this.getConfig().contains("Ban Node")) {
            this.getConfig().createSection("Ban Node");
        }

        if (!this.getConfig().contains("Ban Command")) {
            this.getConfig().createSection("Ban Command");
            this.getConfig().set("Ban Command", "/ban");
        }

        this.saveConfig();
    }

    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        this.log.info(pdfFile.getName() + " Has been Disabled!");
    }
}
