package com.geyan.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

public class MyRealm extends AuthorizingRealm {
	
	//授权
	@Override  
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		 String currentUsername = (String)super.getAvailablePrincipal(principals);   
		 
//      //为当前用户设置角色和权限    
//      SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();    
//      simpleAuthorInfo.addRoles(roleList);    
//      simpleAuthorInfo.addStringPermissions(permissionList);   
          
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();  
          
        if(null!=currentUsername && currentUsername.equals("admin")){    
            //添加一个角色,不是配置意义上的添加,而是证明该用户拥有admin角色      
            simpleAuthorInfo.addRole("admin");    
            //添加权限    
            simpleAuthorInfo.addStringPermission("admin:manage");    
            System.out.println("已为用户[admin]赋予了[admin]角色和[admin:manage]权限");    
            return simpleAuthorInfo;    
        }   
        return simpleAuthorInfo;    
      
        //若该方法什么都不做直接返回null的话,就会导致任何用户访问/admin/listUser.jsp时都会自动跳转到unauthorizedUrl指定的地址    
        //详见applicationContext.xml中的<bean id="shiroFilter">的配置    
//      return null; 
	}
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		//获取基于用户名和密码的令牌    
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的    
        UsernamePasswordToken token1 = (UsernamePasswordToken)token;    
        System.out.println("MyRealm.doGetAuthenticationInfo.token="+token1);   
          
//      User user = userService.getByUsername(token.getUsername());    
//      if(null != user){    
//          AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), user.getNickname());    
//          this.setSession("currentUser", user);    
//          return authcInfo;    
//      }else{    
//          return null;    
//      }    
        //此处无需比对,比对的逻辑Shiro会做,我们只需返回一个和令牌相关的正确的验证信息    
        //说白了就是第一个参数填登录用户名,第二个参数填合法的登录密码(可以是从数据库中取到的,本例中为了演示就硬编码了)    
        //这样一来,在随后的登录页面上就只有这里指定的用户和密码才能通过验证    
        if("admin".equals(token1.getUsername())){    
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("admin", "admin", this.getName());    
            SecurityUtils.getSubject().getSession().setAttribute("currentUser", "admin");  
            return authcInfo;    
        }else if("user".equals(token1.getUsername())){    
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo("user", "user", this.getName());    
            SecurityUtils.getSubject().getSession().setAttribute("currentUser", "user");  
            return authcInfo;    
        }    
        //没有返回登录用户名对应的SimpleAuthenticationInfo对象时,就会在LoginController中抛出UnknownAccountException异常    
        return null;  
		
	}

}
