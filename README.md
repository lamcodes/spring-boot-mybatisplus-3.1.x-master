# spring-boot-mybatisplus-3.1.x-master
测试git pull
git fetch
增加一次主分支提交
git pull看起来像git fetch+get merge
git fetch 更新本地跟踪的远程分支
git merge 分支合并
merge和rebase
master12  

通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。  

注解了@ControllerAdvice的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。
@ExceptionHandler：用于全局处理控制器里的异常，进行全局异常处理
@InitBinder：用来设置WebDataBinder，用于自动绑定前台请求参数到Model中，全局数据预处理。
@ModelAttribute：本来作用是绑定键值对到Model中，此处让全局的@RequestMapping都能获得在此处设置的键值对 ，全局数据绑定。  

@ControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上。
https://juejin.cn/post/6844904168025489421

reuslt，统一消息响应格式  
ResultMsgEnum，枚举类设置响应数据与code  
ExceptionEnum,枚举类设置响应数据与code  
ResponseAdvice,统一controller返回数据格式，继承了ResponseBodyAdvice来实现的，需要使用RestControllerAdvice
BusinessException，自定义异常。统一包装。  
GlobalExceptionHandler，使用@RestControllerAdvice对controller进行增强，可对controller中被 @RequestMapping注解的方法加一些逻辑处理。  
通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。  
使用 @ExceptionHandler(Exception.class)捕获异常，  
test分支cherrypick设置
