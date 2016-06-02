package co.edu.unal.sam.physicalactivity.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.physicalactivity.model.enumerator.BmiCategoryEnum;

public class BmiCategoryType extends PersistentEnumUserType<BmiCategoryEnum> {

    @Override
    public Class<BmiCategoryEnum> returnedClass() {
        return BmiCategoryEnum.class;
    }
}
