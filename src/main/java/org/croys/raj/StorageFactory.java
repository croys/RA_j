package org.croys.raj;

import java.time.OffsetDateTime;
import java.util.Date;

public class StorageFactory {

    public final static IStorageM make( Type ty )
    {
        if ( ty.equals( TypeT.tUnit().getType() ) ) {
            return new ColStorageAdapter<Unit>(
                new ColStorage<Unit>( 0, Unit.UNIT )
            );
        } else if ( ty.equals( TypeT.tBool().getType() ) ) {
            return new ColStorageAdapter<Boolean>(
                new ColStorage<Boolean>( 0, false )
             );
        } else if ( ty.equals( TypeT.tInt().getType() ) ) {
            return new ColStorageAdapter<Integer>(
                new ColStorageInt( 0 )
             );
        } else if ( ty.equals( TypeT.tFloat().getType() ) ) {
            return new ColStorageAdapter<Float>(
                new ColStorage<Float>( 0, 0.0f )
            );
        } else if ( ty.equals( TypeT.tDouble().getType() ) ) {
            return new ColStorageAdapter<Double>(
                new ColStorageDouble( 0 )
            );
        } else if ( ty.equals( TypeT.tString().getType() ) ) {
            return new ColStorageAdapter<String>(
                new ColStorage<String>( 0, "" )
            );
        } else if ( ty.equals( TypeT.tDate().getType() ) ) {
            return new ColStorageAdapter<Date>(
                new ColStorage<Date>( 0, new Date( 0 ) )
            );
        } else if ( ty.equals( TypeT.tDatetime().getType() ) ) {
            return new ColStorageAdapter<OffsetDateTime>(
                new ColStorage<OffsetDateTime>( 0,  OffsetDateTime.MIN )
            );
        } else if ( ty.equals( TypeT.tObject().getType() ) ) {
            return new ColStorageAdapter<Object>(
                new ColStorage<Object>( 0, new Object() )
            );
        } else {
            throw new IllegalArgumentException( "Unsupported type: " + ty.toString() );
        }
    }

    private final static IStorageTypedM<?> _makeT( TypeT<?> ty )
    {
        if ( ty.equals( TypeT.tUnit() ) ) {
            return new ColStorage<Unit>( 0, Unit.UNIT );
        } else if ( ty.equals( TypeT.tBool() ) ) {
            return new ColStorage<Boolean>( 0, false );
        } else if ( ty.equals( TypeT.tInt() ) ) {
            return new ColStorageInt( 0 );
        } else if ( ty.equals( TypeT.tFloat() ) ) {
            return new ColStorage<Float>( 0, 0.0f );
        } else if ( ty.equals( TypeT.tDouble() ) ) {
            return new ColStorageDouble( 0 );
        } else if ( ty.equals( TypeT.tString() ) ) {
            return new ColStorage<String>( 0, "" );
        } else if ( ty.equals( TypeT.tDate() ) ) {
            return new ColStorage<Date>( 0, new Date( 0 ) );
        } else if ( ty.equals( TypeT.tDatetime() ) ) {
            return new ColStorage<OffsetDateTime>( 0, OffsetDateTime.MIN );
        } else if ( ty.equals( TypeT.tObject() ) ) {
            return new ColStorage<Object>( 0, new Object() );
        } else {
            throw new IllegalArgumentException( "Unsupported type: " + ty.toString() );
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> IStorageTypedM<T> makeT( TypeT<T> ty )
    {
        return (IStorageTypedM<T>)(_makeT(ty));
    }
}