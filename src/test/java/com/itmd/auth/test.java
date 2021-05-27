package com.itmd.auth;

import com.itmd.auth.entiy.UserInfo;
import com.itmd.auth.utils.JwtUtils;
import com.itmd.auth.utils.RsaUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class test {

    private static final String pubKeyPath = "D:\\raorao\\rsa\\rsa.pub";

    private static final String priKeyPath = "D:\\raorao\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "raorao@Login(Auth}*^31)&hy%");
    }

    @BeforeEach
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6NSwidXNlcm5hbWUiOiJJTE9WRVlPVSIsImltYWdlIjoiaHR0cHM6Ly91cGxvYWQuaHl0cmVlLmxpbmsvZ3JvdXAxL00wMC8wMC8wMS9yQkUxMTJCZHV6V0FIX2hKQUFCWV8tdzZqRGcxNy5qcGVnIiwiZXhwIjoxNjE3MDI2OTIyfQ.xVEUPJZ01MYPvVGUIkdzbRZAtm0_3yL3PfwYndeiJ88hfvaL4UdXt5RQ_nVtHWYV1Np2_ZbZY_zgxeTzPY4amztJj5csN-LpDwLsrYmjsVwniSCWwtIweobZiUxbkKBWIGrXmZ4sppo3h9-UkJCe33TXeqyrTie6I9vXQg0zCrc";
        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
