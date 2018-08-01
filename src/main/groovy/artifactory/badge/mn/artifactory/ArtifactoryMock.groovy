package artifactory.badge.mn.artifactory

import io.micronaut.http.annotation.QueryValue
import io.micronaut.retry.annotation.Fallback

@Fallback
class ArtifactoryMock implements ArtifactoryApi{

    @Override
    Optional<String> findVersion(@QueryValue("g") String groupId, @QueryValue("a") String artifactId, @QueryValue("repos") String repo) {
        Optional.of("17.0.1.A")
    }
}
