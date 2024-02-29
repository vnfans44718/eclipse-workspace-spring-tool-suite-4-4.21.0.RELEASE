
function join_form_validation_submit_button() {
	/*
	DOM Tree에있는 form엘레멘트객체에 접근하는방법
		1. window.document.form태그의name속성값
		   ex> window.document.joinForm
		2. window.document.forms배열객체[index]
		   ex> window.document.forms[0]
		3. document객체의 getElementById()메쏘드를 사용해서 form객체검색
		   ex> document.getElementById("form태그id속성값");
			 - HTML Tag
				 <form id='joinForm'>
				 </form>
				 (엘레멘트의 아이디는 HTML파일안에서 유일해야됩니다.)
			 - javascript
				   var joinFormObject = document.getElementById('joinForm');
				 (DOM Tree에서 id가 joinForm인 엘레멘트객체를반환) 
		   
	form객체안에있는 input엘레멘트객체접근방법
		1.form객체.input태그의이름
		   ex> window.document.joinForm.id
		
	*/
	let joinForm = document.getElementById("joinForm");

	if (joinForm.id.value == null || joinForm.id.value == '') {
		alert('아이디를 입력하세요');
		document.joinForm.id.focus();
		return false;
	}
	if (joinForm.password.value == null || joinForm.password.value == '') {
		alert('패쓰워드를 입력하세요');
		document.joinForm.password.focus();
		return false;
	}
	if (joinForm.repassword.value == null || joinForm.repassword.value == '') {
		alert('패쓰워드확인을 입력하세요');
		document.joinForm.repassword.focus();
		return false;
	}

	if (joinForm.name.value == null || joinForm.name.value == '') {
		alert('이름를 입력하세요');
		document.joinForm.name.focus();
		return false;
	}
	if (joinForm.address.value == null || joinForm.address.value == '') {
		alert('주소를 입력하세요');
		document.joinForm.address.focus();
		return false;
	}
	if (!isSame(joinForm.password.value, joinForm.repassword.value)) {
		alert("패쓰워드와 패쓰워드확인은 일치하여야합니다.");
		document.joinForm.password.select();
		return false;
	}


	if (!(joinForm.id.value.length >= 5 && joinForm.id.value.length <= 10)) {
		alert("길이 확인");
		document.joinForm.id.select();
		return false;
	}

	let idValue = joinForm.id.value;

	for (let i = 0; i < idValue.length; i++) {
		if (!((idValue[i] >= 'A' && idValue[i] <= 'Z') ||
			(idValue[i] >= 'a' && idValue[i] <= 'z') ||
			(idValue[i] >= '0' && idValue[i] <= '9'))) {
			alert("아이디는 영문 대소문자와 숫자만 허용됩니다.");
			document.joinForm.id.select();
			return false;
		}
	}


	if (!(('A' <= idValue.charAt(0) && idValue.charAt(0) <= 'Z') || ('a' <= idValue.charAt(0) && idValue.charAt(0) <= 'z'))) {
		alert("아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다.");
		document.joinForm.id.select();
		return false;
	}



	/*if(!(joinForm.id.valueOf.length>=5 && joinForm.id.valueOf.length<=10))
{alert("길이 확인");
document.joinForm.id.select();
return false;
}*/

	/*
	1.아이디는 5~10자여야한다
	2.영문알파벳대문자,소문자,숫자만 가능
	3.아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)
	*/





	return true;
}






function join_form_validation_button() {
	// validation
	if (!join_form_validation_submit_button()) {
		return;
	}
	document.joinForm.method = 'POST';
	document.joinForm.action = 'join_action.jsp';
	document.joinForm.submit();
	/*
	1.아이디는 5~10자여야한다
	2.영문알파벳대문자,소문자,숫자만 가능
	3.아이디의 첫글자는 영문알파벳대문자,소문자만 가능합니다(숫자로 시작할수없다)
	*/

}	