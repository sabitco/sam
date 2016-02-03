package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeNewEnum;

public class TypeNewType extends PersistentEnumUserType<TypeNewEnum>{

    @Override
    public Class<TypeNewEnum> returnedClass() {
        return TypeNewEnum.class;
    }
}
