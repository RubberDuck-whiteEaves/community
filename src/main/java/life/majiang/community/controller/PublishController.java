package life.majiang.community.controller;

import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionMapper questionMapper;

    // get请求，通过该方法来处理，作用初步定为渲染页面（通过浏览器输入链接直接访问/a标签跳转时，是get请求）
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    // post请求，通过该方法来处理，作用初步定为处理请求（提交问题表单的方法在前端设定为post请求）
    @PostMapping("/publish")
    public String doPublish(@RequestParam(value = "title",required = false) String title,
                            @RequestParam(value = "description",required = false) String description,
                            @RequestParam(value = "tag",required = false) String tag,
                            HttpServletRequest request,
                            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        // 这三个对文本框内容的检测需要同时在前端用js且后端用逻辑代码实现，因为前端可能会绕过验证
        if(title==null||title.equals("")){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if(description==null||description.equals("")){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }
        if(tag==null||tag.equals("")){
            model.addAttribute("error","标签不能为空");
            return "publish";
        }
//        /*这里后续是否能改进为从session获取*/
//        Cookie[] cookies = request.getCookies();
//        if(cookies!=null&&cookies.length!=0){
//            for(Cookie cookie:cookies){
//                if(cookie.getName().equals("token")){
//                    String token=cookie.getValue();
//                    user=userMapper.findByToken(token);
//                    if(user!=null){
//                        request.getSession().setAttribute("user",user);
//                    }
//                    break;
//                }
//            }
//        }
        User user = (User) request.getSession().getAttribute("user");

        /*这里后续是否能改进为：未登录用户则无法进入发布问题页面（直接通过url也无法访问）*/
        if(user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
        return "redirect:/";
    }
}
