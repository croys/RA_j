package org.croys.raj;

import java.util.Vector;
import java.util.List;
import java.util.HashSet;
import java.util.Collections;
import java.util.HashMap;

public class RelType
    implements
         IsPureValue
{
    RelType()
    {
        m_cols = new Vector<ColDef>();
    }

    RelType( List<ColDef> cols )
    {
        m_cols = new Vector<ColDef>();
        var col_names = new HashSet<String>();
        for ( var cd : cols) {
            if ( col_names.contains( cd.name() ) ) {
                throw new IllegalArgumentException(
                    "Repeated column: " + cd.name()
                );
            } else {
                col_names.add( cd.name() );
                m_cols.add( cd );
            }
        }
        Collections.sort( m_cols );
    }

    // FIXME: immutable list
    public final List<ColDef> cols()
    {
        return m_cols;
    }

    @Override
    public final String toString()
    {
        return "RelType " + m_cols.toString();
    }

    @Override
    public final int hashCode()
    {
        return m_cols.hashCode();
    }

    @Override
    public final boolean equals( Object o )
    {
        var r_ty = (RelType)o;
        return m_cols.equals( r_ty.m_cols );
    }

    private Vector<ColDef> m_cols;

    public final static RelType union( RelType a, RelType b )
    {
        var r = new RelType();
        r.m_cols.addAll( a.m_cols );

        var a_map = new HashMap< String, Type >();
        for ( var cd : a.m_cols ) {
            a_map.put( cd.name(), cd.type() );
        }

        for ( var cd : b.m_cols ) {
            var b_name = cd.name();
            var b_ty = cd.type();
            var a_ty = a_map.get( b_name );
            if ( a_ty == null ) {
                r.m_cols.add( cd );
            } else if ( !a_ty.equals( b_ty ) ) {
                throw new IllegalArgumentException(
                    "Column '" + b_name + "' has conflicting types:\n  "
                    + a_ty.toString()
                    + "\nand:  " + b_ty.toString()
                );
            }
        }
        Collections.sort( r.m_cols );
        return r;
    }
}
