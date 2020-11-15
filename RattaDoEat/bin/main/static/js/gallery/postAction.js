/**
 * 2020-10-26
 * 작성자: 진민영
 */

'use strict';

addEvent();

function addEvent(){
	
	const isLikeTrues = document.querySelectorAll('.isLikeTrue');
	const isLikeFalses = document.querySelectorAll('.isLikeFalse');
		
	isLikeTrues.forEach(function(isLikeTrue){
		isLikeTrue.onmouseover = function() {
			this.textContent = `unlike`;
		}
		isLikeTrue.onmouseout = function() {
			this.textContent = `like`;
		}
	})
	
	isLikeFalses.forEach(function(isLikeFalse){
		isLikeFalse.onmouseover = function() {
			this.textContent = `like`;
		}
		isLikeFalse.onmouseout = function() {
			this.textContent = `unlike`;
		}
	})
	
}

/**
 * 게시글 좋아요
 */
function like(gIdx) {
	console.log(`-- request to send -- post ${gIdx} like +1`);
		
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'gallery_like?gIdx=' + gIdx, true);
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			if (this.response == 0){	// 실패
				return;
			}else{	// 성공
				document.querySelector('#galList').outerHTML = this.response;
				addEvent();
			}
		}
	}
	
	xhr.onerror = function() {
		console.log(this);
	}
		
	xhr.send();
}

/**
 * 게시글 좋아요 취소
 */
function unlike(gIdx) {
	console.log(`-- request to send -- post ${gIdx} like -1`);
		
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'gallery_unlike?gIdx=' + gIdx, true);
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			if (this.response == 0){	// 실패
				return;
			}else{	// 성공
				document.querySelector('#galList').outerHTML = this.response;
				addEvent();
			}
		}
	}
	
	xhr.onerror = function() {
		console.log(this);
	}
		
	xhr.send();
}

/**
 * 게시글 스크랩
 */
function scrap(gIdx) {
	console.log(`-- request to send -- post ${gIdx} scarp -1`);
		
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'gallery_unscrap?gIdx=' + gIdx, true);
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			if (this.response == 0){	// 실패
				return;
			}else{	// 성공
				document.querySelector('#galList').outerHTML = this.response;
			}
		}
	}
		
	xhr.onerror = function() {
		console.log(this);
	}
		
	xhr.send();
}

/**
 * 게시글 스크랩 취소
 */
function scrap(gIdx) {
	console.log(`-- request to send -- post ${gIdx} scarp +1`);
		
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'gallery_scrap?gIdx=' + gIdx, true);
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			if (this.response == 0){	// 실패
				return;
			}else{	// 성공
				document.querySelector('#galList').outerHTML = this.response;
			}
		}
	}
		
	xhr.onerror = function() {
		console.log(this);
	}
		
	xhr.send();
}