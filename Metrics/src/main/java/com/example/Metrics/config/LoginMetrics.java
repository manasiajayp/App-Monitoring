package com.example.Metrics.config;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class LoginMetrics {

    private final Counter loginAttemptCounter;
    private final Counter loginSuccessCounter;
    private final Counter loginFailureCounter;

    public LoginMetrics(MeterRegistry registry) {
        this.loginAttemptCounter = Counter.builder("login_attempts_total")
                .description("Total login attempts")
                .register(registry);

        this.loginSuccessCounter = Counter.builder("login_success_total")
                .description("Total successful logins")
                .register(registry);

        this.loginFailureCounter = Counter.builder("login_failure_total")
                .description("Total failed login attempts")
                .register(registry);
    }

    public void incrementLoginAttempt() {
        loginAttemptCounter.increment();
    }

    public void incrementLoginSuccess() {
        loginSuccessCounter.increment();
    }

    public void incrementLoginFailure() {
        loginFailureCounter.increment();
    }
}
