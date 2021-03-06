package artifactory.badge.mn.artifactory

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

interface ArtifactoryApi {

    @Get(uri = "/artifactory/api/search/latestVersion?a={artifactId}&g={groupId}&repos={repo}")
    String findVersion(@QueryValue("g") String groupId, @QueryValue("a") String artifactId, @QueryValue("repos") String repo)

}