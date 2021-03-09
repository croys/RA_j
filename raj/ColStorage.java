package raj;

import java.util.Vector;

public class ColStorage<T> implements IStorageTypedM<T> {

    private Vector<T> m_storage;

    public ColStorage()
    {
        m_storage = new Vector<T>();
    }

    public ColStorage( int initialCapacity )
    {
        m_storage = new Vector<T>( initialCapacity );
    }

    // IStorage

    public final T get( int idx ) {
        return m_storage.get(idx);
    }

    public final int size() {
        return m_storage.size();
    }

    // IStorageM

    public final void setSize( int sz ) {
        m_storage.setSize(sz);
    }

    public final void add( T el ) {
        m_storage.add( el );
    }

    public final void set( int idx, T el ) {
        m_storage.set( idx, el );
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
