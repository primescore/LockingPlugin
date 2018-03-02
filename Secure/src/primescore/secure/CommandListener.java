package primescore.secure;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("NexusLock")) {
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				LockUser user = Secure.getUserHash().get(player);

				
				//Help Command
				if (args.length == 0) {
					player.sendMessage("NexusLock Help Menu:");
					player.sendMessage("arguments: lock unlock help");
				
					//Actual Commands
				} else {
					//Initiate locking
					if (args[0].equalsIgnoreCase("lock")) {
						if(!user.getUnlockState()) {
							if(!user.getLockState()) {
								user.setLockState(true);
								player.sendMessage("NEX | Locking started... Click on chests");
								
							} else {
								user.setLockState(false);
								player.sendMessage("NEX | Locking stopped...");
							}
						} else {
							player.sendMessage("NEX | You must stop unlocking first.");
						}
					}
					
					//Initiate unlocking
					else if (args[0].equalsIgnoreCase("unlock")) {
						if(!user.getLockState()) {
							if(!user.getUnlockState()) {
								user.setUnlockState(true);
								player.sendMessage("NEX | Unlocking started... Click on chests");
							} else {
								user.setUnlockState(false);
								player.sendMessage("NEX | Unlocking stopped...");
							}
						} else {
							player.sendMessage("NEX | You must stop locking first.");
						}
						
					//Unrecognized Argument	
					} else {
						player.sendMessage("Lets lock and load");
					}
					
				}
				
			}
		}
		return true;
	}

}
