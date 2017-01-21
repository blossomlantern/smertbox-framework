package com.smertbox.security.core.matcher.csrf;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class CsrfSecurityIgnoringRequestMatcher implements RequestMatcher {
    private Pattern allowedMethods = Pattern
            .compile("^(GET|HEAD|TRACE|OPTIONS)$");

    public boolean matches(HttpServletRequest request) {

        if (ignroingUrls != null && ignroingUrls.size() > 0) {
            String servletPath = request.getServletPath();
            PathMatcher matcher = new AntPathMatcher();
            for (String url : ignroingUrls) {
                if (matcher.match(url, servletPath)) {
                    return false;
                }
            }
        }
        return !allowedMethods.matcher(request.getMethod()).matches();
    }

    /**
     * 需要排除的url列表
     */
    private List<String> ignroingUrls;

	public List<String> getIgnroingUrls() {
		return ignroingUrls;
	}

	public void setIgnroingUrls(List<String> ignroingUrls) {
		this.ignroingUrls = ignroingUrls;
	}

}
