package doom.core.functions;

import org.bukkit.ChatColor;

public class Colour {

	public static String ColourMsg(String s) {
		String msg = ChatColor.translateAlternateColorCodes('&', s);
		return msg;
	}
}
