/**
 * 2020-10-26
 * 작성자 : 진민영
 */

/**
 * 인자값으로 내림차순 정렬
 */
function sort(column) {
	console.log(`-- sort by ${column}`);
	
	let xhr = new XMLHttpRequest();
	xhr.open('GET', '/sort_by?column=' + column, true);
		
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.querySelector('#galList').outerHTML = this.response;
		}
	}
	xhr.onerror = function() {
		console.log(this);
	}
	
	xhr.send();
}