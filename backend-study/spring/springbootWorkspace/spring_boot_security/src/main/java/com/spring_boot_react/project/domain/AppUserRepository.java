package com.spring_boot_react.project.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// rest api 정보 전송에 바로 사용되게 됨
// exported 속성값을 false로 설정하면 외부 노출이 금지됨
@RepositoryRestResource(exported = false)
public interface AppUserRepository extends CrudRepository<AppUser, Long>{
	Optional<AppUser> findByUsername(String username);
}
