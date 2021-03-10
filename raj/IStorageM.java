package raj;

// Mutable storage

public interface IStorageM extends IStorageBase {
    void    setSize( int sz );
    void    add( Object el );
    void    set( int idx, Object el );

    int     capacity();
    void    ensureCapacity( int minCap );

    void copy(
         IStorage   from
        ,int        from_start
        ,int        from_end
        ,int        to_start
    );

    // FIXME: functionals
}
