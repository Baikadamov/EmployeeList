package kz.narxoz.javaee.finalSpring.repository;

import kz.narxoz.javaee.finalSpring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
