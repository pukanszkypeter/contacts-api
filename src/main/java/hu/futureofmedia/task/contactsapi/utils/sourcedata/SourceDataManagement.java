package hu.futureofmedia.task.contactsapi.utils.sourcedata;

import hu.futureofmedia.task.contactsapi.models.BaseEntity;
import lombok.AllArgsConstructor;

import javax.xml.bind.ValidationException;
import java.util.Calendar;
import java.util.Date;

@AllArgsConstructor
public class SourceDataManagement<Data extends BaseEntity> implements SourceDataManager<Data> {

    /** TODO: Distinguish between the creating and modifying case.
     * The task only implements add use case for entities that is
     * why the creation and modification date are the same. */
    @Override
    public void setMetaData(Data data) {
        Date date = Calendar.getInstance().getTime();
        data.setCreated(date);
        data.setModified(date);
    }

    /** TODO: Later on it should be an abstract class, because many validation types are based on the same rules.
     *  From now on we create for every entity a specific validator.  */
    @Override
    public void validate(Data data, SourceDataValidatorManager<Data> dataValidator) throws ValidationException {
        dataValidator.validate(data);
    }

}
