package artifactory.badge.mn.artifactory

import io.micronaut.http.annotation.QueryValue
import io.micronaut.retry.annotation.Fallback

import static artifactory.badge.mn.util.Constants.VERSION_NOT_FOUND

@Fallback
class ArtifactoryFallback implements ArtifactoryApi {

    @Override
    String findVersion(@QueryValue("g") String groupId, @QueryValue("a") String artifactId, @QueryValue("repos") String repo) {
        VERSION_NOT_FOUND
    }
}
