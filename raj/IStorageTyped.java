package raj;

// Immutable, typed access to storage

public interface IStorageTyped<T> {
    T       get( int idx );
    int     size();
}
