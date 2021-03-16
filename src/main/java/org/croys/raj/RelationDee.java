package org.croys.raj;

import java.util.List;

public class RelationDee
    implements IRelation
{
    private static final RelType _TYPE = new RelType( List.of() );

    public RelType type()
    {
        return _TYPE;
    }

    public int rows()
    {
        return 1;
    }

    public int cols()
    {
        return 0;
    }

    public Object get( int row, int col )
    {
        return null;
    }
}
