package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.physicalactivity.model.enumerator.IntensityEnum;

public class IntensityType extends PersistentEnumUserType<IntensityEnum> {

    @Override
    public Class<IntensityEnum> returnedClass() {
        return IntensityEnum.class;
    }
}
