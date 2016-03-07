package co.edu.unal.sam.aspect.model.usertype;

import co.edu.unal.sam.aspect.model.usertype.PersistentEnumUserType;
import co.edu.unal.sam.aspect.model.enumerator.TypePageEnum;

public class TypePageType extends PersistentEnumUserType<TypePageEnum> {

	@Override
	public Class<TypePageEnum> returnedClass() {
		return TypePageEnum.class;
	}
}
