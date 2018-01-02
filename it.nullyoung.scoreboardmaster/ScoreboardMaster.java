
package it.nullyoung.scoreboardmaster;
import it.nullyoung.scoreboardmaster.events.PlayerJoinEvent;
import it.nullyoung.scoreboardmaster.util.FileManager;
import it.nullyoung.scoreboardmaster.util.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ScoreboardMaster extends JavaPlugin {

    private static FileManager fileManager;
    public static ScoreboardManager scoreboardManager;

    @Override
    public void onLoad() {

        logMultiple("**************************", "Caricando ScoreboardMaster", "**************************");

    }

    @Override
    public void onEnable() {

        logMultiple("***************************", "Abilitando ScoreboardMaster", "***************************");
        fileManager = new FileManager(this);
        fileManager.setupConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(), this);
        scoreboardManager = new ScoreboardManager();

        if(!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {

            getLogger().info("PlaceholderAPI è disabilitato, le funzioni di quest'ultimo non saranno disponibili.");

        }

    }

    @Override
    public void onDisable() {

        logMultiple("******************************", "Disabilitando ScoreboardMaster", "******************************");

    }

    private void logMultiple(String... strings) {

        for(String string : strings) {

            getLogger().info(string);

        }

    }

    public static FileManager getFileManager() {

        return fileManager;

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] arguments) {

        sendMultipleMessages(commandSender, "§7§m-------*=*-------", "§6§lScoreboardMaster§e, creato da @nullYoung", "§eNon esistono comandi, la gestione avviene dalla configurazione", "§7§m-------*=*-------");
        return true;

    }

    public void sendMultipleMessages(CommandSender object, String... messages) {

        for(String message : messages) {

            object.sendMessage(message);

        }

    }

}
