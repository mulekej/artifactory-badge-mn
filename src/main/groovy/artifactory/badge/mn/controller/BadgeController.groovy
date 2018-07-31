package artifactory.badge.mn.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus


@Controller("/artifacts")
class BadgeController {

    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }

    @Get("//{repo}/{groupId}/{artifactId}")
    HttpStatus getBadge() {
        return HttpStatus.OK
    }
}