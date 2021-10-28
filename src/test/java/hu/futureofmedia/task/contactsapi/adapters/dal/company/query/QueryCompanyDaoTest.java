package hu.futureofmedia.task.contactsapi.adapters.dal.company.query;

import hu.futureofmedia.task.contactsapi.application.repositories.company.CompanyRepository;
import hu.futureofmedia.task.contactsapi.models.entities.Company;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class QueryCompanyDaoTest {

    @Mock
    private CompanyRepository repository;

    @InjectMocks
    private QueryCompanyDao dao;

    @Test
    public void shouldFindAllCompany() {
        Company example_1 = new Company(1, "Company #1");
        Company example_2 = new Company(2, "Company #2");
        Company example_3 = new Company(3, "Company #3");
        Iterable<Company> companyList = Arrays.asList(example_1, example_2, example_3);

        Mockito.when(repository.findAll()).thenReturn(companyList);

        List<Company> list =  dao.findAll();

        assertEquals(3, list.size());
        assertEquals("Company #1", list.get(0).getName());
        assertEquals(3, list.get(2).getId());
    }

}
