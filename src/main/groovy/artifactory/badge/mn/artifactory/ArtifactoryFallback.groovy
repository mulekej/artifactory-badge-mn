package artifactory.badge.mn.artifactory

import io.micronaut.http.annotation.QueryValue

//@Fallback
class ArtifactoryFallback implements ArtifactoryApi{

    @Override
    String findVersion(@QueryValue("g") String groupId, @QueryValue("a") String artifactId, @QueryValue("repos") String repo) {
        "17.0.1.A"
    }

    @Override
    String heartBeat(String echo) {
        "Failed Heartbeat"
    }
}
