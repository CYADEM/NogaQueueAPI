package dev.tinchx.queue;

import dev.tinchx.queue.manager.QueueManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class QueueAPI extends JavaPlugin {

    private static QueueManager manager = QueuePlugin.getInstance().getQueueManager();

    @Override
    public void onEnable() {
        System.out.println("[NogaQueueAPI] Boolean #isQueueing loaded.");
        System.out.println("[NogaQueueAPI] Integer #getPosition loaded.");
        System.out.println("[NogaQueueAPI] String #getPlayerQueue loaded.");
        System.out.println("[NogaQueueAPI] Integer #getPlayerQueueLimit loaded.");
        System.out.println("[NogaQueueAPI] Integer #getPlayerQueueSize loaded.");
    }

    public static boolean isQueueing(Player player) {
        return manager.isQueueing(player);
    }

    public static int getPosition(Player player) {
        if (!manager.isQueueing(player)) {
            return -1;
        }
        return manager.getPlayerQueue(player).getPriority(player);
    }

    public static String getPlayerQueue(Player player) {
        if (!manager.isQueueing(player)) {
            return null;
        }
        return manager.getPlayerQueue(player).getServer();
    }

    public static int getPlayerQueueLimit(Player player) {
        if (!manager.isQueueing(player)) {
            return -1;
        }
        return manager.getPlayerQueue(player).getLimit();
    }

    public static int getPlayerQueueSize(Player player) {
        if (!manager.isQueueing(player)) {
            return -1;
        }
        return manager.getPlayerQueue(player).getUuids().size();
    }
}
