package artifactory.badge.mn.health

import io.micronaut.management.health.indicator.AbstractHealthIndicator

class CustomHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected Object getHealthInformation() {
        return null
    }

    @Override
    protected String getName() {
        return null
    }

    @Override
    int getOrder() {
        return super.getOrder()
    }
}
