package com.siggy.training.code.smells.duplication;

import org.w3c.dom.Node;

public class LinkTag {
    public String toPlainTextString() {
        var sb = new StringBuilder();
//        childTags.forEach(n -> sb.append(n.toPlainTextString()));
        return sb.toString();
    }
}