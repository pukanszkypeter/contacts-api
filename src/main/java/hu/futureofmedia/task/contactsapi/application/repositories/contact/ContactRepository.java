package hu.futureofmedia.task.contactsapi.application.repositories.contact;

import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import hu.futureofmedia.task.contactsapi.models.type.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {

    List<Contact> findAllByStatus(Status status, Pageable pageable);

}
