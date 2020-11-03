/**
 * 작성자 GW
 */
package koitt.ratta.doeat.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByRole(String role);
	public Role findByUsername(String username);
}
