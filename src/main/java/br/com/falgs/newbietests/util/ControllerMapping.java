package br.com.falgs.newbietests.util;

public class ControllerMapping {

    private ControllerMapping() {
    }

    public static final String VERSION_API = "/v1";

    public static final String ROOT_PATH = "api" + VERSION_API;

    public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";

    public static final String MOVIE_PATH = PRIVATE_ROOT_PATH + "/movie";

}
