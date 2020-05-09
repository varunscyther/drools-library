package io.github.varunscyther.drools.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Action {
    private String ruleName;
    private Map<String, String> actionParamters = new HashMap<>();

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Map<String, String> getActionParamters() {
        return actionParamters;
    }

    public void setActionParamters(Map<String, String> actionParamters) {
        this.actionParamters = actionParamters;
    }
}
