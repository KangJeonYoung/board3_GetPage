<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!DOCTYPE html>
<html lang="UTF-8">
<%@include file="includes/header.jsp" %>


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">메인 페이지</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
                <!-- /.col-lg-4 -->
                <div class="col-lg-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                          	  웹 사이트 소개
                        </div>
                        <div class="panel-body">
                             <p> 이 웹 사이트는 Spring을 사용하여 DB와 연결을 한 사이트 입니다. </br>
                	여러 사람들과 취직에 관련해 팁을 공유하거나 정보를 공유하기 위해서 만든 사이트 입니다.</br>
                	자유롭게 이야기를 하며, 커뮤니티 활동을 하시면 됩니다. </p>
                        </div>
                    </div>
                </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	<h3 align="center">공지 사항</h3>
                            <!-- <buttom id='regBtn' type="button" class="btn btn-sx pull-right">글 쓰 기</buttom> -->
                            
                            <%-- <c:if test="${model == '1' }">
                            	<buttom type="button" onclick="location.href='/admin'" class="btn btn-sx">관리자 계정</buttom>
                            </c:if>  --%>
                            <%-- <input type="text" value="${model }"> --%>
                            
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>#번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>수정일</th>
                                        </tr>
                                    </thead>
                                    
                                </table>
                              <%--   세션얻어오는 방법
                                <% session.getAttribute(${); %> --%>
                                <!-- Modal 추가 -->
					          	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					          		aria-labelledby="myModalLabel" aria-hidden="true">
					          		<div class = "modal-dialog">
					          			<div class="modal-content">
					          				<div class="modal-header">
					          					<button type="button" class = "close" data-dismiss="modal" 
					          						aria-hidden="true">&times;</button>
					          					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					          				</div>
					          				<div class = "modal-body">처리가 완료되었습니다.</div>
					          				<div class="modal-footer">
					          					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					          					<!-- <button type="button" class="btn btn-primary">Save changes</button> -->
					          				</div>
					          			</div>
					          			<!-- /.modal-content -->
					          		</div>
					          		<!-- /.modal-dialog -->
					          	</div>
					          	<!-- /.modal -->
					          	
                            </div>
                            <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-6 -->
            </div>

			<div class="row">
			     <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><h1>취업성공 패키지</h1></div>
                                    <div>현재 3개의 자료</div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer" data-toggle="modal" data-target="#exampleModal1">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
                
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-bar-chart-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge"><h1>취업 통계 표</h1></div>
                                    <div> 서울시  / 인천  / 경기도  </div>
                                </div>
                            </div>
                        </div>
                        <a href="#">
                            <div class="panel-footer" data-toggle="modal" data-target="#exampleModal" >
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                
			</div>
			
			<!-- class를 통해 모달을 선언하고 투명에서 밝아지는 효과(fade)를 준다. 여기서 가장 중요한거는 id 입니다. 위에 타겟과 동일해야 합니다. #은 아이디 .은 클래스 -->
			<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<!-- class를 주목하시면  여기 클레스에 modal-lg, modal-sm을 입력하시면 스몰 모달, 라지 모달로 선언이 가능 합니다. -->
			<!-- 위에 설명 예 : <div class="modal-dialog modal-sm" role="document"> -->
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			       <!-- 모달 이름 -->
			        <h1 class="modal-title" id="exampleModalLabel">취업 성공 패키지</h1>
			        <button type="button" class="close" data-dismiss="modal1" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      
			      	<!-- 모달의 내용 -->
			        <div class="showSlides">
						<div class="mySlides">
						  <div class="numbertext" style="float: right; font-size: 1.17em;">1 / 3</div>
						  <a href='https://www.work.go.kr/pkg/succ/board/promoteList.do' ><img src="https://www.work.go.kr/framework/filedownload/getImage.do?filePathName=sBAeiCAlbxgqaTxaqk0dE4qhWH0PKuA9Tb2nYxuDTPWx1FSPvExga7Yx9hnNE8RGyBZ%2Fetu3vT9xo1asYYcaHw%3D%3D" width="100%" height="400">
							</a>
						</div>
						
						<div class="mySlides">
						  <div class="numbertext" style="float: right; font-size: 1.17em">2 / 3</div>
						  <a href='https://www.work.go.kr/pkg/succ/board/promoteList.do' ><img src="https://www.work.go.kr/framework/filedownload/getImage.do?filePathName=sBAeiCAlbxgqaTxaqk0dE4qhWH0PKuA9Tb2nYxuDTPXezFzWJURGMJlqgfKU4euWC2n9j7M29683OQbVNuPJIA%3D%3D" width="100%" height="400">
						  </a>
						</div>
						
						<div class="mySlides">
						  <div class="numbertext" style="float: right; font-size: 1.17em">3 / 3</div>
						  <a href='https://www.work.go.kr/pkg/succ/board/promoteList.do' ><img src="https://www.work.go.kr/framework/filedownload/getImage.do?filePathName=sBAeiCAlbxgqaTxaqk0dE4qhWH0PKuA9Tb2nYxuDTPWZ9QQMiOniJ%2FJkM2rakLiapz0EDz3bz9fhbR%2BG5zKeQg%3D%3D" width="100%" height="400">
						  </a>
						</div>
						<div style="float: right; font-size: 2.0em">
						<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
						<a class="next" onclick="plusSlides(1)">&#10095;</a>
						</div>
					</div>
					<br>
			      </div>
			      <div class="modal-footer">
			        <!-- data-dismiss="modal"를 통해 모달을 닫을수 있다. -->
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			      </div>
			    </div>
			  </div>
			</div>
	
			<!-- class를 통해 모달을 선언하고 투명에서 밝아지는 효과(fade)를 준다. 여기서 가장 중요한거는 id 입니다. 위에 타겟과 동일해야 합니다. #은 아이디 .은 클래스 -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<!-- class를 주목하시면  여기 클레스에 modal-lg, modal-sm을 입력하시면 스몰 모달, 라지 모달로 선언이 가능 합니다. -->
			<!-- 위에 설명 예 : <div class="modal-dialog modal-sm" role="document"> -->
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			       <!-- 모달 이름 -->
			        <h1 class="modal-title" id="exampleModalLabel">취업 통계표(남/녀 통합)</h1>
			        <button type="button" class="close" data-dismiss="modal1" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body">
			      
			      	<!-- 모달의 내용 -->
			        <img border="0" src="resources/img/get_job_re.png">
					<br>
			      </div>
			      <div class="modal-footer">
			        <!-- data-dismiss="modal"를 통해 모달을 닫을수 있다. -->
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
			      </div>
			    </div>
			  </div>
			</div>

			
			
			
			
<!--                 <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Modals
                        </div>
                        /.panel-heading
                        <div class="panel-body">
                            Button trigger modal
                            <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
                                Launch Demo Modal
                            </button>
                            Modal
                            <div class="modal fade" id="myModal" tabindex="1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    /.modal-content
                                </div>
                                /.modal-dialog
                            </div>
                            /.modal
                        </div>
                        .panel-body
                    </div>
                    /.panel
                </div>


					          	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					          		aria-labelledby="myModalLabel" aria-hidden="true">
					          		<div class = "modal-dialog">
					          			<div class="modal-content">
					          				<div class="modal-header">
					          					<button type="button" class = "close" data-dismiss="modal" 
					          						aria-hidden="true">&times;</button>
					          					<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					          				</div>
					          				<div class = "modal-body">처리안됐눈데?</div>
					          				<div class="modal-footer">
					          					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					          					<button type="button" class="btn btn-primary">Save changes</button>
					          				</div>
					          			</div>
					          			/.modal-content
					          		</div>
					          		/.modal-dialog
					          	</div>


            <script type="text/javascript">
            	$(document).ready(function(){
            		var result = '<c:out value="${result}"/>';
		            checkModal(result);
            
        		    function checkModal(result){
            	
            			if(result === ''){
            				return;
            			}
            	
           			 	if (parseInt(result) >0){
            				console.log("들어옴?");
            				$(".modal-body").html("게시글" + parseInt(result) + " 번이 등록되었습니다.");
            			}
            	
            			$("#myModal").modal("show");
            		}
        		    
        		    $("#regBtn").on("click", function(){
        		    	self.location = "/board/register";
        		    });
            	});
            </script> -->
            



	<!-- 아래코드는 footer -->
<%@ include file="includes/footer.jsp" %>

       <script>
		var id = <%=(String)session.getAttribute("id")%>

		if(id == null){
			// 거치적 거리면 alert 부분 삭제 가능.
			location.href="/login"
			alert('로그인을 해주세요.');
		} else{}

      </script>  
  <script>
var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > slides.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = slides.length}
  for (i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}
</script>           
            
</body>

</html>
