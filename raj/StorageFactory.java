package raj;

public class StorageFactory {

    public final static IStorageM make(Class<?> _class) {

        if ( _class == Integer.class ) {
            System.out.println("Integer!");
        }
        if ( _class == Double.class ) {
            System.out.println("Double!");
        }


        throw new NotImplementedException();
    }
}