package hu.futureofmedia.task.contactsapi.application.configuration.contact;

import hu.futureofmedia.task.contactsapi.adapters.dal.contact.manipulation.ManipulationContactDao;
import hu.futureofmedia.task.contactsapi.adapters.dal.contact.query.QueryContactDao;
import hu.futureofmedia.task.contactsapi.adapters.factories.contact.manipulation.ManipulationContactUseCaseFactory;
import hu.futureofmedia.task.contactsapi.adapters.factories.contact.manipulation.ManipulationContactUseCaseMaker;
import hu.futureofmedia.task.contactsapi.adapters.factories.contact.query.QueryContactUseCaseFactory;
import hu.futureofmedia.task.contactsapi.adapters.factories.contact.query.QueryContactUseCaseMaker;
import hu.futureofmedia.task.contactsapi.adapters.validators.contact.ContactValidator;
import hu.futureofmedia.task.contactsapi.application.repositories.blocklist.BlockListRepository;
import hu.futureofmedia.task.contactsapi.application.repositories.company.CompanyRepository;
import hu.futureofmedia.task.contactsapi.application.repositories.contact.ContactRepository;
import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import hu.futureofmedia.task.contactsapi.usecases.contact.manipulation.ManipulationContactDataHandler;
import hu.futureofmedia.task.contactsapi.usecases.contact.query.QueryContactDataHandler;
import hu.futureofmedia.task.contactsapi.utils.sourcedata.SourceDataManagement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactConfiguration {

    @Bean
    public SourceDataManagement<Contact> contactSourceDataManagement() {
        return new SourceDataManagement<>();
    }

    @Bean
    public QueryContactDataHandler queryContactDataHandler(ContactRepository contactRepository, CompanyRepository companyRepository) {
        return new QueryContactDao(contactRepository, companyRepository);
    }

    @Bean
    public QueryContactUseCaseFactory queryContactUseCaseFactory(QueryContactDataHandler queryContactDataHandler) {
        return new QueryContactUseCaseMaker(queryContactDataHandler);
    }

    @Bean
    public ContactValidator contactValidator(BlockListRepository blockListRepository, CompanyRepository companyRepository) {
        return new ContactValidator(blockListRepository, companyRepository);
    }

    @Bean
    public ManipulationContactDataHandler manipulationContactDataHandler(ContactRepository contactRepository, SourceDataManagement<Contact> sourceDataManagement, ContactValidator contactValidator) {
        return new ManipulationContactDao(contactRepository, sourceDataManagement, contactValidator);
    }

    @Bean
    public ManipulationContactUseCaseFactory manipulationContactUseCaseFactory(ManipulationContactDataHandler manipulationContactDataHandler) {
        return new ManipulationContactUseCaseMaker(manipulationContactDataHandler);
    }

}
