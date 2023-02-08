package hello.servlet.basic.request;


import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        //메세지 내용을 바이트코드로 받아옴
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        //StreamUtils로 해석해서 가져옴.

        System.out.println("messageBody = " + messageBody);

        response.getWriter().write("ok");
    }
}
