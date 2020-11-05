/**
 * 2020-10-26
 * 작성자 : 진민영
 */

/**
 * 인자값으로 전체 재조회
 */

const types1 = document.querySelectorAll('.filter1');
const filter1 = document.querySelector('#filter1');

const types2 = document.querySelectorAll('.filter2');
const filter2 = document.querySelector('#filter2');

let checkedType1 = filter1.querySelectorAll(':checked');
let checkedType2 = filter2.querySelectorAll(':checked');

let sortColumn = 'reg_date';

function sort(column){
	sortColumn = column;
	sendFilter();
}

for (let type of types1){
	type.onchange = function() {
		filterEvent();
	}
}

for (let type of types2){
	type.onchange = function() {
		filterEvent();
	}
}

function filterEvent(){
	
	checkedType1 = filter1.querySelectorAll(':checked');
	checkedType2 = filter2.querySelectorAll(':checked');
	
	if (checkedType1.length === 0) {
		checkedType1 = document.querySelectorAll('.filter1');
		checkAll(types1);
	}
	
	sendFilter();
	
}

function checkAll(types) {
	for (let type of types) {
		type.checked;
	}
}

function sendFilter() {
	
	let types1 = [];
	for (let type of checkedType1){
		types1.push(type.value);
	}	
	
	let types2 = [];
	for (let type of checkedType2){
		types2.push(type.value);
	}
	
	if (types1.length == 0) {
		types1.push("");
		
	}
	
	if (types2.length == 0) {
		types2.push("");
		
	}
	
	let data = JSON.stringify({
		"types1":types1,
		"types2":types2,
		"column":[sortColumn]
		});
	
	let xhr = new XMLHttpRequest();
	
	xhr.open('POST', 'filter_on', true);
	xhr.setRequestHeader('Content-Type', 'application/json');
	
	xhr.onload = function() {
		if (this.readyState == 4 && this.status == 200){
		
			console.log(`-- filter on ${types1} // ${types2}`);
			console.log(`-- sort by ${sortColumn}`);
			
			document.querySelector('#galList').outerHTML = this.response;
		}
	}
	xhr.onerror = function() {
		console.log(this);
	}
	
	xhr.send(data);
	
}