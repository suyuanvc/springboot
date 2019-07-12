package com.cc.ssm.person.web;


import com.cc.ssm.person.entity.Person;
import com.cc.ssm.person.service.IPersonService;
import com.cc.ssm.user.entity.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cc
 * @since 2019-07-03
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IPersonService personService;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addPerson(){
        return "person/person";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Person person,String _birthday)throws Exception{
        log.info(_birthday);
        if(!_birthday.equals("")) {
            person.setBirthday(sdf.parse(_birthday));
        }
        personService.add(person);
        return "redirect:/person/findAll";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) throws Exception{
        personService.delete(id);
        return "redirect:/person/findAll";
    }

    @RequestMapping("/get/{id}")
    public String getOne(@PathVariable("id") Integer id, Model model) throws Exception{
        Person person = personService.getOne(id);
        model.addAttribute("person",person);
        return "person/person";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Person person ,String _birthday) throws Exception{
        if(!_birthday.equals("")) {
            person.setBirthday(sdf.parse(_birthday));
        }
        personService.update(person);
        return "redirect:/person/findAll";
    }

    @RequestMapping("/findAll")
    public String listUser (Model model, @RequestParam(value = "start",defaultValue = "0") int start,
                            @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id desc");
        List<Person> personList = personService.all();
        PageInfo<Person> page = new PageInfo<>(personList);
        model.addAttribute("page",page);
        return "/person/personList";
    }

   /* @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }*/

}
