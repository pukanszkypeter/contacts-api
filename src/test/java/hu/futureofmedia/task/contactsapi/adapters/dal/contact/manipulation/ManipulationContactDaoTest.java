package hu.futureofmedia.task.contactsapi.adapters.dal.contact.manipulation;

import hu.futureofmedia.task.contactsapi.adapters.validators.contact.ContactValidator;
import hu.futureofmedia.task.contactsapi.application.repositories.contact.ContactRepository;
import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import hu.futureofmedia.task.contactsapi.models.type.Status;
import hu.futureofmedia.task.contactsapi.utils.sourcedata.SourceDataManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ManipulationContactDaoTest {

    @Mock
    private ContactRepository repository;

    @Mock
    private SourceDataManager<Contact> sourceDataManager;

    @Mock
    private ContactValidator validator;

    @InjectMocks
    private ManipulationContactDao dao;

    @Test
    public void shouldAddContact() throws Exception {
        Contact newContact = new Contact("Test", "Test", "test@test.com", "+36 12 345 6789", 1, "Nincs", Status.ACTIVE);
        Mockito.when(repository.save(newContact)).thenReturn(newContact);

        Contact contact = dao.addContact(newContact);
        assertEquals("Test", contact.getLastName());
        assertEquals("Test", contact.getFirstName());
        assertEquals("test@test.com", contact.getEMail());
        assertEquals("+36 12 345 6789", contact.getPhoneNumber());
        assertEquals(1, contact.getCompanyId());
        assertEquals("Nincs", contact.getComment());
        assertEquals(Status.ACTIVE, contact.getStatus());
    }

}
