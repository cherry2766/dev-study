<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
  // 입력값 검증 메서드 만들어서 form 태그의 onsubmit에 연결
	function submitHandler() {

		let writer = document.querySelector("input[name=writer]").value;
		let title = document.querySelector("input[name=title]").value;
		let content = document.querySelector("textarea[name=content]").value;

		// 공백 검사
		if (writer.trim() === "" || title.trim() === ""
				|| content.trim() === "") {
			alert("모든 항목을 입력해주세요.");
			return false;
		}

		// 특수문자 치환
		writer = writer.replaceAll("&", "&amp;");
		writer = writer.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		writer = writer.replaceAll("'", "&#x27;");
		writer = writer.replaceAll("\"", "&quot;");
		writer = writer.replaceAll("/", "&#x2F;");

		title = title.replaceAll("&", "&amp;");
		title = title.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		title = title.replaceAll("'", "&#x27;");
		title = title.replaceAll("\"", "&quot;");
		title = title.replaceAll("/", "&#x2F;");

		content = content.replaceAll("&", "&amp;");
		content = content.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		content = content.replaceAll("'", "&#x27;");
		content = content.replaceAll("\"", "&quot;");
		content = content.replaceAll("/", "&#x2F;");

		// 치환된 값 다시 넣기
		document.querySelector("input[name=writer]").value = writer;
		document.querySelector("input[name=title]").value = title;
		document.querySelector("textarea[name=content]").value = content;

		return true;
	}
</script>
<meta charset="UTF-8">
<title>신규 게시글 작성</title>
</head>
<body>
	<h1>신규 게시글 작성</h1>
	<!-- URL변조는 불가능 : method가 post
         파라미터는 header에 담아서 전송됨 -->
	<form action="post_new_send.jsp" method="post"
		onsubmit="return submitHandler()">
		<table>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="20" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">저장</button>
					<button type="button" onclick="location.href='post_list.jsp'">목록으로</button>
					<button type="reset">초기화</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>