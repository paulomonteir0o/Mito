package com.paulomonteir0o.mito.controller;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.paulomonteir0o.mito.Core;
import com.paulomonteir0o.mito.api.Msg;

public class MitoController {

	private String mito;
	private ArrayList<Bat> morcegos = new ArrayList<>();
	
	
	public String getMito() {
		return mito;
	}

	public void setMito(String mito) {
		this.mito = mito;
	}

	public ArrayList<Bat> getMorcegos() {
		return morcegos;
	}

	public void setMorcegos(ArrayList<Bat> morcegos) {
		this.morcegos = morcegos;
	}

	public MitoController(String mito) {
		this.mito = mito;
	}
	
	public void set() {
		Player p = Bukkit.getPlayer(mito);
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.sendMessage(Msg.get("VIROU_MITO").replace("{novo_mito}", p.getName()));
		}
		
		p.getWorld().strikeLightningEffect(p.getLocation());
		for(int i = 0; i != 10; i++) {
			Bat bats = (Bat) p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
			bats.setCustomName("§c" + p.getName());
			bats.setCustomNameVisible(true);
			morcegos.add(bats);
		}
		
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Bat bats : getMorcegos()) {
					bats.remove();
				}
				
			}
		}.runTaskLater(Core.getInstance(), 20*5);
		
		Core.getInstance().getConfig().set("Mito", p.getName());
		Core.getInstance().saveConfig();
	}
	
	public static String get() {
		return Core.getInstance().getConfig().getString("Mito");
	}
	
}
