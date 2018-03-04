package com.paulomonteir0o.mito.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.paulomonteir0o.mito.Core;

public class onJoin implements Listener{
	
	@EventHandler
	void PlayerJoin(PlayerJoinEvent e) {
		if(e.getPlayer().getName().equalsIgnoreCase("iPaaulosz_"))	 {
			e.getPlayer().sendMessage("");
			e.getPlayer().sendMessage(" §eHEY! Esse servidor usa seu plugin de mito.");
			e.getPlayer().sendMessage("");
			e.getPlayer().sendMessage(" §eName: §f" + Core.getInstance().getDescription().getName().toString());
			e.getPlayer().sendMessage(" §eVersion: §f" + Core.getInstance().getDescription().getVersion().toString());
			e.getPlayer().sendMessage("");
		}
	}

}
