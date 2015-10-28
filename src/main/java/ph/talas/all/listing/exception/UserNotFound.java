package ph.talas.all.listing.exception;

public class UserNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -838204358638896951L;

	public UserNotFound () {
		super("Encountered Exception: User not found");
	}
	
}
