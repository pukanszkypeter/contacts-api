package hu.futureofmedia.task.contactsapi.application.configuration.company;

import hu.futureofmedia.task.contactsapi.adapters.dal.company.query.QueryCompanyDao;
import hu.futureofmedia.task.contactsapi.adapters.factories.company.query.QueryCompanyUseCaseFactory;
import hu.futureofmedia.task.contactsapi.adapters.factories.company.query.QueryCompanyUseCaseMaker;
import hu.futureofmedia.task.contactsapi.application.repositories.company.CompanyRepository;
import hu.futureofmedia.task.contactsapi.usecases.company.query.QueryCompanyDataHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyConfiguration {

    @Bean
    public QueryCompanyDataHandler queryCompanyDataHandler(CompanyRepository companyRepository) {
        return new QueryCompanyDao(companyRepository);
    }

    @Bean
    public QueryCompanyUseCaseFactory queryCompanyUseCaseFactory(QueryCompanyDataHandler queryCompanyDataHandler) {
        return new QueryCompanyUseCaseMaker(queryCompanyDataHandler);
    }

}
