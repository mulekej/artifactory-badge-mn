package artifactory.badge.mn.artifactory

import artifactory.badge.mn.health.HealthApi
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

interface ArtifactoryApi extends HealthApi {

    @Get("/artifactory/api/search/latestVersion")
    String findVersion(@QueryValue("g") String groupId, @QueryValue("a") String artifactId, @QueryValue("repos") String repo)
}