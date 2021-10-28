package hu.futureofmedia.task.contactsapi.adapters.dal.contact.query;

import hu.futureofmedia.task.contactsapi.application.repositories.company.CompanyRepository;
import hu.futureofmedia.task.contactsapi.application.repositories.contact.ContactRepository;
import hu.futureofmedia.task.contactsapi.models.dto.ContactDto;
import hu.futureofmedia.task.contactsapi.models.entities.Company;
import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import hu.futureofmedia.task.contactsapi.models.others.Page;
import hu.futureofmedia.task.contactsapi.models.type.Status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QueryContactDaoTest {

    @Mock
    private ContactRepository repository;

    @Mock
    private CompanyRepository companyRepository;

    @InjectMocks
    private QueryContactDao dao;

    // @Test
    public void shouldFindAllActive() {
    }

    @Test
    public void shouldCountAllActive() {
        Mockito.when(repository.countAllByStatus(Status.ACTIVE)).thenReturn(2);

        Integer c = dao.countAllActive();

        assertEquals(c, 2);
    }
}
