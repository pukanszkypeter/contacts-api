package hu.futureofmedia.task.contactsapi.adapters.dal.contact.query;

import hu.futureofmedia.task.contactsapi.application.repositories.company.CompanyRepository;
import hu.futureofmedia.task.contactsapi.application.repositories.contact.ContactRepository;
import hu.futureofmedia.task.contactsapi.models.dto.ContactDto;
import hu.futureofmedia.task.contactsapi.models.entities.Company;
import hu.futureofmedia.task.contactsapi.models.others.Page;
import hu.futureofmedia.task.contactsapi.models.type.Status;
import hu.futureofmedia.task.contactsapi.usecases.contact.query.QueryContactDataHandler;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class QueryContactDao implements QueryContactDataHandler {

    private final ContactRepository repository;
    private final CompanyRepository companyRepository;

    @Override
    public List<ContactDto> findAllActive(Page page) {

        /** Sort is fixed by ABC.
         *  Paging comes from client, which index and how big offset. */
        Sort sortByABC = Sort.by("lastName").ascending().and(Sort.by("firstName").ascending());
        Pageable pageable = PageRequest.of(page.getIndex(), page.getOffset(), sortByABC);

        return repository.findAllByStatus(Status.ACTIVE, pageable)
                .stream()
                .map( projection -> new ContactDto(
                        projection.getId(),
                        projection.getLastName(),
                        projection.getFirstName(),
                        projection.getEMail(),
                        projection.getPhoneNumber(),
                        companyRepository.findById(projection.getCompanyId()).map(Company::getName).orElse(null),
                        projection.getComment(),
                        projection.getStatus()
                ))
                .collect(Collectors.toList());
    }

}
