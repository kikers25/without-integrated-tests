package com.mars.rover;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.runner.RunWith;


@SuppressWarnings("deprecation")
@RunWith(JMock.class)
public abstract class TestsWithMokingClasses {
	
	protected Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
}
