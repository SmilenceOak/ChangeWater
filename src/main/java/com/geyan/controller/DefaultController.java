package com.geyan.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.ExcessiveAttemptsException;  
import org.apache.shiro.authc.IncorrectCredentialsException;  
import org.apache.shiro.authc.LockedAccountException;  
import org.apache.shiro.authc.UnknownAccountException; 


@Controller  
@RequestMapping("/default")  
public class DefaultController {
	@RequestMapping("/login.action")  
    public String login(String username,String password,Model model){  
         UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
         token.setRememberMe(true);  
         
         System.out.println("DefaultController.login#token="+token);  
           
         Subject currentUser = SecurityUtils.getSubject();  
           
         try {    
                //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查    
                //每个Realm都能在必要时对提交的AuthenticationTokens作出反应    
                //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法    
                System.out.println("user[" + username + "]do login checking");    
                currentUser.login(token);    
                System.out.println("user[" + username + "]authentication success");    
                 
            }catch(UnknownAccountException uae){    
                System.out.println("user[" + username + "]UnknownAccountException");    
                model.addAttribute("error_msg", "UnknownAccountException");  
            }catch(IncorrectCredentialsException ice){    
                System.out.println("user[" + username + "]IncorrectCredentialsException");  
                model.addAttribute("error_msg", "IncorrectCredentialsException");    
            }catch(LockedAccountException lae){    
                System.out.println("user[" + username + "]LockedAccountException");   
                model.addAttribute("error_msg", "LockedAccountException");    
            }catch(ExcessiveAttemptsException eae){    
                System.out.println("user[" + username + "]ExcessiveAttemptsException");    
                model.addAttribute("error_msg", "ExcessiveAttemptsException");    
            }catch(AuthenticationException ae){    
                //注意：这个必须放在后面，因为这个异常可以处理所有认证失败的情况  
                model.addAttribute("error_msg", "authentication faild");    
            }    
            //验证是否登录成功    
            if(currentUser.isAuthenticated()){    
                System.out.println("user[" + username + "]authentication success");   
                return "redirect:main.action";  
            }    
            token.clear();   
            return "login";  
           
    }  
    @RequestMapping("/logout.action")  
    public String logout(){  
        SecurityUtils.getSubject().logout();  
        return "redirect:login.action";  
    }  
    
    @RequestMapping("/main.action")  
    public String mainLogin(){  
        return "main";  
    }  
    @RequestMapping("/index.action")  
    public String index(Model model){  
    	 model.addAttribute("error_msg", "没有前线");    
        return "index";  
    }  
}
