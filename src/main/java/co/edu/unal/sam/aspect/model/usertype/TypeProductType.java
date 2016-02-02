package co.edu.unal.sam.aspect.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.aspect.model.enumerator.TypeProductEnum;

public class TypeProductType extends PersistentEnumUserType<TypeProductEnum>{

    @Override
    public Class<TypeProductEnum> returnedClass() {
        return TypeProductEnum.class;
    }
}
