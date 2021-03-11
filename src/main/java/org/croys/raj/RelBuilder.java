package org.croys.raj;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public final class RelBuilder {

    RelBuilder( List<ColDef> cols )
    {
        m_col_defs  = cols;
        m_size      = 0;

        m_cols = new Vector<IStorageM>();
        for (ColDef def : cols) {
            m_cols.add( StorageFactory.make( def.type() ) );
        }
    }

    public List<ColDef> cols()
    {
        return m_col_defs;
    }

    public int size()
    {
        return m_size;
    }

    public Object get( int r, int c )
    {
        return m_cols.get( c ).get( r );
    }

    public <T, U extends Iterable<T>> void add( U vals )
    {
        Iterator<T> iter = vals.iterator();
        int n_elems = 0;
        while (iter.hasNext()) {
            iter.next();
            ++n_elems;
        }
        if (n_elems == m_col_defs.size()) {
            iter = vals.iterator();
            Iterator<IStorageM> colIter = m_cols.iterator();
            while ( iter.hasNext() ) {
                IStorageM col = colIter.next();
                col.add( iter.next() );
            }
            ++m_size;
        } else {
            throw new IllegalArgumentException(
                "Number of supplied values does nto match number of columns" );
        }
    }

    public void set( int r, int c, Object val )
    {
        m_cols.get( c ).set( r, val );
    }


    private int                 m_size;
    private List<ColDef>        m_col_defs;
    private Vector<IStorageM>   m_cols;
}

