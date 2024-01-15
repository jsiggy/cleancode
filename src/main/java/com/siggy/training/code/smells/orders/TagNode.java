package com.siggy.training.code.smells.orders;

import java.util.*;

public class TagNode {
    private final String name;
    private final List<TagNode> children;
    private final Map<String, String> attributes;
    private String value;

    public TagNode(String name) {
        this.name = name;
        attributes = new LinkedHashMap<>();
        children = new ArrayList<>();
        value = "";
    }

    public void add(TagNode childNode) {
        children.add(childNode);
    }

    public void addAttribute(String attribute, String value) {
        attributes.put(attribute, value);
    }

    public void addValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return new TagNodeWriter().toString();
    }

    private class TagNodeWriter {
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            writeOpenTagTo(result);
            writeChildrenTo(result);
            writeValueTo(result);
            writeEndTagTo(result);
            return result.toString();
        }

        private void writeChildrenTo(StringBuilder result) {
            for (TagNode node : children) {
                result.append(node.toString());
            }
        }

        private void writeValueTo(StringBuilder result) {
            if (!value.equals("")) result.append(value);
        }

        protected void writeEndTagTo(StringBuilder result) {
            result.append("</");
            result.append(name);
            result.append(">");
        }

        protected void writeOpenTagTo(StringBuilder result) {
            result.append("<");
            result.append(name);
            writeAttributes(result);
            result.append(">");
        }

        protected void writeAttributes(StringBuilder result) {
            attributes.entrySet().forEach(e -> writeAttributeTo(result, e.getKey(), e.getValue()));
        }

        private void writeAttributeTo(StringBuilder result, String attribute, String value) {
            result.append(" ");
            result.append(attribute);
            result.append("='");
            result.append(value);
            result.append("'");
        }
    }
}
