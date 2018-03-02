package primescore.secure;

import java.util.HashMap;

import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Secure extends JavaPlugin{
	private static HashMap<Player,LockUser> userList;
	
	
	public void onEnable() {
		System.out.println("Nexus Secure has loaded successfully.");
		PluginManager pluginManager = getServer().getPluginManager();
		Listener blockListener = new BlockListener();
		Listener playerListener = new PlayerListener();
		pluginManager.registerEvents(blockListener, this);
		pluginManager.registerEvents(playerListener, this);
		this.getCommand("NexusLock").setExecutor((CommandExecutor)new CommandListener());
		userList = new HashMap<Player,LockUser>();
		
	}
	
	public void onDisable() {
		System.out.println("Nexus Secure has unloaded successfully");
	}
	
	public static HashMap<Player,LockUser> getUserHash(){
		return userList;
	}
	
}
