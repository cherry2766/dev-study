package ch09.sec02;

public class Audio implements RemoteControl {
	private int volume;
	private boolean mute;

	@Override
	public void turnOn() {
		System.out.println("오디오를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("오디오를 끕니다");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		} else if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		} else
			this.volume = volume;
		System.out.println("현재 오디오 볼륨 : " + this.volume);
	}

	// default 재정의 가능
	// default 를 재정의할 경우 default 적지 않음
	@Override
	public void setMute(boolean mute) {
		this.mute = mute;
		if (this.mute) {
			System.out.println("오디오 무음 처리 합니다");
		} else {
			System.out.println("오디오 무음 해제 합니다");
		}
	}

}
