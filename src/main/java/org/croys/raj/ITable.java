package org.croys.raj;

public interface ITable extends IsPure {

    RelType     type();
    int         rows();
    int         cols();
    Object      get( int r, int c );

}
