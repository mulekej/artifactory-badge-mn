package artifactory.badge.mn.controller

import artifactory.badge.mn.artifactory.ArtifactoryClient
import artifactory.badge.mn.generator.BadgeGenerator
import io.micronaut.http.HttpResponseFactory
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.simple.SimpleHttpResponseFactory

import javax.imageio.ImageIO

import static artifactory.badge.mn.util.Constants.VERSION_NOT_FOUND

@Controller("/artifacts")
class BadgeController {

    ArtifactoryClient client
    HttpResponseFactory httpResponseFactory

    BadgeController(ArtifactoryClient client) {
        this.client = client
        this.httpResponseFactory = new SimpleHttpResponseFactory()
    }

    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }

    @Get("/{repo}/{groupId}/{artifactId}")
    @Produces("image/png")
    byte[] getBadge(String repo, String groupId, String artifactId) {
        def result = client.findVersion(groupId, artifactId, repo)?: VERSION_NOT_FOUND
        def badge = BadgeGenerator.generate(artifactId, result, result != VERSION_NOT_FOUND)
        def outputStream = new ByteArrayOutputStream()
        ImageIO.write(badge, "png", outputStream)
        outputStream.toByteArray()
    }
}