package com.paulomonteir0o.mito.api;

import com.paulomonteir0o.mito.Core;
import com.paulomonteir0o.mito.controller.MitoController;

public class Msg {
	
	public static String get(String msg) {
		return Core.getInstance().getConfig().getString("Mensagens." + msg).replace("&", "§");
	}
	
	public static String getPermission(String permission) {
		return Core.getInstance().getConfig().getString("Permissions." + permission);
	}

}
