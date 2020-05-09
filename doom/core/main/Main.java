package doom.core.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import doom.core.admin.login.AdminCommands;
import doom.core.admin.login.AdminFunctions;
import doom.core.admin.xray.XXray;
import doom.core.crates.CratesInit;
import doom.core.crates.Lootcrate;
import doom.core.files.Files;
import doom.core.functions.BedSpawn;
import doom.core.functions.ConsoleMessage;
import doom.core.functions.Join;
import doom.core.functions.Recipes;
import doom.core.init.Init;
import doom.core.vars.FileLocations;
import doom.core.vars.HashMaps;

public class Main extends JavaPlugin {

	public void onEnable() {
		this.saveDefaultConfig();
		
		Files.fileExists(FileLocations.configLoc);
		
		HashMapsClear();
		Init.ConfigInit();
		Init.LangInit();
		Init.ModulesInit();
		Init.AdminLoginInit();
		Init.PermissionInit();
		Init.RecipesEnabled();
		RegCommands();
		RegEvents();
		CratesInit.LootCrate();
		
		ConsoleMessage.ConsoleInfo("&fPlugin made by DoomFly3215");
		ConsoleMessage.ConsoleInfo("&fDiscord: DoomFly3215#1119");
		ConsoleMessage.ConsoleInfo("&fFor support Dm ^^^");

	}
	
	public void HashMapsClear() {
		HashMaps.adminLoginHM.clear();
		HashMaps.AllPlayers.clear();
		HashMaps.LangHM.clear();
	}
	
	public void RegEvents() {
		Bukkit.getPluginManager().registerEvents(new AdminFunctions(), this);
		Bukkit.getPluginManager().registerEvents(new XXray(), this);
		Bukkit.getPluginManager().registerEvents(new Join(), this);
		Bukkit.getPluginManager().registerEvents(new BedSpawn(), this);
		Bukkit.getPluginManager().registerEvents(new Lootcrate(), this);
		Bukkit.getPluginManager().registerEvents(new Recipes(), this);
	}
	
	public void RegCommands() {
		this.getCommand("admin").setExecutor(new AdminCommands());
	}
}
