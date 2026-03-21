package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.Controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.Controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.Controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    // URL → 컨트롤러 매핑 (어떤 요청이 어떤 컨트롤러로 갈지 저장)
    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        // 요청 URL과 실제 실행할 컨트롤러 연결
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 요청 URL 가져오기
        String requestURI = request.getRequestURI();

        // 2. URL에 맞는 컨트롤러 찾기
        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // 3. request → paramMap으로 변환 (컨트롤러는 request를 몰라야 함)
        Map<String, String> paramMap = createParamMap(request);
        // 4. 컨트롤러 실행 → 결과(ModelView) 받기
        ModelView mv = controller.process(paramMap);
        // 5. 컨트롤러가 준 "논리 뷰 이름" 꺼내기
        String viewName = mv.getViewName(); //논리이름
        // 6. 논리 이름 → 실제 JSP 경로로 변환
        MyView view = viewResolver(viewName);
        // 7. model 데이터를 request에 담고 JSP로 forward
        view.render(mv.getModel(), request,response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }


    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
