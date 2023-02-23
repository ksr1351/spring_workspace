$('#btn').on('click', process);

/*
function process(){
	$.ajax({
		type:'POST',
		dataType:'text',
		data:{name:$('#name').val()}, //POST일때는 데이터를 data에 담아서 보낸다.
		url:'name.do',
		success:viewMessage
	});
}
*/


function process(){
	$.post('name.do', {name:$('#name').val()}, viewMessage);
	//$.방식('연결파일', data, 보여줄 페이지)
}


function viewMessage(res){
	$('#wrap').html(res);
	//res를 html로 파싱하여 #wrap이 있는곳(form.jsp의 div)에 넣어주라는 의미이다.
}