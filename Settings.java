
public enum Settings {
	OFF ("---"), LOW ("--+"), MEDIUM ("-++"), HIGH ("+++");
	private String value; 
	
	Settings (String aValue){
		value = aValue;
	}
	
	public String toString () {
		return value;
	}
	
}
