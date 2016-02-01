package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.physicalactivity.model.enumerator.TypeQuestionEnum;

public class TypeQuestionUserType extends PersistentEnumUserType<TypeQuestionEnum> {

    @Override
    public Class<TypeQuestionEnum> returnedClass() {
        return TypeQuestionEnum.class;
    }

}
