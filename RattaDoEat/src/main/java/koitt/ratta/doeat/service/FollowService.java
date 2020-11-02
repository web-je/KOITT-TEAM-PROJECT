package koitt.ratta.doeat.service;

public interface FollowService {

	int addFollow(int LoginUIdx, int uIdx);

	int unFollow(int loginUIdx, int uIdx);

}
