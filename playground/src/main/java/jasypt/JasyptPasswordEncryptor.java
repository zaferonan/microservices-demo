package jasypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.iv.RandomIvGenerator;
/*
* This Module is just used for encrypt password to use in spring security
* for abstract the pass.
*
* */
public class JasyptPasswordEncryptor {
    public static void main(String[] args) {
        StandardPBEStringEncryptor encryptor=new StandardPBEStringEncryptor();
        encryptor.setPassword("password_encryptor!");
        encryptor.setAlgorithm("PBEWithHMACSHA512AndAES_256");
        encryptor.setIvGenerator(new RandomIvGenerator());
        String result=encryptor.encrypt("e4d62c09-076f-4e2a-acd1-8159b9999293");
        System.out.println("Encrypted Pass = "+result);
        System.out.println("Orginal Pass = "+encryptor.decrypt(result));
    }
}
