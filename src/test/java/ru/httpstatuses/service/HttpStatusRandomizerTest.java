package ru.httpstatuses.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.httpstatuses.model.HttpStatusInfo;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpStatusRandomizerTest {

    @Autowired
    HttpStatusRandomizer httpStatusRandomizer;

    @Test
    public void checkExistingResult() {
        assertNotNull(httpStatusRandomizer);

        HttpStatusInfo httpStatusInfo = httpStatusRandomizer.randomStatus();

        assertNotNull(httpStatusInfo);

        assertNotNull(httpStatusInfo.getCode());
        assertNotNull(httpStatusInfo.getDescription());
    }

    @Test
    public void checkRandomStatuses() {
        int iterations = 5;

        Set<HttpStatusInfo> result = new HashSet<>();

        for (int i = 0; iterations > i; iterations--)
            result.add(httpStatusRandomizer.randomStatus());

        assertNotEquals(result.size(), 1);
    }

    @Test
    public void checkReturnRandomStatusesCollection() {
        int expectedSize = 10;
        Set<HttpStatusInfo> randomStatuses = httpStatusRandomizer.randomStatus(expectedSize);
        assertEquals(randomStatuses.size(), expectedSize);
    }

}