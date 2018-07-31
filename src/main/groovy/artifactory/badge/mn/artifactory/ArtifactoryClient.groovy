package artifactory.badge.mn.artifactory

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.Client

@Client("artifactory")
interface ArtifactoryClient {

    @Get("/")
    HttpStatus index()
}