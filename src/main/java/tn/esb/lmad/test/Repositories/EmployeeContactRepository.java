package tn.esb.lmad.test.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esb.lmad.test.Domains.Seat;

public interface EmployeeContactRepository extends JpaRepository<Seat,Long> {
}
