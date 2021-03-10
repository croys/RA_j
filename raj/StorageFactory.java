package raj;

public class StorageFactory {

    public final static IStorageM make( TypeT<?> ty )
    {
        if ( ty.equals( TypeT.tInt() ) ) {
            return new ColStorageAdapter<Integer>(
                new ColStorageInt( 0 )
            );
        } else if ( ty.equals( TypeT.tDouble() ) ) {
            System.out.println("Double!");
        }

        return null;
    }
}