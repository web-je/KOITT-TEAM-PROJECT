/**
 * 2020-10-26
 * 작성자 : 진민영
 */

/**
 * 인자값으로 전체 재조회 (단일 필터)
 */

function initFilter1(){
	
	console.log(`-- filter1 on`);
	
	const types = document.querySelectorAll('.filter1');
	const filter = document.querySelector('#filter1');
	
	for (let type of types){
		type.onchange = function(e) {
			let checkedType = filter.querySelectorAll(':checked');
			if (checkedType.length === 0) {
				checkedType = document.querySelectorAll('.filter1');
				checkAll(types);
			}
			addFilter(checkedType);
		}
	}
	
	function checkAll(types) {
		for (let type of types) {
			type.checked;
		}
	}

	
	function addFilter(checkedType) {
		
		let types = [];
		for (let type of checkedType){
			types.push(type.value);
		}
		console.log(`-- add filter ${types}`);
		
		let data = JSON.stringify({"types":types});
		
		let xhr = new XMLHttpRequest();
		
		xhr.open('POST', '/add_filter', true);
		xhr.setRequestHeader('Content-Type', 'application/json');
		
		xhr.onload = function() {
			if (this.readyState == 4 && this.status == 200){
				document.querySelector('#galList').outerHTML = this.response;
			}
		}
		xhr.onerror = function() {
			console.log(this);
		}
		
		xhr.send(data);
	}
	
}

initFilter1();

/**
 * 인자값으로 전체 재조회 (다중 필터)
 */

function filter2() {
	
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

	
}