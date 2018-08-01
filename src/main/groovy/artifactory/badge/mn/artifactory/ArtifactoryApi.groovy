package artifactory.badge.mn.artifactory

import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

interface ArtifactoryApi {

    @Get("/artifactory/api/search/latestVersion")
    Optional<String> findVersion(@QueryValue("g") String groupId, @QueryValue("a") String artifactId, @QueryValue("repos") String repo)

}