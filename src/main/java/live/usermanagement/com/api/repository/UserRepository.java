package live.usermanagement.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import live.usermanagement.com.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
