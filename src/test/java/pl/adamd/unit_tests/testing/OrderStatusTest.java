package pl.adamd.unit_tests.testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderStatusTest {
    @ParameterizedTest
    @EnumSource(OrderStatus.class)
    void allOrderStatusShouldBeShorterThen15Chars(OrderStatus orderStatus){
        assertThat(orderStatus.toString().length(), lessThan(15));
    }

}
