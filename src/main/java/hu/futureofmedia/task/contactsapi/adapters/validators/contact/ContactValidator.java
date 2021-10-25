package hu.futureofmedia.task.contactsapi.adapters.validators.contact;

import hu.futureofmedia.task.contactsapi.application.repositories.blocklist.BlockListRepository;
import hu.futureofmedia.task.contactsapi.application.repositories.company.CompanyRepository;
import hu.futureofmedia.task.contactsapi.models.entities.BlockList;
import hu.futureofmedia.task.contactsapi.models.entities.Company;
import hu.futureofmedia.task.contactsapi.models.entities.Contact;
import hu.futureofmedia.task.contactsapi.utils.sourcedata.SourceDataValidatorManager;
import lombok.AllArgsConstructor;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ContactValidator implements SourceDataValidatorManager<Contact> {

    private final BlockListRepository blockListRepository;
    private final CompanyRepository companyRepository;

    @Override
    public void validate(Contact contact) throws ValidationException {
        validateRequiredFields(contact);
        validateEmail(contact.getEMail());
        validatePhoneNumber(contact.getPhoneNumber());
        validateCompany(contact.getCompanyId());
    }

    /// REQUIRED FIELDS
    private void validateRequiredFields(Contact contact) throws ValidationException {
        if (contact.getLastName() == null || contact.getLastName().isEmpty()) {
            throw new ValidationException("Required field (last name) is missing for data!");
        } else if (contact.getFirstName() == null || contact.getFirstName().isEmpty()) {
            throw new ValidationException("Required field (first name) is missing for data!");
        } else if ( contact.getEMail() == null || contact.getEMail().isEmpty()) {
            throw new ValidationException("Required field (e-mail) is missing for data!");
        } else if (contact.getPhoneNumber() == null || contact.getPhoneNumber().isEmpty()) {
            throw new ValidationException("Required field (phone number) is missing for data!");
        } else if (contact.getCompanyId() == 0) {
            throw new ValidationException("Required field (company id) is missing for data!");
        } else if (contact.getStatus() == null) {
            throw new ValidationException("Required field (company id) is missing for data!");
        }
    }

    /// EMAIL
    private void validateEmail(String email) throws ValidationException {
        validateFormat(email);
        String domain = email.split("@")[1];
        validateDomain(domain);
    }

    private void validateFormat(String email) throws ValidationException {
        String regex = "^[a-zA-Z0-9]{3,}[@][a-zA-Z0-9]{3,}[.][a-z]{2,4}$";
        if (!email.matches(regex)) {
            throw new ValidationException("The e-mail format is not correct!");
        }
    }

    private void validateDomain(String domain) throws ValidationException {
        List<String> blockList = ((List<BlockList>) blockListRepository.findAll())
                .stream()
                .map(BlockList::getDomain)
                .collect(Collectors.toList());

        for (String blockedDomain : blockList) {
            if (blockedDomain.equals(domain)) {
                throw new ValidationException("The given e-mail domain is on block list!");
            }
        }
    }


    /// PHONE NUMBER
    private void validatePhoneNumber(String phoneNumber) throws ValidationException {
        String regex = "^[+]36\\s\\d{2}\\s\\d{3}\\s\\d{4}$";
        if (!phoneNumber.matches(regex)) {
            throw new ValidationException("The phone number is not correct!");
        }
    }

    /// COMPANY
    private void validateCompany(Long companyId) throws ValidationException {
        Optional<Company> company = companyRepository.findById(companyId);
        if (!company.isPresent()) {
            throw new ValidationException("The company by id " + companyId + " does not exists!");
        }
    }

}
