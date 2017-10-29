/**
 * 
 * This class represent a Room
 */
public class Room {
	String CustomerN;
	int RoomN;

	/**
	 * Sets the Customer Number of this#Room to passed CustomerN
	 * 
	 * @param CustomerN
	 */
	public void setCustomer(String CustomerN) {
		this.CustomerN = CustomerN;

	}

	/**
	 * 
	 * @return CustomerN of String type
	 */
	public String getCustomer() {
		return this.CustomerN;

	}

	/**
	 * Sets the Room Number of this#Room to passed RoomN
	 * 
	 * @param RoomN
	 */
	public void setRoom(int RoomN) {
		this.RoomN = RoomN;
	}

	/**
	 * 
	 * @return RoomN of int type
	 */
	public int getRoom() {
		return this.RoomN;

	}

}
