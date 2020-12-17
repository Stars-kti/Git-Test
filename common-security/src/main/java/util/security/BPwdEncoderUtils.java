package util.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码加密校验类
 * @author kuro
 */
public class BPwdEncoderUtils {

    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    /**
     * 用BCryptPasswordEncoder加密密码
     *
     * @param password
     * @return
     */
    public static String bCryptPassword(String password) {
        return ENCODER.encode(password);
    }

    /**
     * 校验明文密码与加密密码是否一致
     *
     * @param rawPassword     原始密码
     * @param encodedPassword 加密后的密码
     * @return
     */
    public static boolean matches(CharSequence rawPassword, String encodedPassword) {
        return ENCODER.matches(rawPassword, encodedPassword);
    }

}
