package doom.core.crates;

import java.io.File;

import doom.core.files.Files;
import doom.core.vars.FileLocations;

public class CratesInit {

	public static void LootCrate() {
		File f = new File(FileLocations.CratesDir);
		f.mkdir();
		Files.fileExistsCreate(FileLocations.lootCrateFileloc);
		if (Files.getString(FileLocations.lootCrateFileloc, "v").equalsIgnoreCase("0") || Files.getString(FileLocations.lootCrateFileloc, "v") == "null") {
			Files.setString(FileLocations.lootCrateFileloc, "v", "1");
			Files.setString(FileLocations.lootCrateFileloc, "TotalCrates", "1");
		}
		
		String s = Files.getString(FileLocations.lootCrateFileloc, "TotalCrates");
		int a = Integer.parseInt(s);
		if (Files.getString(FileLocations.lootCrateFileloc, "Crates." + a).equals("null")) {
			int n = 0;
			while (a > 0) {
				n++;
				if (Files.getString(FileLocations.lootCrateFileloc, "Crates." + n).equals("null")) {
					Files.setString(FileLocations.lootCrateFileloc, "Crates." + n, "");
					Files.setString(FileLocations.lootCrateFileloc, "Crates." + n + ".name", "ExampleName");
					Files.setString(FileLocations.lootCrateFileloc, "Crates." + n + ".id", n + "");
					Files.setString(FileLocations.lootCrateFileloc, "Crates." + n + ".location", "example.yml");
				} 
				--a;
			}
		}
		a = Integer.parseInt(s);
		s = Files.getString(FileLocations.CratesDir + Files.getString(FileLocations.lootCrateFileloc, "Crates." + a + ".location"), "TotalCrates");
		int aa = Integer.parseInt(s);
		while (a > 0) {
			String loc = FileLocations.CratesDir + Files.getString(FileLocations.lootCrateFileloc, "Crates." + a + ".location");
			Files.fileExistsCreate(FileLocations.CratesDir + Files.getString(FileLocations.lootCrateFileloc, "Crates." + a + ".location"));
			int n = 0;
			if (Files.getString(loc, "v").equalsIgnoreCase("0") || Files.getString(loc, "v") == "null") {
				Files.setString(loc, "v", "1");
				Files.setString(loc, "TotalItems", "1");
			}
			while (aa > 0) {
				n++;
				if (Files.getString(loc, "item." + n).equals("null")) {
					Files.setString(loc, "item." + n + ".name", "example");
					Files.setString(loc, "item." + n + ".itemStack", "example");
				}
				--aa;
			}
			--a;
		}
	}
	
}
