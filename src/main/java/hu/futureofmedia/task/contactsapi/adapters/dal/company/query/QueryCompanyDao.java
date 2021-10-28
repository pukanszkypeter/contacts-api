package hu.futureofmedia.task.contactsapi.adapters.dal.company.query;

import hu.futureofmedia.task.contactsapi.application.repositories.company.CompanyRepository;
import hu.futureofmedia.task.contactsapi.models.entities.Company;
import hu.futureofmedia.task.contactsapi.usecases.company.query.QueryCompanyDataHandler;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QueryCompanyDao implements QueryCompanyDataHandler {

    private final CompanyRepository repository;

    @Override
    public List<Company> findAll() {
        return (List<Company>) repository.findAll();
    }

}
