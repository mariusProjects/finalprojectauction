package com.sda.auction.jwt;

import com.sda.auction.model.Role;
import com.sda.auction.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TokenProvider implements InitializingBean {

	private SignatureAlgorithm signatureAlgorithm
			= SignatureAlgorithm.HS256;

	@Value("${jwt.server.secret}")
	private String serverSecret;

	private Key signingKey;


	@Value("${jwt.role.admin.protected}")
	private String adminProtectedPaths;

	@Value("${jwt.role.user.protected}")
	private String userProtectedPaths;

	@Override
	public void afterPropertiesSet() throws Exception {
		byte[] keyBytes = Decoders.BASE64.decode(serverSecret);
		signingKey = new SecretKeySpec(keyBytes, signatureAlgorithm.getJcaName());
	}

	public String createJwt(User user) {
		return Jwts.builder()
				.claim("email", user.getEmail())
				.claim("roles", user.getRolesAsStrings())
				.claim("firstName", user.getFirstName())
				.signWith(signatureAlgorithm, signingKey).compact();
	}

	public boolean validate(String jwt, String requestURL) {
		if (requestURL.compareTo("/api/login") == 0
				|| requestURL.compareTo("/api/register") == 0) {
			return true;
		}
		Optional<Claims> optionalClaims = decodeJwt(jwt);
		if (!optionalClaims.isPresent()) {
			return false;
		}

		Claims claims = optionalClaims.get();
		//check for admin role
		String[] adminProtected = adminProtectedPaths.split(",");
		for (String path : adminProtected) {
			if (requestURL.contains(path)) {
				//se solicita o resursa admin protected
				List<String> roles = claims.get("roles", ArrayList.class);
				for (String role : roles) {
					if (role.compareTo("admin") == 0) {
						return true;
					}
				}
				return false;
			}
		}
//	check for user role
		String[] userProtected = userProtectedPaths.split(",");
		for (String path : userProtected) {
			if (requestURL.contains(path)) {
				//se solicita o resursa user protected
				List<String> roles = claims.get("roles", ArrayList.class);
				for (String role : roles) {
					if (role.compareTo("user") == 0) {
						return true;
					}
				}
				return false;
			}
		}
		return true;
	}

	private Optional<Claims> decodeJwt(String jwt) {
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(signingKey)
					.parseClaimsJws(jwt)
					.getBody();
			return Optional.of(claims);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	public String getEmailFrom(String jwt) {
		return Jwts.parser()
				.setSigningKey(signingKey)
				.parseClaimsJws(jwt)
				.getBody().get("email", String.class);
	}
}
