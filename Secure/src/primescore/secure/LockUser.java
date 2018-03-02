package primescore.secure;

import java.util.UUID;

import org.bukkit.entity.Player;

public class LockUser {
	private Boolean lockState;
	private Boolean unlockState;
	private Player user;
	private UUID userId;

	public LockUser(Player p) {
		lockState = false;
		unlockState = false;
		user = p;
		userId = user.getUniqueId();
	}
	
	public Player getPlayer() {
		return user;
	}
	
	public boolean getLockState() {
		return lockState;
	}
	
	public boolean getUnlockState() {
		return unlockState;
	}
	
	public UUID getUUID() {
		return userId;
	}
	
	public void setLockState(boolean newState) {
		lockState = newState;
	}
	
	public void setUnlockState(boolean newState) {
		unlockState = newState;
	}
	
	
}
