$('#btn').click(process);

function process() {
	//alert('test');
	
	$.ajax({
		type:'GET',
		dataType:'json',
		url:'searchOpen.do?query='+$('#search').val(),
		success:viewMessage,
		error:function(xhr, textStatus, error){
			alert(xhr.status);
		}
	});
}//end process()

function viewMessage(res){
	//alert(res);
	//console.log(res);
	$('#wrap').append(`<table><tr><th>title</th><th>image</th><th>price</th></tr></table>`);
	$.each(res.documents, function(index,element){
		$('#wrap table').append(`<tr><td>${element.title}</td><td><a href="${element.url}"><img src="${element.thumbnail}" /></a></td><td>${element.price}</td></tr>`);
		//이미지를 클릭하면(thumbnail) 해당하는 페이지(url)로 이동하도록 한다.	
	}); //반복출력으로 가져온 데이터들을 출력한다.
}

