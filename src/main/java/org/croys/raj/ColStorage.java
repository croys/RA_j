package org.croys.raj;

import java.util.Vector;

public class ColStorage<T>
    implements
         IStorageTyped<T>
        ,IStorageTypedM<T>
{
    private Vector<T>   m_storage;
    private T           m_default;

    public ColStorage( int initialCapacity, T defaultValue )
    {
        if ( defaultValue != null ) {
            m_default = defaultValue;
            m_storage = new Vector<T>( initialCapacity );
        } else {
            throw new IllegalArgumentException( "Null values are not allowed" );
        }
    }

    // IStorageTyped<T>

    public final T get( int idx ) {
        return m_storage.get(idx);
    }

    public final int size() {
        return m_storage.size();
    }

    // IStorageTypedM<T>

    public final void setSize( int sz ) {
        int old_size = m_storage.size();
        m_storage.setSize(sz);
        if ( sz > old_size ) {
            for ( int i=old_size; i<sz; ++i ) {
                m_storage.set( i, m_default );
            }
        }
    }

    public final void add( T el ) {
        if ( el != null ) {
            m_storage.add( el );
        } else {
            throw new NullPointerException();
        }
    }

    public final void set( int idx, T el ) {
        if ( el != null ) {
            m_storage.set( idx, el );
        } else {
            throw new NullPointerException();
        }
    }
    
    public final int capacity() {
        return m_storage.capacity();
    }
    public final void ensureCapacity( int minCap ) {
        m_storage.ensureCapacity( minCap );
    }

    public final void copy(
             IStorageTyped<T>   from
            ,int                from_start
            ,int                from_end
            ,int                to_start
    ) {
        for (int i = from_start; i < from_end; ++i ) {
            m_storage.set( i, from.get( i ) );
        }
    }

}
