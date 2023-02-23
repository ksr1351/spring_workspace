//익명함수 사용
$('#btn').click(function() {
	$.ajax({
		type:'GET',
		dataType:'json', //json을 많이 사용하는 추세	
		
		//data:'data='+$('#data').val()
		
		//process.do를 실행, data라는 변수에 값을 넘겨준다. 
		//EmpController process(String data)가 값을 받는다.
		url:'process.do?data='+$('#data').val(),
		success:viewMessage //정상적으로 수행했을 경우 viewMessage함수 수행
	});
});

function viewMessage(res){
	//console.log(res);
	
	//데이터가 계속 누적이되므로 append직전에 제거 필요 (empty():자식요소 삭제 / remove():현재선택된 자신 삭제)
	//자식요소 삭제
	$('#wrap').empty();
	//$('#wrap').children().remove(); //remove()로 자식요소 삭제
	
	$('#wrap').append('<table><tr><th>employee_id</th><th>first_name</th><th>salary</th></tr></table>');
	$.each(res, function(index, element){
		 		//$('#wrap table').append('<tr><td>'+element.employee_id+'</td><td>'+element.first_name+'</td><td>'+element.salary+'</td></tr>');
		
				//template literal방식 (``백틱사용)
				$('#wrap table').append(`<tr><td>${element.employee_id}</td><td>${element.first_name}</td><td>${element.salary}</td></tr>`);
		  });
	
	$('#data').val(''); //검색어가 남지않도록 초기화
	$('#data').focus(); //검색어를 바로 입력할 수 있도록 포커스
	
}//end viewMessage()