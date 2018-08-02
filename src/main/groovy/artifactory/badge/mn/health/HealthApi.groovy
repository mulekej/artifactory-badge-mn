package artifactory.badge.mn.health

import io.micronaut.http.annotation.Trace

interface HealthApi {

    @Trace
    String heartBeat(String echo)
}