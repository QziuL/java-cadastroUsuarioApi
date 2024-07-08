package api_auth.config.jwt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "security.config")
public class JwtSecurityConfig {
    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;
}
