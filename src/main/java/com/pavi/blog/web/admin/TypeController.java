package com.pavi.blog.web.admin;

import com.github.pagehelper.PageInfo;
import com.pavi.blog.po.Type;
import com.pavi.blog.service.TypeService;
import com.pavi.blog.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author pavi
 * @date 2020/10/7 14:17
 */
@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/admin/types/{pageNum}/{pageSize}")
    public String toTypePage(@PathVariable(name = "pageNum",  required = false) Integer pageNum,
                             @PathVariable(name = "pageSize",  required = false) Integer pageSize,
                             Model model) {
        PageInfo<Type> typePageInfo = typeService.listTypeByPaging(pageNum,pageSize);

        model.addAttribute("typePageInfo",typePageInfo);
        return "admin/types";
    }

    @ResponseBody
    @GetMapping("/admin/types/notPaging")
    public Result listTypesNotPaging(){
        List<Type> types = typeService.listType();
        Map<String,Object> map = new HashMap<>();
        map.put("types",types);
        return new Result().setSuccess(true).setData(map);
    }

    @ResponseBody
    @GetMapping("/admin/listType")
    public PageInfo<Type> listType(@RequestParam(name = "pageNum",required = false,defaultValue = "1") int pageNum){
        PageInfo<Type> typePageInfo = typeService.listType(pageNum);

        return typePageInfo;
    }

    @GetMapping("/admin/types/save")
    public String toSaveTypePage(){

        return "admin/types-input";
    }

    @PostMapping("/admin/type")
    public String saveType(Type type){
        typeService.saveType(type);
        return "redirect:admin/types/1/5";
    }

    @PutMapping("/admin/type/{id}")
    public String updateType(HttpServletRequest request, @PathVariable(value = "id") Long id, Type type){


        typeService.updateType(type);
        return "redirect:admin/types/1/5";
    }


    @GetMapping("/admin/type/delete/{id}")
    public String removeTypeById(@PathVariable("id")Long id){


        typeService.removeTypeById(id);

        return "redirect:/admin/types/1/5";
    }

    @GetMapping("/admin/types/editType/{typeId}")
    public String toUpdatePage(@PathVariable("typeId")Long typeId,Model model){

        Type type = typeService.getTypeById(typeId);
        model.addAttribute("type",type);
        return "admin/types-input";

    }
}
