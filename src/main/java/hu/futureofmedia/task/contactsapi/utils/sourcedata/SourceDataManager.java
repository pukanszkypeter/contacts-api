package hu.futureofmedia.task.contactsapi.utils.sourcedata;

import hu.futureofmedia.task.contactsapi.models.BaseEntity;

import javax.xml.bind.ValidationException;

public interface SourceDataManager<Data extends BaseEntity> {

    void setMetaData(Data data);

    void validate(Data data, SourceDataValidatorManager<Data> dataValidator) throws ValidationException;

}
