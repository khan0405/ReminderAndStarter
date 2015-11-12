package example1021;

import org.omg.Messaging.SyncScopeHelper;

public class Exam7_11 {

	public static void main(String[] args) {

		MyTv3 t = new MyTv3();

		t.setChannel(10);
		System.out.println("CH : " + t.getChannel());
		t.setChannel(20);
		System.out.println("CH : " + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH : " + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH : " + t.getChannel());
	}

}

class MyTv3 {

	boolean isPowerOn;
	int channel;
	int volume;
	int number = 0;
	int a = 0;
	int b = 0;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	public void gotoPrevChannel() {
		if (number == 0) {
			a = channel;
		} else if (number == 1) {
			b = channel;
		} else if (number > 1) {
			if (number % 2 == 0) {
				channel = a;
			} else if (number % 2 == 1) {
				channel = b;
			}
		}
		number++;
	}

	public boolean isPowerOn() {
		return isPowerOn;
	}

	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;

	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
		gotoPrevChannel();
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getMAX_VOLUME() {
		return MAX_VOLUME;
	}

	public int getMIN_VOLUME() {
		return MIN_VOLUME;
	}

	public int getMAX_CHANNEL() {
		return MAX_CHANNEL;
	}

	public int getMIN_CHANNEL() {
		return MIN_CHANNEL;
	}
}