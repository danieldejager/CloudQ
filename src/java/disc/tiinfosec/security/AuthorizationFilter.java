/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package disc.tiinfosec.security;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
/**
 *
 * @author daniel112
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"*.xhtml"})
public class AuthorizationFilter implements Filter {

    public AuthorizationFilter() {}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    @SuppressWarnings({"null", "UseSpecificCatch"})
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest reqt = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession ses = reqt.getSession(false);
            String reqURI = reqt.getRequestURI();
            if (reqURI.contains("/administration-passwords")) {
                chain.doFilter(request, response);
            } else if ( reqURI.contains("/login.xhtml") || (ses != null) && ses.getAttribute("username") != null || reqURI.contains("javax.faces.resource")) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/reports.xhtml")) {
                chain.doFilter(request, response);
            } else if(reqURI.contains("/register.xhtml")) {
                chain.doFilter(request, response);
            } else if ( reqURI.contains("/thankyou.xhtml")) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/administration-registrations") && ses.getAttribute("role").equals("disc-admin")  ) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/createquestions") && ses.getAttribute("role").equals("disc-admin") ) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/warningPage.xhtml)")) {
                chain.doFilter(request, response);
            } else if ( reqURI.contains("/registrationConfirmationValidate"))  {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/HighLevelDescription")) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/assessmentanswers")) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/performAssessment")) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/showFindings")) {
                chain.doFilter(request,response);
            } else if(reqURI.contains("/prepareEvaluation")) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/newOverall")) {
                chain.doFilter(request, response);
            } else if (reqURI.contains("/displayAll")) {
                chain.doFilter(request, response);
            } else {
                System.out.println("Not 100%. Redirecting user");
                resp.sendRedirect(reqt.getContextPath() +  "/faces/login.xhtml");
            } 
    } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void destroy() {}
    
    private boolean isSessionInvalid(HttpServletRequest request) {
        boolean sessionInvalid = (request.getRequestedSessionId() != null) && !request.isRequestedSessionIdValid();
        return sessionInvalid;
    }
}
