package org.croys.raj;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.croys.raj.Type.*;
import static org.croys.raj.ColDef.*;
import static org.croys.raj.TypeT.*;

public class Tests {

    // FIXME: appropriate logging
    List<ColDef> cols0 = List.of(
        colDef( "A", INT ),
        colDef( "B", DOUBLE )
    );    

    List<ColDef> cols1 = List.of(
        colDef( "A", INT ),
        colDef( "B", DOUBLE )
    );

    List<ColDef> cols2 = List.of(
        colDef( "B", DOUBLE ),
        colDef( "A", INT )
    );

    @Test
    public void colDef_basics() {
        assertEquals( cols0, cols0 );
        assertTrue( cols0 != cols1 );
        assertEquals( cols0, cols1 );
        assertEquals( cols1, cols0 );

        assertNotEquals(cols0, cols2 );
        assertNotEquals( cols2, cols0 );

        assertEquals( "[A : INT, B : DOUBLE]", cols0.toString() );
        assertEquals( cols0.toString(), cols1.toString() );
        assertEquals( "[B : DOUBLE, A : INT]", cols2.toString() );
    }



    public void int_storage_basics( IStorageTypedM<Integer> s )
    {
        assertEquals( s.size(), 0 );

        s.ensureCapacity( 1 );
        assertTrue( s.capacity() >= 1 );
        assertEquals( 0, s.size() );

        s.setSize( 2 );
        assertEquals( s.size(), 2 );
        assertTrue( s.capacity() >= 2 );
        assertEquals( Integer.valueOf( 0 ), s.get( 0 ) );

        s.set( 0, 1 );
        assertEquals( Integer.valueOf( 1 ), s.get( 0 ) );

        assertThrows( NullPointerException.class, () -> s.set( 0, null ) );

        s.ensureCapacity( 100 );
        assertEquals( Integer.valueOf( 1 ), s.get( 0 ) );

        s.add( 3 );
        assertEquals( 3, s.size() );
        assertEquals( Integer.valueOf( 3 ) , s.get( 2 ) );

        assertThrows( NullPointerException.class, () -> s.add( null ) );
    }

    public void double_storage_basics( IStorageTypedM<Double> s )
    {
        assertEquals( s.size(), 0 );

        s.ensureCapacity( 1 );
        assertTrue( s.capacity() >= 1 );
        assertEquals( 0, s.size() );

        s.setSize( 2 );
        assertEquals( s.size(), 2 );
        assertTrue( s.capacity() >= 2 );
        assertEquals( Double.valueOf( 0.0 ), s.get( 0 ) );
        
        s.set( 0, 1.0 );
        assertEquals( Double.valueOf( 1.0 ), s.get( 0 ) );

        assertThrows( NullPointerException.class, () -> s.set( 0, null) );

        s.ensureCapacity( 100 );
        assertEquals( Double.valueOf( 1.0 ), s.get( 0 ) );

        s.add( 3.0 );
        assertEquals( 3, s.size() );
        assertEquals( Double.valueOf( 3.0 ) , s.get( 2 ) );

        assertThrows( NullPointerException.class, () -> s.add( null ) );
    }


    @Test
    public void colStorageInt_basics() {

        IStorageTypedM<Integer> s = new ColStorageInt( 0 );
        int_storage_basics( s );
    }

    @Test
    public void colStorageInteger_basics() {
        IStorageTypedM<Integer> s = new ColStorage<Integer>( 0, 0 );
        int_storage_basics( s );
    }

    @Test
    public void colStorageDouble_basics() {
        IStorageTypedM<Double> s = new ColStorage<Double>( 0, 0.0 );
        double_storage_basics( s );
    }

    @Test
    public void colStorageDoubleArray_basics() {
        IStorageTypedM<Double> s = new ColStorageDouble( 0 );
        double_storage_basics( s );
    }

    @Test
    public void colStorageAdapter_basics() {
        IStorageM s = new ColStorageAdapter< Integer >( new ColStorageInt( 0 ) );

        assertEquals( s.size(), 0 );

        s.ensureCapacity( 1 );
        assertTrue( s.capacity() >= 1 );

        s.setSize( 2 );
        assertEquals( s.size(), 2 );
        assertTrue( s.capacity() >= 2 );
        
        assertEquals( s.get( 0 ), 0 );

        s.set(0, 1);
        assertEquals( s.get( 0 ), 1 );

        s.ensureCapacity( 100 );
        assertEquals( s.get(0), 1 );
    }

    @Test
    public void storageFactory_basics() {
        {
            IStorageTypedM<Integer> s = StorageFactory.makeT( tInt() );
            int_storage_basics( s );
        }
        {
            IStorageTypedM<Double> s = StorageFactory.makeT( tDouble() );
            double_storage_basics(s);
        }

    }

    @Test
    public void relBuilder_basics() {
        RelBuilder rb = new RelBuilder( cols0 );
        assertEquals( cols0, rb.cols() );
        assertEquals( 0, rb.size() );

        Object vals[] = { 1, 1.0 };
        rb.add( Arrays.asList( vals ) );

        assertEquals( 1, rb.size() );
        assertEquals( vals[ 0 ], rb.get( 0, 0 ) );
        assertEquals( vals[ 1 ], rb.get( 0, 1 ) );

        rb.set( 0, 1, 2.0 );
        assertEquals( 2.0, rb.get( 0, 1 ) );

        rb.set( 0, 0, 1 );
        assertEquals( 1, rb.get( 0, 0 ) );

        assertThrows( Exception.class, () -> rb.set( 0, 0, null ) );
        assertThrows( Exception.class, () -> rb.set( 0, 1, null ) );

    }

    RelType rty0 = new RelType( cols0 );
    RelType rty1 = new RelType( cols1 );
    RelType rty2 = new RelType( cols2 );
    RelType rty_empty = new RelType( List.of() );

    @Test
    public void relTy_basics() {

        assertEquals( rty0, rty0 );
        assertEquals( rty1, rty1 );
        assertEquals( rty0, rty1 );
        assertEquals( rty1, rty0 );
        assertEquals( rty0, rty2 );
        assertEquals( rty2, rty0 );

        assertEquals( "RelType [A : INT, B : DOUBLE]", rty0.toString() );

        assertEquals( rty_empty, rty_empty );
        assertEquals( "RelType []", rty_empty.toString() );

        assertNotEquals( rty_empty, rty0 );
        assertNotEquals( rty0, rty_empty );
        assertNotEquals( rty_empty, rty1 );
        assertNotEquals( rty1, rty_empty );
        assertNotEquals( rty_empty, rty2 );
        assertNotEquals( rty2, rty_empty );
    }

    @Test
    public void relTy_ops() {
        assertEquals( rty_empty, RelType.union( rty_empty, rty_empty ) );
        assertEquals( rty0, RelType.union( rty0, rty_empty ) );
        assertEquals( rty0, RelType.union( rty_empty, rty0 ) );
        assertEquals( rty0, RelType.union( rty0, rty0 ) );
    }

}
