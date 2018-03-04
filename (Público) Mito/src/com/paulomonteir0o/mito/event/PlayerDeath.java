package com.paulomonteir0o.mito.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.paulomonteir0o.mito.Core;
import com.paulomonteir0o.mito.controller.MitoController;

public class PlayerDeath implements Listener{
	
	@EventHandler
	void onPlayerKill(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if (p.getKiller() instanceof Player) {
			if (MitoController.get().equalsIgnoreCase(p.getName())) {
				new MitoController(p.getKiller().getName()).set();
			}
		}
	}
}
