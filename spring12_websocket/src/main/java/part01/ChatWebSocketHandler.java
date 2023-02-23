package part01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler { // 클래스 상속받기

	// 접속한 클라이언트의 정보를 저장할 컬렉션 객체
	public static List<WebSocketSession> list = new ArrayList<WebSocketSession>();

	public ChatWebSocketHandler() {

	}

	// 클라이언트가 연결되었을 때 호출되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 클라이언트 정보는 WebSocketSession session에 저장됨
		System.out.println(session.getId() + "연결 됨");

		// 리스트에 추가
		list.add(session);
	}

	// 클라이언트가 메세지를 보냈을 때 호출되는 메소드
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

		// 전송된 메세지를 가져옴
		String msg = (String) message.getPayload();// getpayload를 통해서 메세지 값을 받음
		System.out.println("msg=> " + msg);

		// 모든 클라이언트에게 메세지 전송
		for (WebSocketSession socket : list) {
			// 메세지 생성(msg에서 받아온)
			WebSocketMessage<String> sendMsg = new TextMessage(msg);
			// 각 세션에 메세지를 전송 (클라이언트쪽에 메세지 전송)
			socket.sendMessage(sendMsg);// socket = 각 클라이언트
		}
	}

	// 클라이언트와의 연결이 종료되었을 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("현재 접속 클라이언트 갯수 :" + list.size());

		// 리스트에서 제거
		System.out.println(session.getId() + "연결 종료됨");
		list.remove(session);
		
		System.out.println("현재 접속 클라이언트 갯수:" + list.size());
	}

}// end class










