package co.edu.unal.sam.aspect.model.usertype;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

import co.edu.unal.sam.aspect.model.domain.PersistentEnum;

/**
 * 
 * @author Andrés Mise Olivera
 * @param <T> tipo de <code>Enum</code>
 */
public abstract class PersistentEnumUserType<T> implements UserType {

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached;
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return x == y;
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor si, Object owner)
            throws HibernateException, SQLException {
        Byte id = rs.getByte(names[0]);
        if (rs.wasNull()) {
            return null;
        }
        for (T value : returnedClass().getEnumConstants()) {
            if (((PersistentEnum) value).getId().equals(id)) {
                return value;
            }
        }
        throw new IllegalStateException("Unknown " + returnedClass().getSimpleName() + " id");
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor si)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.TINYINT);
        } else {
            st.setInt(index, (int) ((PersistentEnum) value).getId());
        }
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    @Override
    public abstract Class<T> returnedClass();

    @Override
    public int[] sqlTypes() {
        return new int[] {Types.TINYINT};
    }
}
