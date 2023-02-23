//window.onload = function(){

//}

//$(document).ready(function(){
//	$('#btn').on('click', process);
//}); 

//first.jsp에서 defer선언으로 인해서 5-7번을 11번과 같이 작성하여도 문제없이 실행된다. 

$('#btn').on('click', process);
console.log('jquery');

function process(){
  $.ajax({
  	type:'GET',
  	dataType:'text',
  	url:'ajaxview/part01/sample.txt',
  	success:viewMessage
  });
}//end process()

function viewMessage(res){
  $('#wrap').html(res);
}