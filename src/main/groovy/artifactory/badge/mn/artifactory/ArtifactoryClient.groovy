package artifactory.badge.mn.artifactory


import io.micronaut.http.client.Client

//@Client("http://artifactory.surescripts-dev.qa:8080")
@Client("http://localhost:8081")
//@Header(name = "Authorization", value = "${}")
interface ArtifactoryClient extends ArtifactoryApi {
}