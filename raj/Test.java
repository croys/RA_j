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

        ColStorageInt s0 = new ColStorageInt(0);
        assert s0.size() == 0;
        s0.ensureCapacity(1);
        assert s0.size() == 0;
        assert s0.capacity() >= 1;
        s0.setSize(2);
        assert s0.size() == 2;
        assert s0.capacity() >= 2;

        assert s0.get(0) == 0;
        s0.set(0, 1);
        assert s0.get(0) == 1;
        s0.ensureCapacity(100);
        assert s0.get(0) == 1;

        // IStorageM col0 = StorageFactory.make( tInt() );
        // assert col0.size() == 0;

        {
            IStorageM s = StorageFactory.make( tInt() );
            System.out.println(s);
            System.out.println( "size: " + s.size());
            assert s.size() == 0;
            System.out.println( "capacity: " + s.capacity());
            s.ensureCapacity(1);
            System.out.println( "capacity: " + s.capacity());
            assert s.size() == 0;
            assert s.capacity() >= 1;
            s.setSize( 2 );
            System.out.println( "size: " + s.size());
            System.out.println( "capacity: " + s.capacity());
            assert s.size() == 2;
            assert s.capacity() >= 2;
            assert s.get( 0 ).equals( 0 );
            System.out.println( "get(0): " + s.get(0) );
            s.set(0, 1);
            assert s.get(0).equals( 1 );
            System.out.println( "get(0): " + s.get(0) );
            s.ensureCapacity(100);
            assert s.get(0).equals( 1 );
            System.out.println( "get(0): " + s.get(0) );

        }
        // IStorageTypedM<Integer> colT0 =
        //     castInterface< IStorageTypedM<Integer> >( col0 );
        // try {
        //      colT0 = (IStorageTypedM<Integer>)StorageFactory.makeT( tInt() );
        // } catch (Exception e) {
        //     // ignore
        // }

        // IStorageTypedM<Integer> colT0 = (IStorageTypedM<Integer>)sf.makeT( tInt() );
        // assert colT0.size() == 0;
        // col0.setSize( 2 );
        // assert col0.size() == 2;
//        IStorageTypedM< Integer > col0t = (IStorageTypedM< Integer >)(col0);



        //sf.make( tDouble() );
    }
}
