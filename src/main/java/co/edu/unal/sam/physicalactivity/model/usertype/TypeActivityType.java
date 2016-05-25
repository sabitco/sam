package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeActivityEnum;

public class TypeActivityType extends PersistentEnumUserType<TypeActivityEnum> {

    @Override
    public Class<TypeActivityEnum> returnedClass() {
        return TypeActivityEnum.class;
    }
}
