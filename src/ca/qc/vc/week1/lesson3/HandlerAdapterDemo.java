package ca.qc.vc.week1.lesson3;

/**
 * This demo displays a Spring MVC handler adapter
 *
 */

import java.util.ArrayList;
import java.util.List;

// Represents a simplified HTTP request
class Request {
    private final String path;

    public Request(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

// Represents a simplified MVC result
class ModelAndView {
    private final String viewName;
    private final String message;

    public ModelAndView(String viewName, String message) {
        this.viewName = viewName;
        this.message = message;
    }

    @Override
    public String toString() {
        return "View = " + viewName + ", Model message = " + message;
    }
}

// ----------------------------------------------
// Handler type 1: traditional controller style
// ----------------------------------------------
interface Controller {
    ModelAndView handleRequest(Request request);
}

class LegacyUserController implements Controller {

    @Override
    public ModelAndView handleRequest(Request request) {
        return new ModelAndView(
                "legacyUserView",
                "Handled by LegacyUserController: " + request.getPath()
        );
    }
}

// ----------------------------------------------
// Handler type 2: annotation-style controller
// In real Spring, reflection finds @RequestMapping methods.
// ----------------------------------------------
class UserApiController {

    public String getUser(Request request) {
        return "Handled by UserApiController: user data for " + request.getPath();
    }
}

// ----------------------------------------------
// Target interface used by DispatcherServlet
// ----------------------------------------------
interface HandlerAdapter {

    boolean supports(Object handler);

    ModelAndView handle(Request request, Object handler);
}

// Adapter for traditional Controller objects
class SimpleControllerHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof Controller;
    }

    @Override
    public ModelAndView handle(Request request, Object handler) {
        Controller controller = (Controller) handler;

        return controller.handleRequest(request);
    }
}

// Adapter for annotation-style controller objects
class UserApiHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof UserApiController;
    }

    @Override
    public ModelAndView handle(Request request, Object handler) {
        UserApiController controller = (UserApiController) handler;

        String message = controller.getUser(request);

        return new ModelAndView("jsonView", message);
    }
}

// ----------------------------------------------
// DispatcherServlet-like front controller
// ----------------------------------------------
class DispatcherServlet {

    private final List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    public DispatcherServlet() {
        handlerAdapters.add(new SimpleControllerHandlerAdapter());
        handlerAdapters.add(new UserApiHandlerAdapter());
    }

    public void dispatch(Request request, Object handler) {
        for (HandlerAdapter adapter : handlerAdapters) {
            if (adapter.supports(handler)) {
                ModelAndView result = adapter.handle(request, handler);

                System.out.println(result);
                return;
            }
        }

        throw new IllegalArgumentException(
                "No HandlerAdapter found for: "
                        + handler.getClass().getSimpleName()
        );
    }
}

// ----------------------------------------------
// Client / application startup
// ----------------------------------------------
public class HandlerAdapterDemo {

    public static void main(String[] args) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        Request request1 = new Request("/legacy/users/1");
        Object handler1 = new LegacyUserController();

        dispatcherServlet.dispatch(request1, handler1);

        System.out.println();

        Request request2 = new Request("/api/users/2");
        Object handler2 = new UserApiController();

        dispatcherServlet.dispatch(request2, handler2);
    }
}