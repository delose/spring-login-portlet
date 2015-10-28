package ph.talas.all.listing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.talas.all.listing.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
