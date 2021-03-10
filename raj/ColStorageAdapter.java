package raj;

public class ColStorageAdapter<T>
    implements IStorage, IStorageM
{
    ColStorageAdapter( IStorageTypedM<T> storage )
    {

    }
    
    // IStorage
    public Object get( int idx )
    {
        throw new NotImplementedException();
    }

    public int size()
    {
        throw new NotImplementedException();
    }

    // IStorageM
    public void setSize( int sz )
    {
        throw new NotImplementedException();
    }
    public void add( Object el )
    {
        throw new NotImplementedException();
    }
    public void set( int idx, Object el )
    {
        throw new NotImplementedException();
    }

    public int capacity()
    {
        throw new NotImplementedException();
    }
    public void ensureCapacity( int minCap )
    {
        throw new NotImplementedException();
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
