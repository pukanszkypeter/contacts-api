package hu.futureofmedia.task.contactsapi.utils.sourcedata;

import hu.futureofmedia.task.contactsapi.models.BaseEntity;

import javax.xml.bind.ValidationException;

public interface SourceDataValidatorManager<Data extends BaseEntity> {

    void validate(Data data) throws ValidationException;

}
