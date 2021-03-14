package org.croys.raj;

public class StorageFactory {

    public final static IStorageM make( Type ty )
    {
        if ( ty.equals( TypeT.tInt().getType() ) ) {
            return new ColStorageAdapter<Integer>(
                new ColStorageInt( 0 )
             );
        } else if ( ty.equals( TypeT.tDouble().getType() ) ) {
            return new ColStorageAdapter<Double>(
                new ColStorage<Double>( 0, 0.0 )
            );
        }

        throw new NotImplementedException();
    }

    public final static IStorageTypedM<?> makeT( TypeT<?> ty )
    {
        if ( ty.equals( TypeT.tInt() ) ) {
            return new ColStorageInt( 0 );
        } else if ( ty.equals( TypeT.tDouble() ) ) {
            return new ColStorage<Double>( 0, 0.0 );
        }

        throw new NotImplementedException();
    }

}