package raj;

import java.lang.Comparable;

// Simple mono-typed type values
// See TypeT for typed (generic) values

public final class Type
    implements IPureValue, Comparable<Type> {

    public enum TyCon {
        VOID, BOOL, INT, FLOAT, DOUBLE, STRING, DATE, DATETIME, OBJECT
    }

    Type( TyCon tc )
    {
        m_tycon = tc;
    }

    @Override
    public final String toString()
    {
        return m_tycon.toString().intern();
    }
    @Override
    public final int hashCode()
    {
        return m_tycon.hashCode();
    }

    @Override
    public final boolean equals( Object o )
    {
        Type ty = (Type)o;
        return m_tycon.equals( ty.m_tycon );
    }

    // Comparable

    @Override
    public final int compareTo( Type ty )
    {
        return m_tycon.compareTo( ty.m_tycon );
    }

    // Convenience

    public static final Type VOID      = new Type( TyCon.VOID );
    public static final Type BOOL      = new Type( TyCon.BOOL );
    public static final Type INT       = new Type( TyCon.INT );
    public static final Type FLOAT     = new Type( TyCon.FLOAT );
    public static final Type DOUBLE    = new Type( TyCon.DOUBLE );
    public static final Type STRING    = new Type( TyCon.STRING );
    public static final Type DATE      = new Type( TyCon.DATE );
    public static final Type DATETIME  = new Type( TyCon.DATETIME );
    public static final Type OBJECT    = new Type( TyCon.OBJECT );

    private TyCon m_tycon;
}


