package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeRiskEnum;

public class TypeRiskType extends PersistentEnumUserType<TypeRiskEnum> {

    @Override
    public Class<TypeRiskEnum> returnedClass() {
        return TypeRiskEnum.class;
    }

}
