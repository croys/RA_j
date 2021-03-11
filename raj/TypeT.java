package raj;

import java.util.Date;
import java.time.OffsetDateTime;

/*
    Discussion

    In many other languages, we'd use traits or similar to map from
    language-native static types to type values (and operations).
    However, Java does not allow this approach, as due to extensive
    type-erasure and choices in separate compilation, we cannot
    re-ify generic type instances.

    So, instead we do things the other way around - explicitly construct
    type values, the type of which is generic. This means we have
    an isomorphism between the generic type and values by construction,
    and we get the same benefits of a traits-based system.

    Note: we could just subclass from Type instead of using the IType interface...

    */

public class TypeT<T> implements IsPure /* IType */ {

    private Type m_ty;

    TypeT( Type ty )
    {
        m_ty = ty;
    }

    public final Type getType()
    {
        return m_ty;
    }

    // Note: t prefix is to avoid issues with Double, etc..

    // FIXME: might want to prefix these with T to avoid conflict with Type statics

    private final static TypeT<Void> VOID = new TypeT<Void>( Type.VOID );
    public final static TypeT<Void> tVoid()
    {
        return VOID;
    }

    private final static TypeT<Integer> INT = new TypeT<Integer>( Type.INT );
    public final static TypeT<Integer> tInt()
    {
        return INT;
    }

    private final static TypeT<Float> FLOAT = new TypeT<Float>( Type.FLOAT );
    public final static TypeT<Float> tFloat()
    {
        return FLOAT;
    }

    private final static TypeT<Double> DOUBLE = new TypeT<Double>( Type.DOUBLE );
    public final static TypeT<Double> tDouble()
    {
        return DOUBLE;
    }

    private final static TypeT<String> STRING = new TypeT<String>( Type.STRING );
    public final static TypeT<String> tString()
    {
        return STRING;
    }

    private final static TypeT<Date> DATE = new TypeT<Date>( Type.DATE );
    public final static TypeT<Date> tDate()
    {
        return DATE;
    }

    private final static TypeT<OffsetDateTime> DATETIME =
        new TypeT<OffsetDateTime>( Type.DATETIME );
    public final static TypeT<OffsetDateTime> tDatetime()
    {
        return DATETIME;
    }

    private final static TypeT<Object> OBJECT = new TypeT<Object>( Type.OBJECT );
    public final static TypeT<Object> tObject()
    {
        return OBJECT;
    }



}
