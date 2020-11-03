/**
 * 작성자 GW
 */
package koitt.ratta.doeat.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String>{

	public Users findByUsername(String username);

}
