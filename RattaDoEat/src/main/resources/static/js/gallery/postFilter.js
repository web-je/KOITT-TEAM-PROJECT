/**
 * 2020-10-26
 * 작성자 : 진민영
 */

/**
 * 인자값으로 전체 재조회 (단일 필터)
 */
const filter = document.querySelectorAll('.filter');

for (let type of filter){
	type.onchange = function(e) {
		console.log(e);
//		addFilter(this.value);
	}
}

function addFilter (type) {
	console.log(`--add filter ${type}`);
	
	let xhr = new XMLHttpRequest();
	xhr.open('GET', '/add_filter?type=' + type, true);
	
	xhr.onlaod = function() {
		console.log(this);
		if (this.readyState == 4 && this.status == 200){
			document.querySelector('#galList').outerHTML = this.response;
		}
	}
	xhr.onerror = function() {
		console.log(this);
	}
	
	xhr.send();
}

/**
 * 인자값으로 전체 재조회 (다중 필터)
 */

const filter = document.querySelectorAll('.filter');

for (let type of filter){
	type.onchange = function(e) {
		console.log(e);
//		addFilter(this.value);
	}
}

function addFilter (type) {
	console.log(`--add filter ${type}`);
	
	let xhr = new XMLHttpRequest();
	xhr.open('GET', '/add_filter?type=' + type, true);
	
	xhr.onlaod = function() {
		console.log(this);
		if (this.readyState == 4 && this.status == 200){
			document.querySelector('#galList').outerHTML = this.response;
		}
	}
	xhr.onerror = function() {
		console.log(this);
	}
	
	xhr.send();
}
