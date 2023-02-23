<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script type="text/javascript">
	let websocket;

	$(document).ready(function() {

		//입장 버튼을 클릭했을 때 이벤트 처리
		$('#enterBtn').on('click', function() { //enterBtn의 click이란 이벤트 발생되면 function함수의 내용을 실행

			//웹 소켓 연결
			websocket = new WebSocket("ws://localhost:8090/myapp/chatws.do");

			//웹 소켓 이벤트 처리
			websocket.onopen = onOpen; //소켓 서버에 연결이 되었을 때
			websocket.onmessage = onMessage; //소켓서버에서 클라이언트에게 메세지를 보냈을 때
			//스크립트에서 이벤트 걸때는 .소문자 
			//메세지 이벤트가 발생하면 onMessage에서 받음
			websocket.onclose = onClose; //소켓서버에 연결이 종료되었을 때

		});

		//전송 버튼을 눌렀을 때 이벤트 처리
		$('#sendBtn').on('click', function() {
			messageProcess();
		});

		//message 창에서 Enter를 눌렀을 때 메세지를 전송
		//키보드를 누를 때 이벤트 처리
		//메세지 입력 후 엔터 눌러도 이벤트 처리될 수 있도록
		$('#message').keypress(function(event) {
			if (event.keyCode == 13) {
				messageProcess();
			}
		});

		//$('#message').on('keypress', function () {
		//})

		
		
		
		//나가기 버튼을 누를 때 이벤트 처리
		$('#exitBtn').on('click', function(){
			websocket.close();
		});
		
		
		

	});
	////////////////////////////////////////////////////////////////////////////

	
	
	function messageProcess() { 
		//nickname과 message에 입력된 내용을 서버에 전송
		let nick = $('#nickname').val();
		let msg = $('#message').val();
		
		
		//메세지 전송
		websocket.send(nick + ":" + msg);
		//메세지 입력창 초기화
		$('#message').val('');
		
	}//end messageProcess()

	
	
	//////////////////////////////////////////////////////////////////////////////
	//WebSocket이 연결된 경우 호출되는 함수
	function onOpen(evt) { //소켓 서버에 연결이 되었을 때 어떠한 작업이 되어야한다면 // (evt)=> 이벤트를 받아처리해준다
		console.log("웹 소켓에 연결 성공");
	}

	//서버에서 메세지가 왔을 때 호출되는 함수
	function onMessage(evt) {
		console.log("evt:" , evt);
		
		//서버가 전송한 메세지 가져오기
		let data = evt.data;
		
		//메세지 출력(채팅영역 chatMessageArea에 추가하기)
		$('#chatMessageArea').append('<p>' + data+ '</p>'); //여기에 메세지값이 추가됨
	
	}//end onMessage()/////////////////////////////////////////
	
	

	/*
	 * 웹소켓이 제공하는 4가지 이벤트
	 - open: 커넥션이 제대로 생성되었을 때 발생하는 이벤트
	 - message : 데이터를 수신하였을 때 발생하는 이벤트
	 - error : 에러가 발생했을 때 이벤트
	 - close : 커넥션이 종료되었을 때 발생하는 이벤트
	 */
	 
	 
	 //WebSocket이 연결 해제된 경우 호출되는 함수
	function onClose(evt){
		 console.log('웹 소켓에 연결 해제');
	 }
</script>


</head>
<body>
	<span>이름:</span>
	<input type="text" id="nickname" />
	<input type="button" id="enterBtn" value="입장" />
	<input type="button" id="exitBtn" value="나가기" />

	<h1>채팅 영역</h1>
	<div id="charArea">
		<div id="chatMessageArea"></div>
		<!-- 메세지 출력 -->
	</div>

	<span>전송할 메시지:</span>
	<input type="text" id="message" />
	<!-- 메세지 입력 -->
	<input type="button" id="sendBtn" value="전송" />

</body>
</html>