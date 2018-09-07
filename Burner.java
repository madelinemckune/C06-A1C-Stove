
public class Burner{
	public enum Temperature {BLAZING, HOT, WARM, COLD};
	
	private Temperature myTemperature;
	private Settings mySetting;
	private int timer;
	public static final int MAX_DURATION = 2;
	
	
	public Burner(Temperature myTemperature, Settings mySetting, int timer) {
		super();
		this.myTemperature = myTemperature;
		this.mySetting = mySetting;
		this.timer = timer;
	}
	
	//constructor without fields
	public Burner () {
		myTemperature = Temperature.COLD;
		mySetting = Settings.OFF;
	}
	

	public Temperature getTemp() {
		return myTemperature;
	}
	
	public Settings getMySetting() {
		return mySetting;
	}
	
	public void plusButton() {
		switch (mySetting) {
		case OFF:
			increaseSetting();
			break;
		case LOW:
			increaseSetting();
			break;
		case MEDIUM:
			increaseSetting();
			break;
		case HIGH:
			break;
		}
		
	}
	
	public void minusButton () {
		switch (mySetting) {
		case OFF:
			break;
		case LOW:
			decreaseSetting();
			break;
		case MEDIUM:
			decreaseSetting();
			break;
		case HIGH:
			decreaseSetting();
			break;
		}
		
	}


	public void increaseSetting() {
		char [] t = getMySetting().toString().toCharArray();
		for (int i = t.length-1; i >= 0; i--) {
			if (t[i] != '+') {
				t[i] = '+';
				break;
			}
		}
	
		String output = new String(t);
		if (output.equals("--+")) {
			mySetting = Settings.LOW;
			System.out.println(getMySetting());
		}
		else if(output.equals("-++")) {
			mySetting = Settings.MEDIUM;
			System.out.println(getMySetting());
		}
		else if(output.equals("+++")) {
			mySetting = Settings.HIGH;
			System.out.println(getMySetting());
		}
		
	}
	
	public void decreaseSetting() {
		char [] t = getMySetting().toString().toCharArray();
		for (int i = 0; i < t.length-1; i++) {
			if (t[i] != '-') {
				t[i] = '-';
				break;
			}
		}
		String output = new String(t);
		if (output.equals("--+")) {
			mySetting = Settings.LOW;
			System.out.println(getMySetting());
		}
		else if(output.equals("-++")) {
			mySetting = Settings.MEDIUM;
			System.out.println(getMySetting());
		}
		else if(output.equals("---")) {
			mySetting = Settings.OFF;
			System.out.println(getMySetting());
		}
		
	}
	
	
	
	
	public void updateTemperature () {
		timer = (timer + 1) % (MAX_DURATION+1); 
	}
	
	public void display() {
		System.out.print("[" + getMySetting() + "]" + ".....");
	}

}
