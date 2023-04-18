package tn.esb.lmad.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.lmad.test.Domains.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,String> {
}
