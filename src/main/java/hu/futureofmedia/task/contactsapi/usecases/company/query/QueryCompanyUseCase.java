package hu.futureofmedia.task.contactsapi.usecases.company.query;

import hu.futureofmedia.task.contactsapi.models.entities.Company;

import java.util.List;

public interface QueryCompanyUseCase {

    List<Company> findAll();

}
