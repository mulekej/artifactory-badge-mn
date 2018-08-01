package artifactory.badge.mn.controller

import artifactory.badge.mn.artifactory.ArtifactoryClient
import artifactory.badge.mn.generator.BadgeGenerator
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

import java.awt.image.BufferedImage

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
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    BufferedImage getBadge() {
        def result = client.findVersion("testG", "TestA", "TestRepo")
        def badge = BadgeGenerator.generate("artifactory", result.get(), true)
        badge
    }
}