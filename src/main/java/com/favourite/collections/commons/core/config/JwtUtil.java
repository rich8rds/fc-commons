///* Collections #2025 */
//package com.favourite.collections.commons.core.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.UUID;
//import java.util.function.Function;
//
//@Component
//public class JwtUtil {
//
//	@Value("${app.jwt.secret.key}")
//	private String SECRET_KEY;
//
//	public Jws<Claims> validateToken(final String token) {
//		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
//	}
//
//	private Key getSignKey() {
//		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
//		return Keys.hmacShaKeyFor(keyBytes);
//	}
//
//	public String extractUsername(String token) {
//		return extractClaim(token, Claims::getSubject);
//	}
//
//	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//		final Claims claims = validateToken(token).getBody();
//		return claimsResolver.apply(claims);
//	}
//
//	public String generateToken(Authentication authentication) {
//		String jws = Jwts.builder()
//
//				.subject("Bob")
//				.signWith(getSignKey())
//				.audience().add("you").and()
//				.expiration(expiration) //a java.util.Date
//				.notBefore(notBefore) //a java.util.Date
//				.issuedAt(new Date()) // for example, now
//				.id(UUID.randomUUID().toString());
//
//		return jws;
//	}
//}
