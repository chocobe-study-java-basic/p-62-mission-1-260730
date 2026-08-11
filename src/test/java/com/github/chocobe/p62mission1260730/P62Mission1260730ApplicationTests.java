package com.github.chocobe.p62mission1260730;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles(profiles = "test")
class P62Mission1260730ApplicationTests {

    @Test
    void contextLoads() {
        boolean truthy = true;
        assertTrue(truthy);
    }

}
