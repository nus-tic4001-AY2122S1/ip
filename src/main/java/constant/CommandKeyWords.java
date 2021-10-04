package constant;

import exception.ErrorHandler;

public enum CommandKeyWords {
    DONE("DONE"), TODO("TODO"), DEADLINE("DEADLINE"), LIST("LIST"), EVENT("EVENT"), BYE("BYE"), DELETE("DELETE"), FIND("FIND");

    /**
     * @return string which shows all available command key words
     */
    private static String getSerializedString() { return "DONE, TODO, DEADLINE, EVENT, LIST, BYE"; }
    private String value;

    CommandKeyWords(String value) {
        this.value = value;
    }

    /**
     * @return enum value
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    /**
     * @param value is an enum string for validating if the given value is valid
     * @throws ErrorHandler customized error
     */
    public static CommandKeyWords getEnum(String value) throws ErrorHandler {
        for(CommandKeyWords v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new ErrorHandler(ErrorMessage.INVALID_COMMAND + " Please starts your command with "
                + getSerializedString()
                + " (case insensitive)");
    }

}

