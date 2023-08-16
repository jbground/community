package com.jbground.community.util;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

public class XSSSanitizer {

    private static PolicyFactory policy = null;

    private static PolicyFactory getInstance() {

        if (policy == null) {
            synchronized (PolicyFactory.class) {

                if(policy != null)
                    return policy;

                policy = new HtmlPolicyBuilder()
                        .allowElements("img", "div", "p")
                        .allowAttributes("src", "alt").onElements("img")
                        .requireRelNofollowOnLinks()
                        .toFactory();
            }
        }

        return policy;
    }


    public static String doFilter(String source) {
        PolicyFactory policy = getInstance();
        return policy.sanitize(source);
    }
}
