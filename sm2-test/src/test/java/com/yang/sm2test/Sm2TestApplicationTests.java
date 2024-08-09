package com.yang.sm2test;

import com.antherd.smcrypto.sm2.Keypair;
import com.antherd.smcrypto.sm2.Sm2;
import org.junit.jupiter.api.Test;

class Sm2TestApplicationTests {

    @Test
    void contextLoads() {
    }


    /**
     * 测试Sm2加解密、加解签
     * <dependency>
     *   <groupId>com.antherd</groupId>
     *   <artifactId>sm-crypto</artifactId>
     *   <version>0.3.2</version>
     * </dependency>
     */


    /**
     * 生成公私钥
     */
    @Test
    public void testSM2(){
        // 生成出来的密钥可无缝衔接 前端 js 加解密
        Keypair keypair = Sm2.generateKeyPairHex();
        String privateKey = keypair.getPrivateKey(); // 私钥
        String publicKey = keypair.getPublicKey(); // 公钥

        System.out.println(privateKey);
        System.out.println(publicKey);
//        45c14c670c274b3c7e3a129e445db67fc1958eaa0935f47aba70e3cf7a1bda9f
//        04a29cbb05bfbcbe00d653b9f106be62b70997df809ba8b82e803eac2399f943fa2e455131527ab71a6a88fa6248b7336ebc8890863a830b0adb43e38644b5a386
        System.out.println("========================");
    }

    /**
     * 加密、解密、加签、解签示例；
     */
    @Test
    public void test(){
        String privateKey = "45c14c670c274b3c7e3a129e445db67fc1958eaa0935f47aba70e3cf7a1bda9f"; // 私钥
        String publicKey = "04a29cbb05bfbcbe00d653b9f106be62b70997df809ba8b82e803eac2399f943fa2e455131527ab71a6a88fa6248b7336ebc8890863a830b0adb43e38644b5a386"; // 公钥

        // 需要加密的明文
        String msg = "{\"psnName\":\"测试\",\"certNo\":\"211224199910068817\",\"tel\":\"13412341234\"}";
        String encrypt = Sm2.doEncrypt(msg, publicKey);
        System.out.println("使用公钥加密密文为："+ encrypt);
        // 签名
        String sigValueHex = Sm2.doSignature(msg, privateKey);
        System.out.println("使用私钥签名结果为："+ sigValueHex);


        // 解密
        String decrypt = Sm2.doDecrypt(encrypt, privateKey);
        System.out.println("使用私钥解密明文为："+ decrypt);
        // 验签
        boolean verifyResult = Sm2.doVerifySignature(decrypt, sigValueHex, publicKey); // 验签结果
        System.out.println("使用公钥验签结果为："+ verifyResult);

    }
}
