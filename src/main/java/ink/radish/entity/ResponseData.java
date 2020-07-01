package ink.radish.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@ApiModel(value = "通用响应数据结构类")
public class ResponseData {

    @ApiModelProperty(value = "请求是否处理成功")
    private boolean isok;  //请求是否处理成功
    @ApiModelProperty(value = "请求响应状态码", example = "200、400、500")
    private int code; //请求响应状态码（200、400、500）
    @ApiModelProperty(value = "请求结果描述信息")
    private String msg;  //请求结果描述信息
    @ApiModelProperty(value = "请求结果数据")
    private Object data; //请求结果数据（通常用于查询操作）
    @ApiModelProperty(value = "总条数")
    private Long count;//如果分页，数据库中数据的总条数

    public ResponseData() {
    }

    //请求成功的响应，不带查询数据（用于删除、修改、新增接口）
    public static ResponseData success() {
        ResponseData responseData = new ResponseData();
        responseData.setIsok(true);
        responseData.setCode(200);
        responseData.setMsg("请求响应成功!");
        return responseData;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static ResponseData success(Object obj) {
        ResponseData responseData = new ResponseData();
        responseData.setIsok(true);
        responseData.setCode(200);
        responseData.setMsg("请求响应成功!");
        responseData.setData(obj);
        return responseData;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static ResponseData success(Object obj, String message) {
        ResponseData responseData = new ResponseData();
        responseData.setIsok(true);
        responseData.setCode(200);
        responseData.setMsg(message);
        responseData.setData(obj);
        return responseData;
    }

    //请求失败的响应
    public static ResponseData error() {
        ResponseData responseData = new ResponseData();
        responseData.setIsok(false);
        responseData.setCode(400);
        responseData.setMsg("请求响应失败!");
        return responseData;
    }

    public static ResponseData success(Page page) {
        ResponseData responseData = new ResponseData();
        responseData.setIsok(true);
        responseData.setCode(200);
        responseData.setMsg("请求响应成功!");
        responseData.setCount(page.getTotalElements());
        responseData.setData(page.getContent());
        return responseData;
    }

}