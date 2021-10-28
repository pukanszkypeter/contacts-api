package hu.futureofmedia.task.contactsapi.usecases.company.query;

import hu.futureofmedia.task.contactsapi.models.entities.Company;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QueryCompanyInteraction implements QueryCompanyUseCase {

    private final QueryCompanyDataHandler dataHandler;

    @Override
    public List<Company> findAll() {
        return dataHandler.findAll();
    }

}
