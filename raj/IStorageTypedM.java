package raj;

// Mutable, typed storage

public interface IStorageTypedM<T>
    extends IStorageTypedBase<T> {

    void    setSize( int sz );
    void    add( T el );
    void    set( int idx, T el );

    int     capacity();
    void    ensureCapacity( int minCap );

    void    copy(
         IStorageTyped<T>   from
        ,int                from_start
        ,int                from_end
        ,int                to_start
    );

    // FIXME: functionals

}
