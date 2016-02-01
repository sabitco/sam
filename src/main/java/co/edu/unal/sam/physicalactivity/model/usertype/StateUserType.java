package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.physicalactivity.model.enumerator.StateEnum;

public class StateUserType extends PersistentEnumUserType<StateEnum>{

    @Override
    public Class<StateEnum> returnedClass() {
        return StateEnum.class;
    }
}
