package raj;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class RelType implements IsPureValue
{
    public RelType( Map<String, Type> col_map )
    {
        m_col_map = col_map;
    }

    public RelType( List<ColDef> cols )
    {
        HashMap<String, Type> m = new HashMap<String, Type>();
        for (ColDef cd : cols) {
            m.put( cd.name(), cd.type() );
        }
       m_col_map = m;
    }

    @Override
    public final String toString()
    {
        return "RelType " + m_col_map.toString();
    }

    private final Map<String, Type> m_col_map;
}
