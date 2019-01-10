package ru.httpstatuses.service;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.httpstatuses.config.HttpStatusesProperties;
import ru.httpstatuses.model.HttpStatusInfo;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class HttpStatusRandomizer {

    private final HttpStatusesProperties httpStatusesProperties;
    private final Random rnd = new Random();

    @Autowired
    public HttpStatusRandomizer(HttpStatusesProperties httpStatusesProperties) {
        this.httpStatusesProperties = httpStatusesProperties;
    }

    public HttpStatusInfo randomStatus() {
        List<HttpStatusInfo> statuses = httpStatusesProperties.getStatuses();
        int i = rnd.nextInt(statuses.size());
        return statuses.get(i);
    }

    public Set<HttpStatusInfo> randomStatus(int count) {
        final List<HttpStatusInfo> statuses = httpStatusesProperties.getStatuses();
        Collections.shuffle(statuses);
        return Sets.newHashSet(Iterables.limit(statuses, count));
    }
}
