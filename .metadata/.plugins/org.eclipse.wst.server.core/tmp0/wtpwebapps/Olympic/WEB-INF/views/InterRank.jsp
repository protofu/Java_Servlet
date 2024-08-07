<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InterRank</title>
</head>
<body>
	<h1>InterRank Page</h1>
	<button 
		class="btn btn-outline-success collapse-button" 
		data-bs-toggle="collapse" data-bs-target="#addForm"
		aria-expanded="false" aria-contribute="addForm">
		나라 등록
	</button>
	
	<div class="collapse" id="addForm">
		<div class="card card-body">
			<form 
				action="/olympic/rank?action=addInter" 
				method="POST"
				enctype="multipart/form-data"
			>
				<label for="name" class="form-label">국가 이름</label>
				<input id="name" name="name" class="form-control" required />
				
				<label for="flag" class="form-label">국기</label>
				<input id="flag" type="file" name="flag" class="form-control" required />
				<!--  
				<label for="gold" class="form-label">금메달 수</label>
				<input id="gold" type="number" name="gold" class="form-control" required />
				
				<label for="silver" class="form-label">은메달 수</label>
				<input id="silver" type="number" name="silver" class="form-control" required />
				
				<label for="bronze" class="form-label">동메달 수</label>
				<input id="bronze" type="number" name="bronze" class="form-control" required />
				-->
				<button class="btn btn-success mt-3">저장</button>
			</form>
		</div>
	</div>
</body>
</html>