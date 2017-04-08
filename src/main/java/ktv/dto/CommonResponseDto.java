package ktv.dto;

/**
 * Created by admin on 2016/12/26.
 */
public class CommonResponseDto {
    private String result;
    private Object data;

    public CommonResponseDto(){}

    public CommonResponseDto(String result, Object data) {
        this.result = result;
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
