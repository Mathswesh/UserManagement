package org.example.usermanagement.Reposatory;

import org.example.usermanagement.Model.Userdomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepo extends JpaRepository<Userdomain, Integer> {
}
