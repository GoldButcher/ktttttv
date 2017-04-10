package ktv.controller;

import ktv.dto.CommonResponseDto;
import ktv.model.BoxInfo;
import ktv.model.BoxType;
import ktv.service.IBoxTypeService;
import ktv.util.CommonResponseUtil;
import org.springframework.data.geo.Box;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/1/2.
 */
@RestController
public class BoxTypeController {
    @Resource
    private IBoxTypeService boxTypeService;

    /**
     * @title:增加包厢类型
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/2 23:27
     **/
    @RequestMapping(value = "/addBoxTypeInfo",method = RequestMethod.POST)
    public CommonResponseDto addBoxTypeInfo(BoxType boxType)
    {
        Assert.notNull(boxType);
        boxTypeService.sava(boxType);
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:修改包厢类型信息
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/2 23:46
     **/
    @RequestMapping(value = "/updateBoxTypeInfo",method = RequestMethod.POST)
    public CommonResponseDto updateBoxTypeInfo(BoxType newBoxType)
    {
        Assert.notNull(newBoxType);
        BoxType oldBoxType = boxTypeService.getByKey(newBoxType.getBoxTypeId());
        oldBoxType.setBoxNum(newBoxType.getBoxNum());
        oldBoxType.setDescription(newBoxType.getDescription());
        oldBoxType.setLeftBoxNum(newBoxType.getLeftBoxNum());
        oldBoxType.setName(newBoxType.getName());
        boxTypeService.update(oldBoxType);
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:修改包厢描述
     * @user:amdin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/4/9 10:02
     **/

    @PostMapping(value = "/updateBoxTypeDescription")
    public CommonResponseDto updateBoxTypeDesc(int id,String desc){
        BoxType newBoxType = boxTypeService.getByKey(id);
        newBoxType.setDescription(desc);
        boxTypeService.update(newBoxType);
        return CommonResponseUtil.successWithNull();
    }



    /**
     * @title:删除包厢类型信息
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/2 23:50
     **/
    @RequestMapping(value = "/delBoxTypeInfo",method = RequestMethod.POST)
    public CommonResponseDto delBoxTypeInfo(BoxType boxType)
    {
        Assert.notNull(boxType);
        boxTypeService.delete(boxType);
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:获取包厢类型信息
     * @user:admin
     * @return:ktv.model.BoxType
     * @date:2017/1/3 0:12
     **/
    @RequestMapping(value = "/getBoxTypeInfo",method = RequestMethod.GET)
    public BoxType getBoxTypeInfo(int id)
    {
        Assert.notNull(id);
        return boxTypeService.getByKey(id);
    }

    /**
     * @title:获取所有包厢类型信息
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/8 14:59
     **/
    @RequestMapping(value = "/getAllBoxTypeInfo",method = RequestMethod.GET)
    public CommonResponseDto getAllBoxTypeInfo()
    {
        List<BoxType> boxTypes = boxTypeService.getAll();
        return CommonResponseUtil.successWithObj(boxTypes);
    }
}
