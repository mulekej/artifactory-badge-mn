package artifactory.badge.mn.artifactory


import io.micronaut.http.client.Client

@Client('http://${artifactory.host}:${artifactory.port}')
interface ArtifactoryClient extends ArtifactoryApi {
}