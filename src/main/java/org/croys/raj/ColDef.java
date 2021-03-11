package org.croys.raj;

import java.lang.Comparable;
import java.lang.NullPointerException;

public final class ColDef
    implements IsPureValue, Comparable<ColDef>
{
    ColDef( String name, Type ty )
    {
        m_name = name;
        m_ty = ty;
    }

    public static final ColDef colDef( String name, Type ty )
    {
        return new ColDef( name, ty );
    }

    public final String name()
    {
        return m_name;
    }

    public final Type type()
    {
        return m_ty;
    }

    @Override
    public final String toString()
    {
        return m_name + " : " + m_ty.toString();
    }

    @Override
    public final int hashCode()
    {
        return m_name.hashCode() + 3 * m_ty.hashCode();
    }

    @Override
    public final boolean equals( Object o )
    {
        ColDef cd = (ColDef)o;
        return m_name.equals( cd.m_name ) && m_ty.equals( cd.m_ty );
    }


    // Comparable

    @Override
    public final int compareTo( ColDef cd )
    {
        if (cd == null) {
            throw new NullPointerException();
        } else {
            int c = m_name.compareTo( cd.m_name );
            if ( c < 0 ) {
                return -1;
            } else if ( c == 0 ) {
                return m_ty.compareTo( cd.m_ty );
            } else {
                return 1;
            }
        }
    }

    private String  m_name;
    private Type    m_ty;
}
