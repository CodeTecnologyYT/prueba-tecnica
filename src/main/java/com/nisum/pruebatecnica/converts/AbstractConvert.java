package com.nisum.pruebatecnica.converts;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractConvert<Request,Entity>{

    public abstract Entity fromRequest(Request request);

    public Set<Entity> fromRequest(List<Request> requests){
        return requests.stream()
                .map(request -> fromRequest(request))
                .collect(Collectors.toSet());
    }
}
