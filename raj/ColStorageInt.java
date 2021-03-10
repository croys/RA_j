package raj;

public class ColStorageInt
    implements
        IStorageTyped<Integer>,
        IStorageTypedM<Integer>
    {

    private int   m_capacity;
    private int[] m_storage;
    private int   m_size;

    ColStorageInt( int capacity )
    {
        m_capacity  = capacity;
        m_storage   = new int[capacity];
        m_size      = 0;
    }

    // IStorageTyped<Integer>

    public Integer get( int idx )
    {
        throw new NotImplementedException();
    }

    public int size()
    {
        throw new NotImplementedException();
    }

    // IStorageTypedM<Integer>

    public void setSize( int sz )
    {
        throw new NotImplementedException();
    }

    public void add( Integer el )
    {
        throw new NotImplementedException();
    }

    public void set( int idx, Integer el )
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
         IStorageTyped<Integer> from
        ,int                    from_start
        ,int                    from_end
        ,int                    to_start
    )
    {
        throw new NotImplementedException();
    }

}
