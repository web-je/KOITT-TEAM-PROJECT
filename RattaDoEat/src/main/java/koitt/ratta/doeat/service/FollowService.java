package koitt.ratta.doeat.service;

public interface FollowService {

	public void addFollow(int LoginUIdx, int uIdx);

	public void unFollow(int loginUIdx, int uIdx);

}
