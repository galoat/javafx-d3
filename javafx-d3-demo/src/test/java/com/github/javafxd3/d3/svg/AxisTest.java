package com.github.javafxd3.d3.svg;

import com.github.javafxd3.d3.AbstractTestCase;
import com.github.javafxd3.d3.D3;
import com.github.javafxd3.d3.core.Selection;
import com.github.javafxd3.d3.core.Value;
import com.github.javafxd3.d3.functions.DatumFunction;
import com.github.javafxd3.d3.scales.LinearScale;
import com.github.javafxd3.d3.scales.LogScale;
import com.github.javafxd3.d3.scales.OrdinalScale;
import com.github.javafxd3.d3.selection.datumfunction.PrefixPlusIndexDatumFunction;
import com.github.javafxd3.d3.svg.Axis;
import com.github.javafxd3.d3.svg.Axis.Orientation;
import com.github.javafxd3.d3.svg.datumfunction.TickTestDatumFunction;

@SuppressWarnings("javadoc")
public class AxisTest extends AbstractTestCase {
	
	
	

	@Override	
    public void doTest() {
    	
    	D3 d3 = new D3(webEngine);
    	
        Axis axis = d3.svg().axis();

        // default scale
        LinearScale s = axis.scale();
        assertNotNull(s);
        int asInt = s.domain().get(0, Value.class).asInt();
        assertEquals(0, asInt);
        // default orientation
        assertEquals(Orientation.BOTTOM, axis.orient());
        // set orientation
        axis.orient(Orientation.TOP);
        assertEquals(Orientation.TOP, axis.orient());

        // set scale
        LogScale logScale = d3.scale().log();
        axis.scale(logScale);

        // ticks
        assertEquals(1, axis.ticks().length());
        assertEquals(10, (int) axis.ticks().get(0,  Value.class).asInt());

        axis.ticks(12);
        assertEquals(12, (int) axis.ticks().get(0,  Value.class).asInt());

        axis.ticks(15, "blah");
        assertEquals(15, (int) axis.ticks().get(0,  Value.class).asInt());
        assertEquals("blah", axis.ticks().get(1, Value.class).asString());

      //  Interval interval = d3.time().day();
      //  axis.ticks(interval, 10);
      //  assertEquals(interval, axis.ticks()[0].as());
      //  assertEquals(10, axis.ticks()[1].asInt());

        // FIXME: smoke test to be cross checked
        DatumFunction<String> f = new PrefixPlusIndexDatumFunction(webEngine, "index");
        
        axis.ticks(8, f);
        assertEquals(8, (int) axis.ticks().get(0,  Value.class).asInt());
        assertEquals(f, axis.ticks().get(1,  Value.class).as());

        // tick values
        assertNull(axis.tickValues());
        axis.tickValues(1, 2, 3);
        assertEquals(1, (int) axis.tickValues().get(0,  Value.class).asInt());
        assertEquals(2, (int) axis.tickValues().get(1,  Value.class).asInt());
        assertEquals(3, (int) axis.tickValues().get(2,  Value.class).asInt());

        // tick subdivide : replaced
        // assertEquals(0, axis.tickSubdivide());
        // axis.tickSubdivide(9);
        // assertEquals(9, axis.tickSubdivide());

        // tick size
        assertEquals(6, axis.tickSize());
        assertEquals(6, axis.innerTickSize());
        assertEquals(6, axis.outerTickSize());
        axis.tickSize(6);
        axis.innerTickSize(5);
        axis.outerTickSize(5);
        assertEquals(5, axis.innerTickSize());
        assertEquals(5, axis.outerTickSize());

        axis.tickSize(6, 0);
        axis.tickSize(6, 3, 2);

        // tick padding
        assertEquals(3, axis.tickPadding());
        axis.tickPadding(5);
        assertEquals(5, axis.tickPadding());

        // tick format
        assertNull(axis.tickFormat());
        axis.tickFormat(d3.format("3"));
        assertNotNull(axis.tickFormat());

        // index in tick format
        OrdinalScale s2 = d3.scale().ordinal();
        axis = d3.svg().axis().scale(s2);
        
        s2.domain(5, 15, 20, 100);
        s2.range(1, 2, 3, 4);
        final StringBuffer counter = new StringBuffer();
        axis.tickFormat(new TickTestDatumFunction(webEngine, counter));
        
        // apply
        Selection svg = d3.select("svg").attr("width", 100)
                .attr("height", 100).append("g")
                .attr("transform", "translate(32,50)");
        
       

        axis.apply(svg);
        int counterLength = counter.length();
        assertEquals(4, counterLength);

        Axis axis2 = d3.svg().axis();
        svg.call(axis2);
        
    }
}
