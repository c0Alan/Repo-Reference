package camelinaction;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringOrderRouterWithWireTapTest extends CamelSpringTestSupport {

    @Override
    protected AbstractXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("camelinaction/SpringOrderRouterWithWireTapTest.xml");
    }

    @Test
    public void testPlacingOrders() throws Exception {
        getMockEndpoint("mock:wiretap").expectedMessageCount(1);
    	getMockEndpoint("mock:xml").expectedMessageCount(1);
        getMockEndpoint("mock:csv").expectedMessageCount(0);
        assertMockEndpointsSatisfied();
    }
}
