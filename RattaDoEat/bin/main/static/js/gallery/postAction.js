/**
 * 2020-10-26
 * 작성자: 진민영
 */

/**
 * 게시글 좋아요 +1
 */
function like(gIdx) {
	console.log(`-- request to send -- post ${gIdx} like +1`);
		
	let xhr = new XMLHttpRequest();
	xhr.open('GET', '/gallery_like?gIdx=' + gIdx, true);
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			if (this.response == 0){	// 실패
				return;
			}else{	// 성공
				document.querySelector(`#likeNum${gIdx}`).textContent = this.response;
			}
		}
	}
	
	xhr.onerror = function() {
		console.log(this);
	}
		
	xhr.send();
}

/**
 * 게시글 스크랩 +1
 */
function scrap(gIdx) {
	console.log(`-- request to send -- post ${gIdx} scarp +1`);
		
	let xhr = new XMLHttpRequest();
	xhr.open('GET', '/gallery_scrap?gIdx=' + gIdx, true);
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			if (this.response == 0){	// 실패
				return;
			}else{	// 성공
				document.querySelector(`#scrapNum${gIdx}`).textContent = this.response;
			}
		}
	}
		
	xhr.onerror = function() {
		console.log(this);
	}
		
	xhr.send();
}