package artifactory.badge.mn.controller

import artifactory.badge.mn.health.HealthApi
import groovy.util.logging.Slf4j
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Slf4j
@Controller("/healthCheck")
class HealthController {

    List<HealthApi> externalApis

    HealthController(List<HealthApi> externalApis) {
        this.externalApis = externalApis
    }

    @Get("/")
    String health() {
        def results = externalApis.collect {
            def result = it.heartBeat("Echo") == "Echo"
            [it.class.simpleName, result]
        }
        results
    }

    @Get("/ping")
    Map heartBeat() {
        log.trace "Responding to ping"

        ["serverName":effectiveServerName()]
    }

    private static String effectiveServerName() {
        def localHost = InetAddress.localHost
        def serverName = localHost.canonicalHostName
        def serverIpAddress = localHost.hostAddress
        serverName ?: serverIpAddress
    }

}
