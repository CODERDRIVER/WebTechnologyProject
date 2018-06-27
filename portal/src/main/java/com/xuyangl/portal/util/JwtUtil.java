package com.xuyangl.portal.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * @Description Jwt 验证工具类
 * @Author: liuXuyang
 * @studentNo 15130110024
 * @Emailaddress 1187697635@qq.com
 * @Date: 2018/6/27 16:18
 */
public class JwtUtil {

    /**
     * 解析JWT
     */
    public static Claims parseJWT(String jsonWebToken,String base64Security)
    {
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                .parseClaimsJws(jsonWebToken).getBody();
        return claims;
    }

    /**
     * 构建JWT
     */
    public static String createJWT(String name,String userId,String role,String audience
            ,String issuer,long TTLMillis,String base64Security)
    {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date date  = new Date(nowMillis);


        //生成签名密钥
        byte[] bytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key key = new SecretKeySpec(bytes,signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder jwtBuilder  = Jwts.builder().setHeaderParam("typ","JWTS")
                .claim("role",role)
                .claim("unique_name",name)
                .claim("userId",userId)
                .setIssuer(issuer)
                .setAudience(audience)
                .signWith(signatureAlgorithm,key);

        //设置过期时间
        if (TTLMillis>0)
        {
            long expMillis = nowMillis+TTLMillis;
            Date expDate = new Date(expMillis);
            jwtBuilder.setNotBefore(date).setExpiration(expDate);
        }

        //生成JWT
        return jwtBuilder.compact();
    }
}
