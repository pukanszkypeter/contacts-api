package hu.futureofmedia.task.contactsapi.application.services.company.query;

import hu.futureofmedia.task.contactsapi.adapters.factories.company.query.QueryCompanyUseCaseFactory;
import hu.futureofmedia.task.contactsapi.models.entities.Company;
import hu.futureofmedia.task.contactsapi.usecases.company.query.QueryCompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@Service
@SessionScope
public class QueryCompanyService {

    private final QueryCompanyUseCase useCase;

    @Autowired
    public QueryCompanyService(QueryCompanyUseCaseFactory factory) { this.useCase = factory.create(); }

    public List<Company> findALl() { return useCase.findAll(); }

}
