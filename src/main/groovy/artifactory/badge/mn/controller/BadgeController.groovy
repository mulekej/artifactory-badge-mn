package artifactory.badge.mn.controller

import artifactory.badge.mn.artifactory.ArtifactoryClient
import artifactory.badge.mn.generator.BadgeGenerator
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import javax.imageio.ImageIO

@Controller("/artifacts")
class BadgeController {

    ArtifactoryClient client

    BadgeController(ArtifactoryClient client) {
        this.client = client
    }

    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }

    @Get("/{repo}/{groupId}/{artifactId}")
    @Produces("image/png")
    byte[] getBadge(String repo, String groupId, String artifactId) {
        def result = client.findVersion(groupId, artifactId, repo)
        def badge = BadgeGenerator.generate("artifactory", result, true)
        def outputStream = new ByteArrayOutputStream()
        ImageIO.write(badge, "png", outputStream)
        outputStream.toByteArray()
    }
}