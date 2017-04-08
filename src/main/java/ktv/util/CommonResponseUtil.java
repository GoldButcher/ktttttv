package ktv.util;

import ktv.dto.CommonResponseDto;

/**
 * Created by admin on 2017/1/2.
 */
public class CommonResponseUtil {

    private static String SHOP_ERROR_INFO_NOTEXIST = "公司信息不存在";
    public static CommonResponseDto successWithNull() {
        return new CommonResponseDto("success", null);
    }

    public static CommonResponseDto successWithObj(Object object){return new CommonResponseDto("success",object);}

    public static CommonResponseDto shopNotExist() {
        return new CommonResponseDto("error", SHOP_ERROR_INFO_NOTEXIST);
    }

    public static CommonResponseDto errorWithObj(Object object){return new CommonResponseDto("error",object);}

}
