package artifactory.badge.mn.artifactory

import io.micronaut.context.annotation.ConfigurationProperties

@ConfigurationProperties('artifactory')
class ArtifactoryConfig {

    String host
    String port
    User user

    @ConfigurationProperties('user')
    static class User {
        String name
        String token
    }
}
