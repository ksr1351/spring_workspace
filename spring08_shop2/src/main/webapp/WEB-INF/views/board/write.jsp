<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	$('#btnList').click(function(){
		$('#frm').attr('action', 'list.do');
		$('#frm').submit();
		//$('#frm').attr('action', 'list.do').submit; (위의 두 코드를 합친 것)
	});
	
	
	$('#btnSave').click(function(){ //btnsave에서 click이란 이벤트가 발생되면
		
		//$('[name=content]').val()에 있는 값을 가져와서 $('[name=content]').val()에 저장하라. /\n/gi(줄바꿈)을 <br/>로 저장하라
		$('[name=content]').val($('[name=content]').val().replace(/\n/gi,'<br/>')); 
		$('#frm').attr('action', 'write.do').submit();
	});
	
	
	$('#filepath').change(function(){
		console.log(this.files[0].size)
		if(this.files[0].size>1000000000){ //첨부파일은 모두 배열 형식으로 저장됨
			alert('1GB 이하만 첨부할 수 있습니다.'); //100바이트 이상이면 해당 알람 띄움
			$('#filepath').val(''); //초기화
			return false;
		} 
		
	});
	
});

</script>


<div class="container">
	<form name="frm" id="frm" method="post" enctype="multipart/form-data">

		<table class="table  table-bordere mt-1">

			<tr>
				<td width="20%" align="center">writer</td>
				<td>
				<input type="hidden" name="memberEmail" value="${sessionScope.authInfo.memberEmail}"/>
				<input type="text" name="memberName" size="30" maxlength="30"
					readonly = "readonly" value="${sessionScope.authInfo.memberName}" /></td>
			</tr>

			<tr>
				<td width="20%" align="center">제목</td>
				<td><c:if test="${dto.ref != 0}">답변</c:if>
				<input type="text" name="subject" size="40" /></td>
			</tr>

			<tr>
				<td width="20%" align="center">내용</td>
				<td><textarea name="content" rows="13" style="width: 100%"></textarea></td>
			</tr>

			<tr>
				<td width="20%" align="center">첨부파일</td>
				<td><input type="file" name="filename" id="filepath" />
			</tr>
		</table>
		
		<!-- 답변글일때.... -->
		<c:if test="${dto!=null}">
			<input type="text" name="num" id="num" value="${dto.num}" />
			<input type="text" name="currentPage" id="currentPage"
				value="${pv.currentPage}" />
			<input type="text" name="ref" value="${dto.ref}" />
			<input type="text" name="re_step" value="${dto.re_step}" />
			<input type="text" name="re_level" value="${dto.re_level}" />
		</c:if>
		<div class="text-center mt-5 mb-5">
			<input type="button" id="btnList" value="리스트" /> <input
				type="button" id="btnSave" value="저장" />
		</div>
	</form>
</div>
