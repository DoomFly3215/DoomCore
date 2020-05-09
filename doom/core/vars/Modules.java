package doom.core.vars;

import java.util.HashMap;

import doom.core.files.Files;

public class Modules {

	public static String ModAdminLogin = Files.getString(FileLocations.modulesLoc, "AdminLogin");
	
	public static HashMap<String, String> Modules = new HashMap<String, String>();
	public static HashMap<String, String> Recipes = new HashMap<String, String>();
}
