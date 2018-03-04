package com.paulomonteir0o.mito;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.paulomonteir0o.mito.command.Mito;
import com.paulomonteir0o.mito.event.PlayerDeath;
import com.paulomonteir0o.mito.event.onJoin;

public class Core extends JavaPlugin{
	
	public static Core instance;
	
	@Override
	public void onEnable() {
		instance = this;
		saveDefaultConfig();
		load();
		mensagem("§eiMito > §fPlugin ativado com sucesso.");
	}
	
	@Override
	public void onDisable() {
		mensagem("§ciMito > §fPlugin desativado com sucesso.");
	}
	
	public void load() {
		getServer().getPluginManager().registerEvents(new onJoin(), this);
		getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
		getCommand("mito").setExecutor(new Mito());
	}
	
	public static void mensagem(String msg) {
		Bukkit.getConsoleSender().sendMessage(msg);
	}
	
	public static Core getInstance() {
		return instance;
	}

}
