<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
    crossorigin="anonymous">
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
    crossorigin="anonymous">
</script>
<link href="${pageContext.request.contextPath}/style.css" rel="stylesheet">
<meta charset="UTF-8">
<title>InterRank</title>
</head>
<body>
    <div class="container mt-5">
        <h2 class="text-center mb-4">올림픽 메달 순위</h2>
        <hr/>
        <c:choose>
            <c:when test="${not empty rankList}">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table.custom-table">
                        <thead class="table-top-color">
                            <tr>
                                <th scope="col" class="text-center">순위</th>
                                <th scope="col" class="text-center">이름</th>
                                <th scope="col" class="text-center">🥇</th>
                                <th scope="col" class="text-center">🥈</th>
                                <th scope="col" class="text-center">🥉</th>
                                <th scope="col" class="text-center">합계</th>
                                <th scope="col" class="text-center">삭제</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="inter" items="${rankList}" varStatus="s">
                                <tr>
                                    <th scope="row" class="text-center"">${s.count}</th>
                                    <td class="d-flex align-items-center justify-content-center">
                                        <a class="text-name" href="/olympic/inter-detail?id=${inter.getId()}">
                                            <img class="flag-inter" alt="국기" src="/flag/${inter.getFlag()}"> ${inter.getName()}
                                        </a>
                                    </td>
                                    <td class="medal-count gold-medal">${inter.getGold()}</td>
                                    <td class="medal-count silver-medal">${inter.getSilver()}</td>
                                    <td class="bronze-medal medal-count">${inter.getBronze()}</td>
                                    <td class="medal-count">${inter.getGold() + inter.getSilver() + inter.getBronze()}</td>
                                    <td class="text-center">
                                        <a href="/olympic/rank?action=deleteInter&id=${inter.getId()}">
                                            <span class="badge bg-danger badge-delete" onclick="confirmDelete(${inter.getId()})">&times;</span>
                                        </a> 
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-warning text-center" role="alert">
                    참가한 나라가 없습니다.
                </div> 
            </c:otherwise>
        </c:choose>
        <div class="text-center">
            <button 
                class="btn btn-outline-success collapse-button" 
                data-bs-toggle="collapse" data-bs-target="#addForm"
                aria-expanded="false" aria-controls="addForm">
                나라 등록
            </button>
        </div>
        <div class="collapse mt-4" id="addForm">
            <div class="card card-body">
                <form 
                    action="/olympic/rank?action=addInter" 
                    method="POST"
                    enctype="multipart/form-data"
                >
                    <div class="mb-3">
                        <label for="name" class="form-label">국가 이름</label>
                        <input id="name" name="name" class="form-control" required />
                    </div>
                    <div class="mb-3">
                        <label for="flag" class="form-label">국기</label>
                        <input id="flag" type="file" name="flag" class="form-control" required />
                    </div>
                    <div class="mb-3">
                        <label for="content" class="form-label">국가 설명</label>
                        <textarea id="content" name="content" rows="5" cols="50" class="form-control"></textarea>
                    </div>
                    <button class="btn btn-success mt-3">저장</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
