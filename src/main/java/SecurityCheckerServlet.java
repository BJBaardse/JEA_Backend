//import javax.security.auth.Subject;
//import javax.security.auth.callback.CallbackHandler;
//import javax.security.auth.login.LoginContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
//public class SecurityCheckerServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    public SecurityCheckerServlet() {
//        super();
//    }
//    protected void doGet(HttpServletRequest request,
//                         HttpServletResponse response) throws ServletException,
//            IOException {
//        char[] password = null;
//        PrintWriter out=response.getWriter();
//        try
//        {
//            SecurityAssociationHandler handler = new
//                    SecurityAssociationHandler();
//            SimplePrincipal user = new
//                    SimplePrincipal(request.getParameter
//                    ("j_username"));
//            password=request.getParameter("j_password").
//                    toCharArray();
//            handler.setSecurityInfo(user, password);
//            System.out.println("password"+password);
//            CallbackHandler myHandler = new
//                    UserCredentialHandler(request.getParameter
//                    ("j_username"),request.getParameter
//                    ("j_password"));
//            LoginContext lc = new LoginContext("other", handler);
//            lc.login();
//            Subject subject = lc.getSubject();
//            Set principals = subject.getPrincipals();
//            List l=new ArrayList();
//            Iterator it = lc.getSubject().getPrincipals().
//                    iterator();
//            while (it.hasNext()) {
//                System.out.println("Authenticated: " + it.next().toString() + " ");
//                        out.println("Authenticated: " +
//                                        request.getParameter("j_username")+" "+it.next().toString() + " ");
//            }
//            it = lc.getSubject().getPublicCredentials
//                    (Properties.class).iterator();
//            while (it.hasNext())
//                System.out.println(it.next().toString());
//            lc.logout();
//        } catch (Exception e) {
//            out.println("failed authenticatation.-"+e);
//        }
//    }
//    protected void doPost(HttpServletRequest request,
//                          HttpServletResponse response) throws ServletException,
//            IOException {
//    }
//}