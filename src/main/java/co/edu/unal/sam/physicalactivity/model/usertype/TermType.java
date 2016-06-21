package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.physicalactivity.model.enumerator.TermEnum;

public class TermType extends PersistentEnumUserType<TermEnum> {

    @Override
    public Class<TermEnum> returnedClass() {
        return TermEnum.class;
    }

}
