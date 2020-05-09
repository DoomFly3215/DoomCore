package doom.core.functions;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import doom.core.vars.Modules;

public class Recipes implements Listener {

	//
	// Grass Seeds
	//
	@EventHandler
	public void onGrassBreak(PlayerInteractEvent e) {
		if (Modules.Modules.get("Recipes").equals("false")) { return; }
		if (Modules.Recipes.get("GrassToSeeds").equals("false")) { return; }
		if (!e.getAction().equals(Action.LEFT_CLICK_BLOCK)) { return; }
		Player p = e.getPlayer();
		Block b = e.getClickedBlock();
		if (b.getType().equals(Material.GRASS)) {
			int r = new Random().nextInt(100);
			if (!(r < 10)) { return; }
			ItemStack i = new ItemStack(Material.WHEAT_SEEDS, 1);
			ItemMeta im = i.getItemMeta();
			im.setDisplayName(Colour.ColourMsg("&aGrass Seeds"));
			im.addEnchant(Enchantment.DURABILITY, 1, true);
			im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			i.setItemMeta(im);
			p.getInventory().addItem(i);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDirtGrassSeeds(PlayerInteractEvent e) {
		if (Modules.Modules.get("Recipes").equals("false")) { return; }
		if (Modules.Recipes.get("GrassToSeeds").equals("false")) { return; }
		if (!e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) { return; }
		Player p = e.getPlayer();
		ItemStack ph = p.getInventory().getItemInMainHand();
		ItemMeta im = ph.getItemMeta();
		Block b = e.getClickedBlock();
		if (b.getType().equals(Material.DIRT)) {
			if (!im.getDisplayName().equals(Colour.ColourMsg("&aGrass Seeds"))) { return; }
			b.setType(Material.GRASS_BLOCK);
			int phi = ph.getAmount() - 1;
			p.getInventory().getItemInMainHand().setAmount(phi);
			p.updateInventory();
		}
	}
	
	//
	// Wheat To flour
	//
	@EventHandler
	public void onCobbleStoneWheat(PlayerInteractEvent e) {
		if (Modules.Modules.get("Recipes").equals("false")) { return; }
		if (Modules.Recipes.get("WheatToFlour").equals("false")) { return; }
		if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Player p = e.getPlayer();
			Material i = p.getInventory().getItemInMainHand().getType();
			if (i.equals(Material.WHEAT)) {
				ItemStack ii = p.getInventory().getItemInMainHand();
				int amount = ii.getAmount();
				p.getInventory().removeItem(p.getInventory().getItemInMainHand());
				ItemStack iii = new ItemStack(Material.YELLOW_DYE, amount);
				ItemMeta im = iii.getItemMeta();
				im.addEnchant(Enchantment.DURABILITY, 1, true);
				im.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				im.setDisplayName(Colour.ColourMsg("&eFlour"));
				iii.setItemMeta(im);
				p.getInventory().addItem(iii);
			}
		} 
		return;
	}
}
