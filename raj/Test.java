package raj;

import java.util.List;
//import java.util.Map;

import static raj.Type.*;
import static raj.ColDef.*;
import static raj.TypeT.*;

public class Test {
    public static void main(String[] args) {
        Type baz = INT;
        System.out.println( baz );

        ColDef my_col  = new ColDef( "A", INT );
        System.out.println( my_col );
        
        List<ColDef> cols = List.of(
            colDef( "A", INT ),
            colDef( "B", DOUBLE )
        );
        System.out.println( cols );

        List<ColDef> cols2 = List.of(
            colDef( "A", INT ),
            colDef( "B", DOUBLE )
        );
        System.out.println( cols2 );

        System.out.println( cols == cols2 );
        System.out.println( cols.equals( cols2 ) );

        List<ColDef> cols3 = List.of(
            colDef( "B", DOUBLE ),
            colDef( "A", INT )
        );
        System.out.println( cols3 );
        System.out.println( cols3.equals( cols ) );

        RelType rty = new RelType( cols3 );
        System.out.println( rty.toString() );

        TypeList< Integer, TypeList< Double, TypeListNil >> my_val;

        StorageFactory sf = new StorageFactory();
        sf.make( tInt() );
        sf.make( tDouble() );
    }
}
