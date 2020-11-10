/**
 * 2020-11-02
 * 작성자 : 진민영
 */
'use strict';

addEvent();

function addEvent(){

	const isFollowTrues = document.querySelectorAll(`.isFollowTrue`);
	
	const isFollowFalses = document.querySelectorAll(`.isFollowFalse`);
	
	isFollowTrues.forEach(function(isFollowTrue){
		isFollowTrue.onmouseover = function() {
			this.textContent = `unFollow`;
		}
		isFollowTrue.onmouseout = function() {
			this.textContent = `following`;
		}
		isFollowTrue.onclick = function() {
			let uIdx = this.className.charAt(this.className.length-1);
			unFollow(uIdx);
		}
	});
	
	isFollowFalses.forEach(function(isFollowfalse){
		isFollowfalse.onmouseover = function() {
			this.textContent = `goFollow`;
		}
		isFollowfalse.onmouseout = function() {
			this.textContent = `follow`;
		}
		isFollowfalse.onclick = function() {
			let uIdx = this.className.charAt(this.className.length-1);
			following(uIdx);
		}
	});
	
}

function unFollow(uIdx) {
	
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'unfollow?uIdx=' + uIdx, true);
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(`-- unfollow user ${uIdx}`);
			document.querySelector('#galList').outerHTML = this.response;
			addEvent();
		}
	}
	
	xhr.onerror = function(){
		console.log(this);
	}
	
	xhr.send();
}

function following(uIdx) {
	
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'following?uIdx=' + uIdx, true);
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(`-- follow user ${uIdx}`);
			document.querySelector('#galList').outerHTML = this.response;
			addEvent();
		}
	}
	
	xhr.onerror = function(){
		console.log(this);
	}
	
	xhr.send();
	
}