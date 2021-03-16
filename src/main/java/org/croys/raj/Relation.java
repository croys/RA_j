package org.croys.raj;

import java.util.List;
import java.util.HashMap;
import java.util.Vector;

public class Relation implements
    IRelation
{
    
    Relation( List<ColDef> colDefs, List<IStorage> storage )
    {
        // FIXME: just add type() to IStorageM?
        int n, m;

        if ( colDefs == null ) {
            n = 0;
            m_ty = new RelType( List.of() );
        } else {
            n = colDefs.size();
            m_ty = new RelType( colDefs );
        }

        if ( storage == null ) {
            m = 0;
        } else {
            m = storage.size();
        }

        if ( n != m ) {
            throw new IllegalArgumentException(
                "Column definitions do not mactch column storage"
            );
        }
        m_cols = n;

        // map of column name -> storage

        // FIXME: streams and collect?
        var storage_map = new HashMap< String, IStorage >();

        for ( int i = 0; i < n; ++i ) {
            storage_map.put( colDefs.get( i ).name(), storage.get( i ) );
        }

        // build our storage vector
        m_storage = new Vector< IStorage >();
        for ( var cd : m_ty.cols() ) {
            m_storage.add( storage_map.get( cd.name() ) );
        }

        int rows = 0;
        for ( int i = 0; i < m_storage.size(); ++i ) {
            if ( i == 0 ) {
                rows = m_storage.get( i ).size();
            }
            if ( m_storage.get( i ).size() != rows ) {
                throw new IllegalArgumentException(
                    "Storage for column " + i
                    + " has inconsisten size");
            }
        }
        m_rows = rows;
    }

    // ITable

    public RelType type()
    {
        return m_ty;
    }

    public int rows()
    {
        return m_rows;
    }

    public int cols()
    {
        return m_cols;
    }

    // get row/column
    public Object get( int  r, int c ) {
        return m_storage.get( c ).get( r );
    }
    // get column name, row
    // get row

    // map over rows?


    // Convenience

    private final static IRelation _DEE = new RelationDee();

    public static IRelation dee()
    {
        return _DEE;
    }

    private final static IRelation _DUM = new RelationDum();

    public static IRelation dum()
    {
        return _DUM;
    }

    public static IRelation fromBuilder( RelBuilder builder )
    {
        return new Relation( builder.cols(), builder.takeStorage() );
    }

    private RelType             m_ty;
    private int                 m_rows;
    private int                 m_cols;
    private Vector< IStorage >  m_storage;

}
