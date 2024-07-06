package api_auth.config.jwt;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTCreator {
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String ROLES_AUTHORITIES = "authorities";

    public static String create(String prefix,String key, JwtObject jwtObject) {
        String token = Jwts.builder().setSubject(jwtObject.getSubject()).setIssuedAt(jwtObject.getIssuedAt()).setExpiration(jwtObject.getExpiration())
                .claim(ROLES_AUTHORITIES, checkRoles(jwtObject.getRoles())).signWith(SignatureAlgorithm.HS512, key).compact();
        return prefix + " " + token;
    }
    public static JwtObject create(String token,String prefix,String key)
            throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        JwtObject object = new JwtObject();
        token = token.replace(prefix, "");
        Claims claims = Jwts.parser()
        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setIssuedAt(claims.getIssuedAt());
        object.setRoles((List) claims.get(ROLES_AUTHORITIES));
        return object;

        /*
        verificar como fazer a adaptação
        https://github.com/jwtk/jjwt?tab=readme-ov-file#jwt-claims
        https://medium.com/@felipeacelinoo/protegendo-sua-api-rest-com-spring-security-e-autenticando-usu%C3%A1rios-com-token-jwt-em-uma-aplica%C3%A7%C3%A3o-d70e5b0331f9
        https://glysns.gitbook.io/spring-framework/spring-security/spring-security-e-jwt#configurando-o-jwt-no-projeto
        https://www.baeldung.com/spring-security-5-default-password-encoder
        https://medium.com/@tericcabrel/implement-jwt-authentication-in-a-spring-boot-3-application-5839e4fd8fac
        https://github.com/digitalinnovationone/dio-springboot/blob/main/dio-spring-security-jwt/src/main/java/dio/dio/spring/security/jwt/service/UserService.java
        https://stackoverflow.com/questions/73486900/how-to-fix-parser-is-deprecated-and-setsigningkeyjava-security-key-is-deprec
         */

    }
    private static List<String> checkRoles(List<String> roles) {
        return roles.stream().map(s -> "ROLE_".concat(s.replaceAll("ROLE_",""))).collect(Collectors.toList());
    }


}
