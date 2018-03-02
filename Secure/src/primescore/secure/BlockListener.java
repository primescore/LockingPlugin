package primescore.secure;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockListener implements Listener{

	@EventHandler
	public void onBlockInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		LockUser user = Secure.getUserHash().get(player);
		Block blockClicked = e.getClickedBlock();
		
		if (blockClicked.getType().equals(Material.CHEST)) {
			player.sendMessage("You clicked on a chest");
			if (user.getLockState()) {
				if(!checkLocked(blockClicked)) {
					addToLock(player, blockClicked);
					player.sendMessage("Chest added.");
				} else {
					player.sendMessage("This chest is already locked.");
				}
				
			}
			if (user.getUnlockState()) {
				player.sendMessage("You unlock dis chest.");
			}
		}
	}
	
	public void addToLock(Player player, Block b) {
		
	}
	
	public boolean checkLocked(Block b) {
		return true;
	}
}
