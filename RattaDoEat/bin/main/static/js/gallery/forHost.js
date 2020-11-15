/**
 * 2020-11-09
 * 작성자 : 진민영
 * 비회원을 위한 스크립트 수정
 */
'use strict';

/**
 * 회원 팔로우 onclick event 덮어쓰기
 */
const isFollowFalses = document.querySelectorAll(`.isFollowFalse`);

isFollowFalses.forEach(function(isFollowFalse){
	isFollowFalse.onclick = function(){
		goJoin();
	};
});

/**
 * 게시글 좋아요 onclick event 덮어쓰기
 */
const likes = document.querySelectorAll(`.like`);

likes.forEach(function(like){
	like.onclick = function(){
		goJoin();
	}
})

/**
 * 게시글 좋아요 취소 onclick event 덮어쓰기
 */
const unlikes = document.querySelectorAll(`.unlike`);

likes.forEach(function(like){
	like.onclick = function(){
		goJoin();
	}
})

/**
 * 가입 유도 팝업으로 대체하기
 */
function goJoin(){
	alert(`로그인 후에 이용이 가능합니다 (로그인/회원가입 유도하는 팝업으로 대체)`);
	return;
}