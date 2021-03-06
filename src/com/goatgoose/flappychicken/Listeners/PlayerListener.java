package com.goatgoose.flappychicken.Listeners;

import com.goatgoose.flappychicken.FlappyChicken;
import com.goatgoose.flappychicken.Model.FCPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener{

    private FlappyChicken plugin;

    public PlayerListener(FlappyChicken instance) {
        plugin = instance;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        plugin.addFlappyChickenPlayer(event.getPlayer());
        plugin.getFCPlayer(event.getPlayer()).jumpChicken();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        plugin.removeFlappyChickenPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
            event.setCancelled(true);
            FCPlayer fcPlayer = plugin.getFCPlayer(event.getPlayer());
            fcPlayer.jumpChicken();
        }
    }
}
