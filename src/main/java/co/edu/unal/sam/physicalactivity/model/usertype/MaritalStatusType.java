package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;

public class MaritalStatusType extends PersistentEnumUserType<MaritalStatusType> {

    @Override
    public Class<MaritalStatusType> returnedClass() {
        return MaritalStatusType.class;
    }

}
