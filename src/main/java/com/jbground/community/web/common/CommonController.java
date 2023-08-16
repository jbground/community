package com.jbground.community.web.common;

import com.jbground.community.model.Sample;
import com.jbground.community.web.index.IndexController;
import com.nhncorp.lucy.security.xss.XssSaxFilter;
import org.apache.commons.text.StringEscapeUtils;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CommonController {

    @Resource(type = XssSaxFilter.class)
    private XssSaxFilter xssSaxFilter;

    private final static Logger logger = LoggerFactory.getLogger(CommonController.class);

    @RequestMapping(value = "/alertRedirect")
    public String alertRedirect(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        return "";
    }

    @RequestMapping(value = "/sanitizer/test")
    public String sanitizer(HttpServletRequest request, Model model) throws Exception{
        return "thymeleaf/common/sanitizer";
    }

    @RequestMapping(value = "/sanitizer/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insertSanitizer(@ModelAttribute Sample sample, HttpServletRequest request, Model model) throws Exception{

        PolicyFactory policy = new HtmlPolicyBuilder()
                .allowElements("p", "br", "img", "span", "strong")
                .allowAttributes("src", "alt").onElements("img")
                .allowStyling()
                .disallowTextIn("script")
                .requireRelNofollowOnLinks()
                .toFactory();

//        String source = StringEscapeUtils.escapeHtml4(sample.getContent());
        String dirty = StringEscapeUtils.unescapeHtml4(sample.getContent());

        dirty = dirty.replaceAll("&lt;", "<");
        dirty = dirty.replaceAll("&gt;", ">");

        logger.info("before : {}", dirty);

        logger.info("xssSaxFilter : {}", xssSaxFilter.doFilter(dirty));

        String sanitize = policy.sanitize(dirty);

//        sanitize = sanitize.replaceAll("&lt;", "<");
//        sanitize = sanitize.replaceAll("&gt;", ">");
        sanitize = StringEscapeUtils.unescapeHtml4(sanitize);

        logger.info("owasp : {}", policy.sanitize(sanitize));
        return "thymeleaf/common/sanitizer";
    }
}
