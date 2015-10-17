package Study04;

public class Question_2 {

	boolean isPowerOn;
	int channel;
	int volume;
	int prevChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 1;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public void setChannel(int channel) {
		prevChannel = this.channel;
		this.channel = channel;
	}
	
	public int getChannel() {
		return channel;
	}
	
	public void setVolume(int volume) {
		prevChannel = this.volume;
		this.volume = volume;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void gotoprevchannel(){
		
		setChannel(prevChannel);
	}
	
	public static void main(String[] args) {
		
		Question_2 t = new Question_2();
		
		t.setChannel(10);
		System.out.println("CH : " + t.getChannel());
		t.setVolume(20);
		System.out.println("VOL : "+t.getVolume());
		
		
	}
}
