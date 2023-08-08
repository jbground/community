package com.jbground.community.util;

public class Common {

    public static final String[] keyword = {"frameset", "oncut", "void", "applet", "eval", "onstop", "cookie", "style"
            , "layer", "javascript", "document", "onclick", "onactivae", "onfocusin"
            , "onselectstart", "onbeforecut", "onkeyup", "onkeydown", "xml", "create", "onload", "script", "link"
            , "binding", "ondeactivate", "object", "embed", "msgbox", "ondragend", "onbounce", "onerror", "ondragstart"
            , "ondragleave", "onmovestart", "frame", "onabort", "onmouseup", "onmouseout", "ilayer", "innerHTML", "onmove"
            , "base", "bgsound", "href", "onresize", "onpaste", "onrowexit", "onstart", "onfocus", "ondragenter"
            , "ondrag", "ondblclick", "onunload", "onsubmit", "meta", "onchang", "eexpression", "vbscript", "charset", "refresh", "alert"
            , "append", "string", "onselect", "blink", "iframe", "title", "onscroll", "ondragover", "onreset"
            , "onfinish", "oncopy", "ondrop", "document.cookie", "onpointerdown"};

    public static String findObjectAddress(Object o){
        return o.getClass().getName() + "@" + Integer.toHexString(o.hashCode());
    }
}
