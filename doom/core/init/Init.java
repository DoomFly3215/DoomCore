package doom.core.init;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import doom.core.files.Files;
import doom.core.vars.FileLocations;
import doom.core.vars.HashMaps;
import doom.core.vars.Modules;

public class Init {
	
	public static void ConfigInit() {
		if (Files.getString(FileLocations.configLoc, "v").equalsIgnoreCase("0") || Files.getString(FileLocations.langLoc, "v") == "null") {
			Files.setString(FileLocations.configLoc, "v", "1");
			Files.setString(FileLocations.configLoc, "ServerInfo", "");
			Files.setString(FileLocations.configLoc, "ServerInfo.Prefix", "&e&lExamplePrefix");
			Files.setString(FileLocations.configLoc, "ServerInfo.Name", "&e&lExampleName");
			Files.setString(FileLocations.configLoc, "ServerInfo.JoinMessage", "&3&lJoin &e&l» &f<player>");
			Files.setString(FileLocations.configLoc, "ServerInfo.QuitMessage", "&3&lLeave &e&l» &f<player>");
		}
		return;
	}
	
	public static void PermissionInit() {
		Files.fileExistsCreate(FileLocations.PermissionLoc);
		if (Files.getString(FileLocations.PermissionLoc, "v").equalsIgnoreCase("0") || Files.getString(FileLocations.PermissionLoc, "v") == "null") {
			Files.setString(FileLocations.PermissionLoc, "v", "1");
			Files.setString(FileLocations.PermissionLoc, "Permissions-CommandLog", "doomcore.commandlog");
			Files.setString(FileLocations.PermissionLoc, "Permissions-AdminLogin", "doomcore.admin.login");
			Files.setString(FileLocations.PermissionLoc, "Permissions-AdminCheckLogin", "doomcore.admin.login");
			Files.setString(FileLocations.PermissionLoc, "Permissions-StaffPerm", "doomcore.admin.staff");
			Files.setString(FileLocations.PermissionLoc, "Permissions-JoinAndQuit", "none");
		}
	}
	
	public static void LangInit() {   
		Files.fileExistsCreate(FileLocations.langLoc);
		if (Files.getString(FileLocations.langLoc, "v") == "null" || Files.getString(FileLocations.langLoc, "v").equalsIgnoreCase("0") ) {
			Files.setString(FileLocations.langLoc, "v", "1");

			Files.setString(FileLocations.langLoc, "AL-AlreadyRegistered", "&eYou already have a password set.");
			Files.setString(FileLocations.langLoc, "AL-RegisterLengthError", "&e/admin register <password>");
			Files.setString(FileLocations.langLoc, "AL-PasswordSet", "&ePassword saved.");
			Files.setString(FileLocations.langLoc, "AL-NoPasswordSet", "&eYou have not set a password yet.");
			Files.setString(FileLocations.langLoc, "AL-LoggedIn", "&eLogged In.");
			Files.setString(FileLocations.langLoc, "AL-IncorrectPass", "&eIncorrect Password.");
			Files.setString(FileLocations.langLoc, "AL-NotLoggedInCommnad", "&eYou need to login before doing this.");
			Files.setString(FileLocations.langLoc, "AX-TurnedOn", "&eAnti-Xray Messages Enabled.");
			Files.setString(FileLocations.langLoc, "AX-TurnedOff", "&eAnti-Xray Messages Disabled.");
			Files.setString(FileLocations.langLoc, "STAFF-XrayLogMessage", "&e&lSTAFF &eore <ore> has been mined at <loc>");
			Files.setString(FileLocations.langLoc, "PLAYER-BedSpawnSet", "&eSpawnPoint set.");
		} 
		
		File f = new File(FileLocations.langLoc);
		YamlConfiguration data = YamlConfiguration.loadConfiguration(f);
	    List<String> l1 = new ArrayList<String>();
	    l1.addAll(data.getConfigurationSection("").getKeys(true));
	    for (String l : l1) {
	    	HashMaps.LangHM.put(l, Files.getString(FileLocations.langLoc, l));
	    }
	    
		return;
	}
	
	public static void ModulesInit() {
		Files.fileExistsCreate(FileLocations.modulesLoc);
		if (Files.getString(FileLocations.modulesLoc, "v") == "null" || Files.getString(FileLocations.modulesLoc, "v").equalsIgnoreCase("0") ) {
			Files.setString(FileLocations.modulesLoc, "v", "1");
			Files.setString(FileLocations.modulesLoc, "AdminLogin", "true");
			Files.setString(FileLocations.modulesLoc, "AntiXray", "true");
			Files.setString(FileLocations.modulesLoc, "JoinAndLeave", "true");
			Files.setString(FileLocations.modulesLoc, "BedSpawn", "true");
			Files.setString(FileLocations.modulesLoc, "Recipes", "true");
			
		}
		
		File f = new File(FileLocations.modulesLoc);
		YamlConfiguration data = YamlConfiguration.loadConfiguration(f);
	    List<String> l1 = new ArrayList<String>();
	    l1.addAll(data.getConfigurationSection("").getKeys(true));
	    for (String l : l1) {
	    	Modules.Modules.put(l, Files.getString(FileLocations.modulesLoc, l));
	    }
		
		return;
	}
	
	public static void RecipesEnabled() {
		Files.fileExistsCreate(FileLocations.RecipesLoc);
		if (Files.getString(FileLocations.RecipesLoc, "v") == "null" || Files.getString(FileLocations.RecipesLoc, "v").equalsIgnoreCase("0") ) {
			Files.setString(FileLocations.RecipesLoc, "v", "1");
			Files.setString(FileLocations.RecipesLoc, "WheatToFlour", "true");
			Files.setString(FileLocations.RecipesLoc, "GrassToSeeds", "true");
		}
		
		File f = new File(FileLocations.RecipesLoc);
		YamlConfiguration data = YamlConfiguration.loadConfiguration(f);
	    List<String> l1 = new ArrayList<String>();
	    l1.addAll(data.getConfigurationSection("").getKeys(true));
	    for (String l : l1) {
	    	Modules.Recipes.put(l, Files.getString(FileLocations.RecipesLoc, l));
	    }
			
	}
	
	public static void AdminLoginInit() {
		File f = new File(FileLocations.adminLoginFolder);
		f.mkdir();
		f = new File(FileLocations.adminFolder);
		f.mkdir();
		
		Files.fileExistsCreate(FileLocations.adminXrayOpt);
		if (Files.getString(FileLocations.adminXrayOpt, "v") == "null" || Files.getString(FileLocations.adminXrayOpt, "v").equalsIgnoreCase("0") ) {
			Files.setString(FileLocations.adminXrayOpt, "v", "1");
		}
		
		YamlConfiguration data = YamlConfiguration.loadConfiguration(f);
	    List<String> l1 = new ArrayList<String>();
	    l1.addAll(data.getConfigurationSection("").getKeys(true));
	    for (String l : l1) {
	    	HashMaps.AdminXrayOpt.put(l, Files.getString(FileLocations.adminXrayOpt, l));
	    }
	}
}
