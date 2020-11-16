package koitt.ratta.doeat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class SessionQualifier {
	
	/**
	 * (민영) 세션 테스트 과정 임시로 적어둠 ㅠ
	 */
	@Autowired
	HttpSession session;
	
	public void AuthSession() {
		
		// 서버리빌드시 세션 유지 <옵션이 켜진 상태에서
		// 리빌드 하면 세션은 유지되고 userInfo가 사라집니다..
		if (session.getAttribute("userInfo") == null) {
			System.out.println("유저인포를 살리는 로직");
		}
	}

}
