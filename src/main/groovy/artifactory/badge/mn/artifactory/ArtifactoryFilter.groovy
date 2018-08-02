package artifactory.badge.mn.artifactory

import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpRequest
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.ClientFilterChain
import io.micronaut.http.filter.HttpClientFilter
import org.reactivestreams.Publisher

@Filter("/artifactory/api/**")
class ArtifactoryFilter implements HttpClientFilter {

    ArtifactoryConfig config

    ArtifactoryFilter(ArtifactoryConfig config) {
        this.config = config
    }

    @Override
    Publisher<? extends HttpResponse<?>> doFilter(MutableHttpRequest<?> request, ClientFilterChain chain) {
        chain.proceed(request.basicAuth(config.user.name, config.user.token))
    }
}
