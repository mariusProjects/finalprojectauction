package com.sda.auction.jwt;

import com.sda.auction.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import java.security.Key;
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


	public String createJwt(User user) {

		return Jwts.builder()
				.claim("email", user.getEmail())
				.claim("roles", user.getRoles())
				.claim("firstName",user.getFirstName())
				.signWith(signatureAlgorithm, signingKey).compact();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		byte[] keyBytes = Decoders.BASE64.decode(serverSecret);
		signingKey = new SecretKeySpec(keyBytes, signatureAlgorithm.getJcaName());
	}
}
