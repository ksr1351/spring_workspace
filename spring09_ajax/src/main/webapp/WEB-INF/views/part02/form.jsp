<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>part02_form</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<!-- <script defer type="text/javascript" src="ajaxview/part02/jquery.js"></script> -->
<script defer type="text/javascript" src="ajaxview/part02/script.js"></script>

</head>
<body>
  <!-- ajax로 보낼때는 form에 넣지않고 보낼 수 있다. -->
  <span>name</span>
  <input type="text" name="name" id="name" />
  <input type="button" value="commit" id="btn" />
  <div id="wrap"></div>
</body>
</html>