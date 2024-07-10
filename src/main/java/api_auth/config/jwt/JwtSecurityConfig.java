package api_auth.config.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "security.config")
public class JwtSecurityConfig {
    public static String PREFIX = "Bearer";
    public static String KEY = "SECRET";
    public static Long EXPIRATION = 3600000L;
}
