/**
 * 2020-10-31
 * 작성자 : 진민영
 */
 
/**
 * url 복사
 */
 
function shareURL(gIdx) {

	document.querySelector(`#shareURL${gIdx}`).style.display = 'none';
	document.querySelector(`#shareKakao${gIdx}`).style.display = 'inline';
	document.querySelector(`#copyURL${gIdx}`).style.display = 'inline';
	
}

function shareKakao(gIdx) {

	Kakao.Link.sendCustom({
		templateId: 39719,
		templateArgs: {
			'userId':'testUser',
			'likeCnt':'99999',
			'shareImg':'img.jpeg',
			'types':'#type1 #type2 #type3',
			'gIdx':gIdx
		}
	});
	
//	Kakao.Link.sendScrap({
//		requestUrl: 'https://www.naver.com'
//	});
	
}

 
function copyURL(gIdx) {

	/**
	 * 해당 글로 이동하는 url
	 */
	 
	let url = document.querySelector(`#goPost${gIdx}`).href;
	
	
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

Kakao.init('2171bdd725e11855b657feead72cfa35');
Kakao.isInitialized();