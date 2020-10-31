/**
 * 2020-10-31
 * 작성자 : 진민영
 */
function shareURL(gIdx) {

	/**
	 * 해당 글로 이동하는 url
	 */
	 
	let url = document.querySelector('#goPost'+gIdx).href;
	
	
	/**
	 * 임시 textarea 생성하여 선택 복사 
	 */
	 
	try{
	
		let textarea = document.createElement("textarea");
		textarea.style.display = "none";
		document.body.appendChild(textarea);
		textarea.value = url;
		textarea.select();
		document.execCommand('copy');
		console.log(textarea);
		document.body.removeChild(textarea);
	
		/**
		 * 성공시 처리
		 */	
		 
		alert(`${url} 복사 성공`);
		
	} catch (e) {
	
		/**
		 * 실패시 처리
		 */
		 
		console.log(e)
		alert(`${url} 복사 실패`);
	
	}
	
}