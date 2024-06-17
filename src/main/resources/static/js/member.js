
function fetchAndDisplayData(contentId, iTag, spanTag) {
	if(iTag.attr("class") == "bi-suit-heart") {
		$.when(
			$.getJSON('/likes/insert/'+contentId),
			$.getJSON('/likes/countMembers/'+contentId),
			$.getJSON('/likes/countLikes')
		).done(function(response1, response2, response3){
			setHeart(iTag);

			spanTag.html(Number(response2[0].result) + 1);

			$(".likes-count").html(Number(response3[0].result) + 1);
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.error('Error fetching data:', errorThrown);
		});
	} else {
		$.when(
			$.getJSON('/likes/delete/'+contentId),
			$.getJSON('/likes/countMembers/'+contentId),
			$.getJSON('/likes/countLikes')
		).done(function(response1, response2, response3){
			unsetHeart(iTag);
			console.log(response1[0].result);
			spanTag.html(Number(response2[0].result));
			$(".likes-count").html(Number(response3[0].result) + 1);
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.error('Error fetching data:', errorThrown);
		});
	}	
}

function setHeart(tag) {
	tag.attr("class", "bi-suit-heart-fill");
}

function unsetHeart(tag) {
	tag.attr("class", "bi-suit-heart");
}


function checkUserid(){
	$("#checkUseridBtn").click(function(){
		
		let userid = $("#userid").val();
		
		let uri = `/member/check/${userid}`;
		
		$.getJSON(uri, function(data){
			$("#checkUseridResult").html(data.result)
		});	
	});
}

function deleteMember(userid){
	$(".delete-member").click(function(){
		let password = prompt("비밀번호를 입력하세요."); 
		
		let str = `
		<input name="userid" value="${userid}">
		<input type="password" name="password" value="${password}">
		`;
		
		$("#deleteForm")
		.html(str)
		.attr("action", "/member/delete")
		.submit();
	});
}

function validateMember(){
	
	let userid = $("#userid").val();
	if(userid == ""){
		$("#userid").focus();
		
		return false;
	}
	
	let password = $("#password").val();
	if(password == ""){
		$("#password").focus();
		return false;
	}
	
	let password2 = $("#password2").val();
	if(password2 == ""){
		$("#password2").focus();
		return false;
	}
	
	
	if(password != password2){
		$("#password").focus();
		return false;
	}
	
	
	let name = $("#name").val();
	if(name == ""){
		$("#name").focus();
		return false;
	}
	
	let age = $("#age").val();
	if(age == ""){
		$("#age").focus();
		return false;
	}
	
	let nation = $("#nation").val();
	if(nation == ""){
		$("#nation").focus();
		return false;
	}
	
	let religion = $("#religion").val();
	if(religion == ""){
		$("#religion").focus();
		return false;
	}
	
	
	return true;
	
}