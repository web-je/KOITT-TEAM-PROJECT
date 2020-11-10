/**
 * 2020-11-09
 * 작성자 : 진민영
 */
'use strict';

const isFollowFalses = document.querySelectorAll(`.isFollowFalse`);

isFollowFalses.forEach(function(isFollowFalse){
	isFollowFalse.onclick = function(){
		goJoin();
	};
});

function goJoin(){
	alert(`회원가입 페이지로 이동합니다`);
	return;
}