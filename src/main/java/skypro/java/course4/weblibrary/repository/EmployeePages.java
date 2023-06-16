package skypro.java.course4.weblibrary.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import skypro.java.course4.weblibrary.model.Employee;

import java.util.List;

public interface EmployeePages extends PagingAndSortingRepository<Employee, Integer> {


}
