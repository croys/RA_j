package org.croys.raj;

public class ColStorageAdapter<T>
    implements IStorage, IStorageM
{
    private IStorageTypedM<T>   m_storage;

    ColStorageAdapter( IStorageTypedM<T> storage )
    {
        m_storage   = storage;
    }
    
    // IStorage
    public Object get( int idx )
    {
        return m_storage.get( idx );
    }

    public int size()
    {
        return m_storage.size();
    }

    // IStorageM
    public void setSize( int sz )
    {
        m_storage.setSize(sz);
    }

    @SuppressWarnings("unchecked")
    public void add( Object el )
    {
        m_storage.add( (T)el );
    }

    @SuppressWarnings("unchecked")
    public void set( int idx, Object el )
    {
        m_storage.set( idx, (T)el );
    }


    public int capacity()
    {
        return m_storage.capacity();
    }
    public void ensureCapacity( int minCap )
    {
        m_storage.ensureCapacity( minCap );
    }

    public void copy(
         IStorage   from
        ,int        from_start
        ,int        from_end
        ,int        to_start
    )
    {
        throw new NotImplementedException();
    }

}
