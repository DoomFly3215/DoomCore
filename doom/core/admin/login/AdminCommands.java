package doom.core.admin.login;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import doom.core.files.Files;
import doom.core.functions.Colour;
import doom.core.vars.ConfStrings;
import doom.core.vars.FileLocations;
import doom.core.vars.HashMaps;
import doom.core.vars.Modules;

public class AdminCommands implements CommandExecutor {

	public static File f = new File("");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		if (!(sender instanceof Player)) { return false; }
		
		if (Modules.Modules.get("AdminLogin").equalsIgnoreCase("false")) { return false; }
		
		Player p = (Player) sender;
		String uuid = p.getUniqueId().toString();
		String fileLocation = FileLocations.adminLoginFolder + uuid + ".yml";
		
		if (cmd.getName().toString().equalsIgnoreCase("admin")) {
// -------------------------------------->> Xray	
			if (args[0].toString().equalsIgnoreCase("xray")) {
				if (p.hasPermission(ConfStrings.StaffPerm)) {
					if (!HashMaps.AdminXrayOpt.containsKey(p.getUniqueId().toString())) {
						HashMaps.AdminXrayOpt.put(p.getUniqueId().toString(), "true");
					} 
					if (HashMaps.AdminXrayOpt.get(p.getUniqueId().toString()).equalsIgnoreCase("true")) {
						Files.setString(FileLocations.adminXrayOpt, p.getUniqueId().toString(), "false");
						HashMaps.AdminXrayOpt.put(p.getUniqueId().toString(), "false");
						p.sendMessage(Colour.ColourMsg((ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AX-TurnedOff"))));
						return true;
					} else if (HashMaps.AdminXrayOpt.get(p.getUniqueId().toString()).equalsIgnoreCase("false")) {
						Files.setString(FileLocations.adminXrayOpt, p.getUniqueId().toString(), "true");
						HashMaps.AdminXrayOpt.put(p.getUniqueId().toString(), "true");
						p.sendMessage(Colour.ColourMsg((ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AX-TurnedOn"))));
						return true;
						
					}
				}
				return true;
			}
// -------------------------------------->> Register			
			if (args[0].equalsIgnoreCase("register")) {
				
				Files.fileExistsCreate(fileLocation);
				if (Files.getString(fileLocation, "Password") == "null") {
					if (args.length <= 1) {
						p.sendMessage(Colour.ColourMsg((ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AL-RegisterLengthError"))));
					} else {

						String Salt = "T8*vj!9[+.";
						
						MessageDigest digest = null;
						try { digest = MessageDigest.getInstance("SHA-256");
						} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
						byte[] hash = digest.digest((args[1] + Salt).getBytes(StandardCharsets.UTF_8));
						Files.setString(fileLocation, "Password", AdminFunctions.toHexString(hash));
						
						p.sendMessage(Colour.ColourMsg(ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AL-PasswordSet")));
					}
				} else {
					p.sendMessage(Colour.ColourMsg(ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AL-AlreadyRegistered")));
				}
				
			}
// -------------------------------------->> Login
			if (args[0].equalsIgnoreCase("login")) {
				Files.fileExistsCreate(fileLocation);
				if (!(Files.getString(fileLocation, "Password") == "null")) {
					
					String Salt = "T8*vj!9[+.";
					
					MessageDigest digest = null;
					try { digest = MessageDigest.getInstance("SHA-256");
					} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
					byte[] hash = digest.digest((args[1] + Salt).getBytes(StandardCharsets.UTF_8));
					if (AdminFunctions.toHexString(hash).equals(Files.getString(fileLocation, "Password"))) {
						p.sendMessage(Colour.ColourMsg(ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AL-LoggedIn")));
						HashMaps.adminLoginHM.put(uuid, "true");
						p.removePotionEffect(PotionEffectType.BLINDNESS);
						p.removePotionEffect(PotionEffectType.SLOW);
					} else {
						p.sendMessage(Colour.ColourMsg(ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AL-IncorrectPass")));
						HashMaps.adminLoginHM.put(uuid, "false");
					}
				} else {
					p.sendMessage(Colour.ColourMsg(ConfStrings.ServPrefix + " " + HashMaps.LangHM.get("AL-NoPasswordSet")));
					return false;
				}
			}
			
// -------------------------------------->> Reset	
		}
		return false;
	}

}
