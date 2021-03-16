package org.croys.raj;

import java.util.List;

public class RelationDum
    implements IRelation
{
    private static final RelType _TYPE = new RelType( List.of() );

    public RelType type()
    {
        return _TYPE;
    }

    public int rows()
    {
        return 0;
    }

    public int cols()
    {
        return 0;
    }

    public Object get( int r, int c )
    {
        return null;
    }

}
