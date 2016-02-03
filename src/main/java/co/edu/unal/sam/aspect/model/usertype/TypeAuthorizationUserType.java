package co.edu.unal.sam.aspect.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.aspect.model.enumerator.TypeAuthorizationEnum;

public class TypeAuthorizationUserType extends
		PersistentEnumUserType<TypeAuthorizationEnum> {

	@Override
	public Class<TypeAuthorizationEnum> returnedClass() {
		return TypeAuthorizationEnum.class;
	}
}
