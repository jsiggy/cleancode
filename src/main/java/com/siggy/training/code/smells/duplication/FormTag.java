package com.siggy.training.code.smells.duplication;

import org.w3c.dom.Node;

public class FormTag  {
    public String toPlainTextString() {
        var textContents = new StringBuilder();
//        getChildren().forEach(node -> textContents.append(node.toPlainTextString()));
        return textContents.toString();
    }

    private Iterable<Object> getChildren() {
        return null;
    }
}
