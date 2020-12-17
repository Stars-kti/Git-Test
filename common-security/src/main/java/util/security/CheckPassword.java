package util.security;

import com.citic.common.exception.CommonException;
import com.citic.common.exception.enums.ErrorCode;

/**
 *  密码强度测试类
 *
 * @author Chenjiaxing
 */
public class CheckPassword {

    private static final int MINIMUM_LENGTH = 8;

    private static final int MAXIMUM_LENGTH = 16;

    private static final String PW_PATTERN = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{8,16}$";


    /**
     *  密码长度必须在8-16位之间
     *  密码必须包含大写字母，小写字母，数字以及特殊符号
     *
     * @param passwordStr 需要校验的密码
     * @return Boolean
     */
    public static Boolean checkPassword(String passwordStr) {
        if (!checkPasswordLength(passwordStr)) {
            throw new CommonException(ErrorCode.PASSWORD_ERROR, "密码长度不合法");
        }
        if (!passwordStr.matches(PW_PATTERN)) {
            throw new CommonException(ErrorCode.PASSWORD_ERROR, "密码必须包含大写字母、小写字母、数字、特殊符号的8位以上组合");
        }
        return true;
    }

    /**
     * 检查密码长度
     *
     * @param passwordStr 需要校验的密码
     * @return Boolean
     */
    public static Boolean checkPasswordLength(String passwordStr) {
        return passwordStr.length() >= MINIMUM_LENGTH
                && passwordStr.length() <= MAXIMUM_LENGTH;
    }
}
