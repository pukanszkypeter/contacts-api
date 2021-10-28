package hu.futureofmedia.task.contactsapi.adapters.factories.company.query;

import hu.futureofmedia.task.contactsapi.usecases.company.query.QueryCompanyDataHandler;
import hu.futureofmedia.task.contactsapi.usecases.company.query.QueryCompanyInteraction;
import hu.futureofmedia.task.contactsapi.usecases.company.query.QueryCompanyUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QueryCompanyUseCaseMaker implements QueryCompanyUseCaseFactory {

    private final QueryCompanyDataHandler dataHandler;

    @Override
    public QueryCompanyUseCase create() {
        return new QueryCompanyInteraction(dataHandler);
    }

}
