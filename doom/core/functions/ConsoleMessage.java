package doom.core.functions;

import org.bukkit.Bukkit;

public class ConsoleMessage {

	
	public static void ConsoleInfo(String s) {
		Bukkit.getConsoleSender().sendMessage(Colour.ColourMsg(s));
	}
	
	public static void ConsoleError(String s) {
		Bukkit.getConsoleSender().sendMessage(Colour.ColourMsg("&c&lERROR" + s));
	}
	
	public static void ConsoleLog(String s) {
		Bukkit.getConsoleSender().sendMessage(Colour.ColourMsg("&6&lLOG" + s));
	}
}
