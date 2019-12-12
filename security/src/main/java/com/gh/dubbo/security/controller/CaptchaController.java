package com.gh.dubbo.security.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class CaptchaController {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("/getCaptcha")
    public void getCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        String text = captchaProducer.createText();

        session.setAttribute("captcha", text);

        BufferedImage image = captchaProducer.createImage(text);

        ServletOutputStream outputStream = response.getOutputStream();

        ImageIO.write(image, "jpg", outputStream);
        outputStream.flush();
        outputStream.close();

    }
}
