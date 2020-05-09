package doom.core.admin.xray;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import doom.core.functions.Colour;
import doom.core.vars.ConfStrings;
import doom.core.vars.HashMaps;
import doom.core.vars.Modules;



public class XXray implements Listener {

	@EventHandler(priority = EventPriority.HIGH)
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		HashMaps.AllPlayers.put(p.getUniqueId().toString(), p.getName().toString());
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		HashMaps.AllPlayers.remove(p.getUniqueId().toString(), p.getName().toString());
	}
	
	public Material[] Ores = {Material.IRON_ORE, Material.COAL_ORE, Material.DIAMOND_ORE, Material.REDSTONE_ORE, Material.LAPIS_ORE, Material.EMERALD_ORE, Material.GOLD_ORE}; 

	@EventHandler(priority = EventPriority.HIGH)
	public void BlockBreakEvent(org.bukkit.event.block.BlockBreakEvent e) {
		if (Modules.Modules.get("AntiXray").equalsIgnoreCase("false")) { return; }
		for (int i = 0; i < Ores.length; i++) {
			if (Ores[i] == e.getBlock().getType()) {
				
				String ore = Ores[i].name().toString();
				
				int x = e.getBlock().getX();
				String xf = Integer.toString(x);
				int y = e.getBlock().getY();
				String yf = Integer.toString(y);
				int z = e.getBlock().getZ();
				String zf = Integer.toString(z);
				
				for (Player l : e.getBlock().getWorld().getPlayers()) {
					if (l.hasPermission(ConfStrings.StaffPerm)) {
						if (!HashMaps.AdminXrayOpt.containsKey(e.getPlayer().getUniqueId().toString())) {
							HashMaps.AdminXrayOpt.put(e.getPlayer().getUniqueId().toString(), "true");
						}
						if (HashMaps.AdminXrayOpt.get(e.getPlayer().getUniqueId().toString()).equals("true")) {
							String msg = HashMaps.LangHM.get("STAFF-XrayLogMessage");
							String msg1 = msg.replaceAll("<ore>", ore);
							String msg2 = msg1.replaceAll("<loc>", "X: " + xf + " Y: " + yf + " Z: " + zf);
							l.sendMessage(Colour.ColourMsg(msg2));
						}
						else {
							continue;
						}
					}
				}
			}
		}
	}
	
}
