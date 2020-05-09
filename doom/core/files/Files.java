package doom.core.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import doom.core.functions.Colour;
import doom.core.functions.ConsoleMessage;
import doom.core.vars.ConfStrings;



public class Files {

	public static File f = new File("");
	
	// Checks if a file is there.
	public static void fileExists(String s) {
		f = new File(s);
		if (f.exists()) {
			ConsoleMessage.ConsoleInfo(Colour.ColourMsg(ConfStrings.ServPrefix + " &fFile is present."));
		} else {
			ConsoleMessage.ConsoleInfo(Colour.ColourMsg(ConfStrings.ServPrefix + " &fFile is absent."));
		}
	}
	
	// Checks if a file is there and if not then creates it.
	public static void fileExistsCreate(String s) {
		f = new File(s);
		if (f.exists()) {
			ConsoleMessage.ConsoleInfo(Colour.ColourMsg(ConfStrings.ServPrefix + " &fFile is present."));
		} else {
			ConsoleMessage.ConsoleInfo(Colour.ColourMsg(ConfStrings.ServPrefix + " &fFile is absent. Creating File."));
			try { f.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	// Adds a string to a file.
	public static void setString(String filepath, String path, String msg) {
		f = new File(filepath);
		if (f.exists()) {
			FileConfiguration data = YamlConfiguration.loadConfiguration(f);
			data.set(path, msg);
	        try { data.save(f); } catch (IOException e) { e.printStackTrace(); }
		} else {
			ConsoleMessage.ConsoleError(Colour.ColourMsg(" &fFile is absent. Creating File."));
			return;
		}
	}
	
	// Gets a specified string
	public static String getString(String filepath, String path) {
		String s = "";
		f = new File(filepath);
		FileConfiguration data = YamlConfiguration.loadConfiguration(f);
	       
	      if (data.getString(path) == null) {
	          s = "null";
	      } else {
	          s = data.getString(path);
	      }
		return s;
	}
}
