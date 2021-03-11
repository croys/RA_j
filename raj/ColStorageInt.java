package raj;

public final class ColStorageInt
    implements
        IStorageTyped<Integer>,
        IStorageTypedM<Integer>
    {

    // abstract out array creation...
    // based on witness
    private int[]   m_storage;
    private int     m_size;

    ColStorageInt( int capacity )
    {
        m_storage   = new int[ capacity ];
        m_size      = 0;
    }

    private final int getCapacity()
    {
        return m_storage.length;
    }

    private final void _ensureCapacity( int required )
    {
        int cap = m_size > 0 ? m_storage.length : 0;
        if ( cap < required ) {
            if ( cap == 0 ) {
                cap = 1;
            }
            while ( cap < required ) {
                cap *= 2;
            }
            int new_storage[] = new int[ cap ];
            for ( int i = 0; i < m_size; ++i ) {
                new_storage[ i ] = m_storage[ i ];
            }
            m_storage = new_storage;
        }
    }

    // IStorageTyped<Integer>

    public Integer get( int idx )
    {
        return m_storage[ idx ];
    }

    public int size()
    {
        return m_size;
    }

    // IStorageTypedM<Integer>

    public void setSize( int sz )
    {
        _ensureCapacity( sz );
        m_size = sz;
    }

    public void add( Integer el )
    {
        _ensureCapacity( m_size + 1 );
        m_storage[ m_size++ ] = el;
    }

    public void set( int idx, Integer el )
    {
        m_storage[ idx ] = el;
    }

    public int capacity()
    {
        return getCapacity();
    }

    public void ensureCapacity( int minCap )
    {
        _ensureCapacity( minCap );
    }


    public void copy(
         IStorageTyped<Integer> from
        ,int                    from_start
        ,int                    from_end
        ,int                    to_start
    )
    {
        int len = from_end - from_start;
        _ensureCapacity( m_size + len );
        int j = to_start;
        if ( ColStorageInt.class.isInstance( from ) ) {
            ColStorageInt col = ColStorageInt.class.cast( from );
            for ( int i = from_start; i < from_end; ++i ) {
                m_storage[ j++ ] = col.m_storage[ i ];
            }
        } else {
            for ( int i = from_start; i < from_end; ++i ) {
                m_storage[ j++ ] = from.get( i );
            }
        }
    }

}
