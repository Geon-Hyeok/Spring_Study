package xyz.itwill02.factory;

// Factory 클래스로 제공될 객체를 생성하는 클래스는 반드시 인터페이스를 상속받아 작성
public class HelloMessageObject implements MessageObject {

	@Override
	public String getMessage() {
		return "Hello!!!";
	}

}
