package hu.futureofmedia.task.contactsapi.application.repositories.company;

import hu.futureofmedia.task.contactsapi.models.entities.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company, Long> {
}
