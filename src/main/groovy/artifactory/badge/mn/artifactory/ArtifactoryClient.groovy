package artifactory.badge.mn.artifactory


import io.micronaut.http.client.Client

@Client("localhost:8081")
interface ArtifactoryClient extends ArtifactoryApi {
}