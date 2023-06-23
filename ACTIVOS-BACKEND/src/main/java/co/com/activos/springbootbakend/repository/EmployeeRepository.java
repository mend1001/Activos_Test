package co.com.activos.springbootbakend.repository;

import co.com.activos.springbootbakend.model.Employee;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAll();

    Employee findById(long id);

    Employee save(Employee employee);

    void delete(Employee employee);
    /*funcion de suma de salarios*/
    @Query("SELECT SUM(e.salary) FROM Employee e")
    BigDecimal sumSalaries();

    @Query("SELECT e FROM Employee e WHERE e.salary = (SELECT MIN(e.salary) FROM Employee e)")
    Employee findEmployeeWithLowestSalary();

}
