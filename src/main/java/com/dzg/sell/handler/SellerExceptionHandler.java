package com.dzg.sell.handler;

import com.dzg.sell.VO.ResultVO;
import com.dzg.sell.config.ProjectUrlConfig;
import com.dzg.sell.exception.SellException;
import com.dzg.sell.exception.SellerAuthorizeException;
import com.dzg.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellerExceptionHandler {
    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handleAuthorizeException() {
//        return new ModelAndView("redirect:".concat(projectUrlConfig.getWechatMpAuthorize().concat("/sell/wechat/qrAuthorize")
//                .concat("?returnUrl=").concat(projectUrlConfig.getSell()).concat("/sell/seller/login")));
//        由于无法获取微信平台提供的openid，可以自己拼接一个openid来测试
        return new ModelAndView("redirect:".concat(projectUrlConfig.getSell()).concat("/sell/seller/login?openid=abc123"));
    }
    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellerException(SellException e){
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
}
