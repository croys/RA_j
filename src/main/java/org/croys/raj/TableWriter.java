package org.croys.raj;

import java.util.Vector;
import java.io.IOException;
import java.io.Writer;

public class TableWriter {
    public final static void write(
        Writer  wr
       ,ITable  tbl
    ) throws IOException
    {
        var widths = new Vector< Integer >();

        for ( var cd : tbl.type().cols() ) {
            widths.add( cd.name().length() );
        }

        for ( int c = 0; c < tbl.cols(); ++c ) {
            var max_width = widths.get( c );
            for (int r = 0; r < tbl.rows(); ++ r ) {
                var w = tbl.get( r, c ).toString().length();
                max_width = w > max_width ? w : max_width;
            }
            widths.set( c, max_width );
        }

        if ( tbl.cols() > 0 ) {
            for ( int c = 0; c < tbl.cols(); ++c ) {
                if ( c > 0 ) {
                    wr.write( " " );
                }
                var str = tbl.type().cols().get( c ).name();
                wr.write( str );
                for ( int i = str.length(); i < widths.get( c ); ++i ) {
                    wr.write( " " );
                }
            }
            wr.write("\n");
            for ( int r = 0; r < tbl.rows(); ++r ) {
                for ( int c = 0; c < tbl.cols(); ++c ) {
                    if ( c > 0 ) {
                        wr.write( " " );
                    }
                    var str =  tbl.get( r, c ).toString();
                    wr.write( str );
                    for ( int i = str.length(); i < widths.get(c); ++i ) {
                        wr.write( " " );
                    }
                }
                wr.write("\n");
            }
        }
    }
}
