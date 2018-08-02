package artifactory.badge.mn.health

import io.micronaut.management.endpoint.health.HealthLevelOfDetail
import io.micronaut.management.health.aggregator.HealthAggregator
import io.micronaut.management.health.indicator.HealthIndicator
import io.micronaut.management.health.indicator.HealthResult
import org.reactivestreams.Publisher

class CustomAggregator implements HealthAggregator{
    @Override
    Publisher aggregate(HealthIndicator[] indicators, HealthLevelOfDetail healthLevelOfDetail) {
        return null
    }

    @Override
    Publisher<HealthResult> aggregate(String name, Publisher results) {
        return null
    }
}
