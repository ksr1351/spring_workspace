let httpRequest;

let btn = document.getElementById('btn');
btn.onclick = process;

function process(){
 //1. XMLHttpRequest 객체 생성
 httpRequest = new XMLHttpRequest();
 
 //2. 서버가 응답한 데이터를 처리하기 위한 callback 함수 등록
 httpRequest.onreadystatechange = viewMessage;
 
 //3. 서버에 요청 준비 (서버에 보내줄 데이터를 준비)
 //open(method, url, 비동기화(true))
 httpRequest.open('GET', 'ajaxview/part01/sample.txt', true);
 
 //4. 서버에 요청
 httpRequest.send();
 
}//end process()


//서버로부터 응답을 받았을 때 수행할 함수 (callback) 정의
function viewMessage(){
  if(httpRequest.readyState==4 && httpRequest.status==200){
  	document.getElementById("wrap").innerHTML = httpRequest.responseText;
  }
}//end viewMessage()