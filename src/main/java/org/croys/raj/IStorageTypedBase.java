package org.croys.raj;

// Immutable, typed access to storage

public interface IStorageTypedBase<T> {
    T       get( int idx );
    int     size();
}
