package raj;

public class StorageFactory {

    public final static IStorageM make( TypeT<?> ty )
    {
        if ( ty.equals( TypeT.tInt() ) ) {
            return new ColStorageAdapter<Integer>(
                new ColStorageInt( 0 )
             );
        } else if ( ty.equals( TypeT.tDouble() ) ) {
            return new ColStorageAdapter<Double>(
                new ColStorage<Double>( 0 )
            );
        }

        return null;
    }

    public final static IStorageTypedM<?> makeT( TypeT<?> ty )
    {
        if ( ty.equals( TypeT.tInt() ) ) {
            return new ColStorageInt( 0 );
        } else if ( ty.equals( TypeT.tDouble() ) ) {
            return new ColStorage<Double>( 0 );
        }

        return null;
    }

}