package koitt.ratta.doeat.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 유저의 권한 Repository, JPA 사용.
 * 
 * @author GW
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
