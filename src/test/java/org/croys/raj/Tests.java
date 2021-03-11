package org.croys.raj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import static org.croys.raj.Type.*;
import static org.croys.raj.ColDef.*;
import static org.croys.raj.TypeT.*;

public class Tests {

    // FIXME: appropriate logging
    List<ColDef> cols = List.of(
        colDef( "A", INT ),
        colDef( "B", DOUBLE )
    );    

    List<ColDef> cols2 = List.of(
        colDef( "A", INT ),
        colDef( "B", DOUBLE )
    );

    List<ColDef> cols3 = List.of(
        colDef( "B", DOUBLE ),
        colDef( "A", INT )
    );

    @Test
    public void colDef_basics() {
        assertEquals( cols, cols );
        assertTrue( cols != cols2 );
        assertEquals( cols, cols2 );
        assertEquals( cols2, cols );

        assertNotEquals(cols, cols3);
        assertNotEquals(cols3, cols);

        assertEquals( "[A : INT, B : DOUBLE]", cols.toString() );
        assertEquals( cols.toString(), cols2.toString() );
        assertEquals( "[B : DOUBLE, A : INT]", cols3.toString() );
    }

    @Test
    public void colStorageInt_basics() {
        ColStorageInt s = new ColStorageInt(0);

        assertEquals( s.size(), 0);

        s.ensureCapacity(1);
        assertTrue( s.capacity() >= 1 );

        s.setSize( 2 );
        assertEquals( s.size(), 2 );
        assertTrue( s.capacity() >= 2 );
        assertEquals( s.get( 0 ), Integer.valueOf(0) );
        //assertTrue( s.get( 0 ) == 0 );
        
        s.set(0, 1);
        assertEquals( s.get( 0 ), Integer.valueOf(1) );

        s.ensureCapacity( 100 );
        assertEquals( s.get( 0 ), Integer.valueOf(1) );
    }

    @Test
    public void colStorageAdapter_basics() {
        IStorageM s = StorageFactory.make( tInt().getType() );

        assertEquals( s.size(), 0);

        s.ensureCapacity(1);
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
    public void relBuilder_basics() {
        RelBuilder rb = new RelBuilder(cols);
        assertEquals( cols, rb.cols() );
        assertEquals( 0, rb.size());

        Object vals[] = { 1, 1.0 };
        rb.add( Arrays.asList( vals ) );

        assertEquals( 1, rb.size() );
        assertEquals( vals[ 0 ], rb.get( 0, 0 ) );
        assertEquals( vals[ 1 ], rb.get( 0, 1 ) );

        rb.set( 0, 1, 2.0 );
        assertEquals( 2.0, rb.get( 0, 1 ) );
    }

}
