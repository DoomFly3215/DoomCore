package doom.core.crates;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import doom.core.functions.Colour;

public class Lootcrate implements Listener {

	@EventHandler
	public void LootCrateOpen(PlayerInteractEvent e) {
		Action A = e.getAction();
		if (!A.equals(Action.RIGHT_CLICK_BLOCK) || !A.equals(Action.RIGHT_CLICK_AIR)) { return; }
		Material b = e.getPlayer().getInventory().getItemInMainHand().getType();
		if (b == null) { return; } // Good null check lol
		if (b.equals(Material.CHEST)) {
			ItemStack i = e.getPlayer().getInventory().getItemInMainHand();
			ItemMeta im = i.getItemMeta();
			if (im.getDisplayName() == null) { return; }
			if (!im.getDisplayName().toString().equalsIgnoreCase(Colour.ColourMsg("&b&lLootBox"))) { return;}
			
		}
	}
}
