package API_sportNew.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import API_sportNew.entity.useraccount;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public interface  UserRepository  extends JpaRepository<useraccount, Integer> {
	useraccount findByEmail(String email);
    useraccount findByUsernameOrEmail(String username, String email);
    useraccount findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

