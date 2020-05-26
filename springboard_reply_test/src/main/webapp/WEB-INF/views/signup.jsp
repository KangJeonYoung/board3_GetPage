<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!-- <script type="text/javascript">
		$(document).ready(function fn_idChk(){
			$('#idChk').on('click',
	function(){
			$.ajax({
				async:true,
				url : "/idChk",
				type : "post",
				data : {"userid" : $("#userid").val()
					},
				success : function(data){
					if(data == 1){
						alert("중복된 아이디입니다.");
					}else if(data == 0){
						$("#idChk").attr("value", "Y");
						alert("사용가능한 아이디입니다.");
					}
				
				},
			});
		});
		})
	</script> -->
	
	
	<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$(".cencle").on("click", function(){
				location.href = "/";
			})
			
			$("#submit").on("click", function(){
				if($("#userId").val()==""){
					alert("아이디를 입력해주세요.");
					$("#userId").focus();
					return false;
				}
				if($("#userPass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				if($("#userName").val()==""){
					alert("성명을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
				var idChkVal = $("#idChk").val();
				if(idChkVal == "N"){
					alert("중복확인 버튼을 눌러주세요.");
				}else if(idChkVal == "Y"){
					$("#regForm").submit();
				}
			});
		})
		
		function fn_idChk(){
			$.ajax({
				url : "/idChk",
				type : "post",
				dataType : "json",
				data : {"userid" : $("#userid").val()},
				success : function(data){
					if(data == 1){
						alert("중복된 아이디입니다.");
					}else if(data == 0){
						$("#idChk").attr("value", "Y");
						alert("사용가능한 아이디입니다.");
					}
				}
			})
		}
		
	</script>
	
	
	
	
<!-- <script type="text/javascript"> 
	$(document).ready(function() { 
		$('#idChk').on('click', function chk(){ 
			$.ajax({ 
				async: true, 
				type : 'POST', 
				url : "/idChk", 
				data:{ 
					"userid" : $('#userid').val() 
				}, 

				success : function(data) { 
					if ($.trim(data) == 0) {
					 $('#checkMsg').html('<p style="color:blue"> 사용가능 </p>');
					} else if(data == 2){
						$('#checkMsg').html('<p style="color:red">아이디를 입력해주세요!</p>')
					} else{
						$('#checkMsg').html('<p style="color:red">중복 아이디 있음! </p>')
						}
				},
			});
		});
	});
</script> -->




    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">회원 가입</h3>
                    </div>
                    <div class="panel-body">
                   		 <form role="form" method='post' action="/join" >
                            <fieldset>
                            	<label>사용자 아이디</label>  
                                <div class="form-group">
                                    <input pattern="[A-Za-z0-9]{4,10}" title="영문 숫자의 조합으로 4~10개를 입력하세요." class="form-control" placeholder="userid" id="userid" name="userid" type="text" required >
                                	<br>
                                	<button class="btn btn-lg btn-success btn-block"" type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button>
                                	<!-- <input type="button" id="button1" onclick="button1_click();" value="버튼1" /> -->
                                </div>
                                <label>비밀번호</label>  
                                <div class="form-group">
                                    <input pattern="[A-Za-z0-9]{6,10}" title="영문 숫자의 조합으로 6~10개를 입력하세요." class="form-control" placeholder="password" name="pw" type="password" required  >
                                </div>        
                               <!--  이메일 패턴       ^[a-zA-Z0-9]+@[a-zA-Z0-9]+$  --> 
                               <label>사용자 이름</label>  
                                <div class="form-group">
                                    <input pattern="[A-Za-z0-9]{3,10}" title="영문 숫자의 조합으로 3~10개를 입력하세요." class="form-control" placeholder="username" id="username"  name="username" required  >
                                </div>    
                                <label>이메일</label>  
                                <div class="form-group">
                                    <input pattern="^[a-zA-Z0-9]+@[a-zA-Z0-9]+$" title="영문 숫자의 조합을 사용하고 @ 를 넣어주세요" class="form-control" placeholder="email" id="email"  name="email"required  >
                                </div>    
                                                                                      
                                <input type="hidden" name= >
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-success btn-block">가입하기</button>
                            </fieldset>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


	
</body>

</html>
