package doom.core.functions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import doom.core.vars.ConfStrings;
import doom.core.vars.Modules;

public class Join implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (Modules.Modules.get("JoinAndLeave").equalsIgnoreCase("false")) { return; }
		Player p = e.getPlayer();
		String msg = ConfStrings.JoinMessage;
		if (ConfStrings.JQMessagePerm.equalsIgnoreCase("none")) {
			String msg1 = msg.replaceAll("<player>", p.getName().toString());
			e.setJoinMessage(Colour.ColourMsg(msg1));
			return;
		}
		if (p.hasPermission(ConfStrings.JQMessagePerm)) {
			String msg1 = msg.replaceAll("<player>", p.getName().toString());
			e.setJoinMessage(Colour.ColourMsg(msg1));
			return;
		}
		e.setJoinMessage("");
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if (Modules.Modules.get("JoinAndLeave").equalsIgnoreCase("false")) { return; }
		Player p = e.getPlayer();
		String msg = ConfStrings.QuitMessage;
		if (ConfStrings.JQMessagePerm.equalsIgnoreCase("none")) {
			String msg1 = msg.replaceAll("<player>", p.getName().toString());
			e.setQuitMessage(Colour.ColourMsg(msg1));
			return;
		}
		if (p.hasPermission(ConfStrings.JQMessagePerm)) {
			String msg1 = msg.replaceAll("<player>", p.getName().toString());
			e.setQuitMessage(Colour.ColourMsg(msg1));
			return;
		}
		e.setQuitMessage("");
	}
	
}
