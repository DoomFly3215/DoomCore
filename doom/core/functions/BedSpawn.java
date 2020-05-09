package doom.core.functions;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import doom.core.vars.ConfStrings;
import doom.core.vars.HashMaps;
import doom.core.vars.Modules;

public class BedSpawn implements Listener {

	@SuppressWarnings("deprecation")
	public Material[] Beds = {Material.BLACK_BED, Material.BLUE_BED, Material.BROWN_BED, Material.CYAN_BED, Material.GRAY_BED, Material.GREEN_BED, Material.LEGACY_BED};
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		if (Modules.Modules.get("BedSpawn").equals("false")) { return; }
		Block b = e.getClickedBlock();
		if (b == null) { return; }
		for (Material l : Beds) {
			b = e.getClickedBlock();
			if (b.getType().equals(l)) {
				Player p = e.getPlayer();
				p.setBedSpawnLocation(b.getLocation());
				p.sendMessage(Colour.ColourMsg(ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("PLAYER-BedSpawnSet")));
			}
		}
	}
}
