
package it.nullyoung.scoreboardmaster.util;
import it.nullyoung.scoreboardmaster.ScoreboardMaster;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {

    public ScoreboardManager() {

        for(Player player : Bukkit.getOnlinePlayers()) {

            configureSidebar(player);

        }

    }

    public Scoreboard configureSidebar(Player player) {

        if(!ScoreboardMaster.getFileManager().getConfig().getBoolean("Sidebar.Toggle")) {

            return null;

        }

        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("objective", "dummy");
        objective.setDisplayName(FileManager.replaceCharacters(player, ScoreboardMaster.getFileManager().getConfig().getString("Sidebar.Title")));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        for(int i = ScoreboardMaster.getFileManager().getConfig().getStringList("Sidebar.Text").size(), j = 0; i > 0 && j < ScoreboardMaster.getFileManager().getConfig().getStringList("Sidebar.Text").size(); i--, j++) {

            objective.getScore(FileManager.replaceCharacters(player, ScoreboardMaster.getFileManager().getConfig().getStringList("Sidebar.Text").get(i - 1))).setScore(j + 1);

        }

        player.setScoreboard(scoreboard);
        return scoreboard;

    }

}
