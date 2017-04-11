package ktv.controller;

import ktv.dto.BoxInfoDto;
import ktv.dto.CommonResponseDto;
import ktv.dto.ListBoxDto;
import ktv.model.BoxInfo;
import ktv.service.IBoxInfoService;
import ktv.util.CommonResponseUtil;
import org.apache.catalina.LifecycleState;
import org.springframework.data.geo.Box;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2017/1/3.
 */
@RestController
public class BoxInfoController {
    @Resource
    private IBoxInfoService boxInfoService;

    /**
     * @title:增加具体包厢的信息
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/3 0:42
     **/
    @RequestMapping(value = "/addBoxInfo", method = RequestMethod.POST)
    public CommonResponseDto addBoxInfo(BoxInfo boxInfo) {
        Assert.notNull(boxInfo);

        boxInfoService.sava(boxInfo);
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:删除具体包厢信息
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/3 1:02
     **/
    @RequestMapping(value = "/delBoxInfo", method = RequestMethod.POST)
    public CommonResponseDto delBoxInfo(int id) {
        BoxInfo byKey = boxInfoService.getByKey(id);
        boxInfoService.delete(byKey);
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:修改具体包厢信息
     * @user:admin
     * @return:ktv.dto.CommonResponseDto
     * @date:2017/1/3 1:10
     **/
    @RequestMapping(value = "/editBoxInfo", method = RequestMethod.POST)
    public CommonResponseDto updateBoxInfo(BoxInfo boxInfo) {
        Assert.notNull(boxInfo);
        BoxInfo oldBoxInfo = boxInfoService.getByKey(boxInfo.getBoxInfoId());
        oldBoxInfo.setDescription(boxInfo.getDescription());
        oldBoxInfo.setBoxName(boxInfo.getBoxName());
        oldBoxInfo.setBoxTypeId(boxInfo.getBoxTypeId());
        oldBoxInfo.setBoxNo(boxInfo.getBoxNo());
        oldBoxInfo.setPrice(boxInfo.getPrice());
        oldBoxInfo.setNotice(boxInfo.getNotice());
        oldBoxInfo.setStatus(boxInfo.getStatus());
        boxInfoService.update(oldBoxInfo);
        return CommonResponseUtil.successWithNull();
    }

    /**
     * @title:获取具体包厢信息
     * @user:admin
     * @return:ktv.model.BoxInfo
     * @date:2017/1/3 0:59
     **/
    @RequestMapping(value = "/getBoxInfo", method = RequestMethod.GET)
    public BoxInfoDto getBoxInfo(int boxInfoId) {
        return boxInfoService.getBoxInfo(boxInfoId);
    }

    /**
     * @title:获取指定的房间号
     * @user:admin
     * @return:java.util.List<ktv.dto.ListBoxDto>
     * @date:2017/1/4 23:29
     **/
    @RequestMapping(value = "/getBoxLists", method = RequestMethod.GET)
    public List<ListBoxDto> getBoxLists(int typeId, String date, int payStatus, int pageNum) {
        return boxInfoService.getBoxLists(typeId, date, payStatus, pageNum);
    }

    /**
     * @title:获取指定包厢类型所有包厢
     * @user:admin
     * @return:java.util.List<ktv.dto.BoxInfoDto>
     * @date:2017/1/8 14:58
     **/
    @RequestMapping(value = "/getAllBoxListsByTypeId", method = RequestMethod.GET)
    public List<BoxInfoDto> getAllBoxListsByTypeId(int typeid) {
        return boxInfoService.getAllBoxListsByTypeId(typeid);
    }

    /**
     * @title:分页
     */
    @GetMapping(value = "getBoxListPaging/{typeId}//{page}/{num}")
    public List<BoxInfoDto> boxListPaging(@PathVariable int typeId, @PathVariable int page, @PathVariable int num) {
        if (typeId <= 1)
            typeId = 1;
        if (num < 0)
            num = 0;
        List<BoxInfoDto> allBoxes = getAllBoxListsByTypeId(typeId);
        if (page * num > allBoxes.size() && page * num - num < allBoxes.size()) {
            return allBoxes.subList(page * num - num, allBoxes.size());
        } else if (page * num <= allBoxes.size()) {
            return allBoxes.subList(page * num - num, page * num);
        } else {
            return allBoxes.subList(0, 0);
        }

    }

    /**
     * @title:获取指定用户预定的所有包厢
     * @user:admin
     * @return:java.util.List<ktv.dto.ListBoxDto>
     * @date:2017/1/8 14:58
     **/
    @RequestMapping(value = "getAllBoxListsByTelephone", method = RequestMethod.GET)
    public List<ListBoxDto> getAllBoxListsByTelephone(String telephone) {
        return boxInfoService.getAllBoxListsByTelephone(telephone);
    }

    @PostMapping("/changeBoxStatus/{id}")
    public CommonResponseDto changeBoxStatus(@PathVariable int id) {
        System.out.println(id);
        BoxInfo box = boxInfoService.getByKey(id);
        box.setStatus(1 - box.getStatus());
        boxInfoService.update(box);
        return CommonResponseUtil.successWithNull();
    }


}
