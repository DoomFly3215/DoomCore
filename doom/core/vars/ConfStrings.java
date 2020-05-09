package doom.core.vars;

import doom.core.files.Files;

public class ConfStrings {

	public static String ServPrefix = Files.getString(FileLocations.configLoc, "ServerInfo.Prefix");
	public static String ServName = Files.getString(FileLocations.configLoc, "ServerInfo.Name");
	public static String JoinMessage = Files.getString(FileLocations.configLoc, "ServerInfo.JoinMessage");
	public static String QuitMessage = Files.getString(FileLocations.configLoc, "ServerInfo.JoinMessage");

	public static String JQMessagePerm = Files.getString(FileLocations.PermissionLoc, "Permissions-JoinAndQuit");
	public static String CommandLogPerm = Files.getString(FileLocations.PermissionLoc, "Permissions-CommandLog");
	public static String AdminLoginPerm = Files.getString(FileLocations.PermissionLoc, "Permissions-AdminLogin");
	public static String AdminLoginCheckPerm = Files.getString(FileLocations.PermissionLoc, "Permissions-AdminCheckLogin");
	public static String StaffPerm = Files.getString(FileLocations.PermissionLoc, "Permissions-StaffPerm");
}
