package com.jbground.community.sanitizer;

import org.junit.jupiter.api.Test;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class SanitizerTest {

    @Test
    void test1() {

//        String source = "<P style="FONT-FAMILY: Gulim"><SPAN style="TEXT-ALIGN: justify; LINE-HEIGHT: 16pt; LETTER-SPACING: 0pt; FONT-FAMILY: Gulim; COLOR: #000000; FONT-SIZE: 10pt; FONT-WEIGHT: bold"></SPAN></P>";
//
//        PolicyFactory policy = new HtmlPolicyBuilder()
//                .allowElements("p", "br", "img", "span")
//                .allowAttributes("src", "alt").onElements("img")
//                .requireRelNofollowOnLinks()
//                .toFactory();
//        String sanitize = policy.sanitize(source);
//
//        System.out.println(sanitize);
    }
}
