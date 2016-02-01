package co.edu.unal.sam.aspect.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.aspect.model.enumerator.TypeUserEnum;;

public class TypeUserType extends PersistentEnumUserType<TypeUserEnum>{

    @Override
    public Class<TypeUserEnum> returnedClass() {
        return TypeUserEnum.class;
    }
}
