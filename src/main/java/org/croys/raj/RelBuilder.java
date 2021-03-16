package org.croys.raj;

import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public final class RelBuilder {

    RelBuilder( List<ColDef> cols )
    {
        m_col_defs  = cols;
        clear();
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

    public < T, U extends Collection<T> > RelBuilder add( U vals )
    {
        var n_elems = vals.stream().count();

        // FIXME: use stream zipper in Guava
        if ( n_elems == m_col_defs.size() ) {
            var iter = vals.iterator();
            var colIter = m_cols.iterator();
            while ( iter.hasNext() ) {
                colIter.next().add( iter.next() );
            }
            ++m_size;
        } else {
            throw new IllegalArgumentException(
                "Number of supplied values does not match number of columns" );
        }
        return this;
    }

    public void set( int r, int c, Object val )
    {
        m_cols.get( c ).set( r, val );
    }

    public void clear()
    {
        m_size = 0;
        m_cols = m_col_defs.stream().map(
                cd -> StorageFactory.make( cd.type() )
            ).collect( Collectors.toCollection( Vector::new ) );
    }

    public List< IStorage > takeStorage()
    {
        var v = m_cols.stream().map( s -> (IStorage)s )
            .collect( Collectors.toCollection( Vector::new ) );
        clear();
        return (List<IStorage>)v;
    }

    private int                 m_size;
    private List<ColDef>        m_col_defs;
    private Vector<IStorageM>   m_cols;
}

