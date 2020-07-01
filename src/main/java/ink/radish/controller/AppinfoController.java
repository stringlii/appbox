package ink.radish.controller;

import ink.radish.entity.Appinfo;
import ink.radish.entity.ResponseData;
import ink.radish.service.AppinfoService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("rest")
public class AppinfoController {

    @Resource
    private AppinfoService appinfoService;

    @GetMapping("appinfos")
    public ResponseData findAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", required = false, defaultValue = "20") Integer limit,
                                @RequestParam(value = "search", required = false) String search) {

        if (search != null) {
            Page<Appinfo> appinfos = this.appinfoService.findAll(page - 1, limit, search);
            return ResponseData.success(appinfos);
        }

        Page<Appinfo> appinfos = this.appinfoService.findAll(page - 1, limit);

        if (appinfos == null) {
            return ResponseData.error();
        }

        return ResponseData.success(appinfos);
    }

    @PostMapping("appinfos")
    public ResponseData saveOne(Appinfo appinfo) {

        this.appinfoService.saveOne(appinfo);
        return ResponseData.success();
    }

    @GetMapping("appinfos/{id}")
    public ResponseData findOne(@PathVariable(value = "id") Integer id) {

        Appinfo appinfo = this.appinfoService.findOne(id);
        return ResponseData.success(appinfo);
    }

    @DeleteMapping("appinfos/{id}")
    public ResponseData deleteOne(@PathVariable(value = "id") Integer id) {

        this.appinfoService.deleteOne(id);
        return ResponseData.success(null, "删除成功");
    }

    @PutMapping("appinfos/{id}")
    public ResponseData updateOne(@PathVariable(value = "id") Integer id, Appinfo appinfo) {

        Boolean flag = this.appinfoService.updateOne(id, appinfo);
        if (flag) {
            return ResponseData.error();
        }
        return ResponseData.success(null, "修改成功");
    }
}
