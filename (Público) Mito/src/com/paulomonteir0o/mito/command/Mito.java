package com.paulomonteir0o.mito.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.paulomonteir0o.mito.api.Msg;
import com.paulomonteir0o.mito.controller.MitoController;

public class Mito implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(Msg.get("APENAS_JOGADORES"));
			return true;
		}
		
		if(cmd.getName().equalsIgnoreCase("mito")) {
			if(args.length == 0) {
				sender.sendMessage(Msg.get("MITO_ATUAL").replace("{mito_atual}", MitoController.get()));
				return true;
			}
			if(args[0].equalsIgnoreCase("set") && sender.hasPermission(Msg.getPermission("ADMIN"))) {
				if(args.length <= 1) {
					sender.sendMessage(Msg.get("ARGS_INVALIDO"));
					return true;
				}
				new MitoController(args[1]).set();
				sender.sendMessage(Msg.get("MITO_SETADO").replace("{mito_setado}", args[1]));
			}
		}
		
		return false;
	}
	

}
