package doom.core.admin.login;

import java.math.BigInteger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import doom.core.functions.Colour;
import doom.core.vars.ConfStrings;
import doom.core.vars.HashMaps;
import doom.core.vars.Modules;


public class AdminFunctions implements Listener {

	public static String toHexString(byte[] hash) {
		BigInteger number = new BigInteger(1, hash);
		StringBuilder hexString = new StringBuilder(number.toString(16));
		while (hexString.length() < 32)  {  
            hexString.insert(0, '0');  
        }  
		return hexString.toString(); 
	}
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		
		if (Modules.Modules.get("AdminLogin").equalsIgnoreCase("false")) { return; }
		
		Player p = e.getPlayer();
		if (p.hasPermission(ConfStrings.AdminLoginCheckPerm)) {
			if (HashMaps.adminLoginHM.get(p.getUniqueId().toString()) == "true") { return; }
			if (e.getMessage().contains("/admin")) { 
				return;
			} else {
				e.setCancelled(true);
				p.sendMessage(Colour.ColourMsg(ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AL-NotLoggedInCommnad")));
			}	
		}	
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		if (Modules.Modules.get("AdminLogin").equalsIgnoreCase("false")) { return; }
		
		Player p = e.getPlayer();
		if (p.hasPermission(ConfStrings.AdminLoginCheckPerm)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 999999, 2));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 2));
			HashMaps.adminLoginHM.put(p.getUniqueId().toString(), "false");
		}
	}
	
}
