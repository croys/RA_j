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

    // If we exclude set and copy, and only allow add/extend
    // then we have more choice of storage formats
    // mainly want this for strings
    // could use our own stringview into a pool of char[]
    // would be possible to still do this with set and copy
    // with storage separate from the main array

    // FIXME: functionals
}
