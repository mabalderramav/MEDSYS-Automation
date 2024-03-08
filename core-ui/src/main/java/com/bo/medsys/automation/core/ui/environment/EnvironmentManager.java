package com.bo.medsys.automation.core.ui.environment;

import com.bo.medsys.automation.core.ui.config.UiConfig;
import org.json.simple.JSONObject;

import java.util.Objects;

import static com.bo.medsys.automation.core.utils.json.JsonFileReader.loadJsonObjectFromFile;
import static com.bo.medsys.automation.core.utils.json.JsonPath.getResults;

/**
 * Sets up Environment data for test execution.
 */
public final class EnvironmentManager {
    public static final String PORTALS_NAME_FILTER = "Portals[?(@.Name == '%s')]";
    public static final String ENVIRONMENTS_NAME_FILTER = "$.Environments[?(@.Name == '%s')]";
    private static final String USERS_TYPE_FILTER = "Users[?(@.Type == '%s')]";
    private static final String FILTER_USERNAME = "Username";
    private static final String FILTER_PASSWORD = "Password";

    private static EnvironmentManager instance;
    private final JSONObject jsonObject;
    private final String jsonPathEnvironmentFilter;
    private final int index;
    private String portalWeb;
    private String userType;
    private String jsonPathFilter;
    private String jsonPathPortalFilter;

    /**
     * Initializes an instance of {@link EnvironmentManager}.
     */
    private EnvironmentManager() {
        index = 0;
        jsonObject = loadJsonObjectFromFile(EnvironmentWords.ENVIRONMENT_PATH.val());
        String environmentName = UiConfig.getInstance().getEnvironment();
        jsonPathEnvironmentFilter = String.format(ENVIRONMENTS_NAME_FILTER, environmentName);
    }

    /**
     * Initializes a singleton Environment Manager instance.
     *
     * @return singleton instance of {@link EnvironmentManager}.
     */
    public static EnvironmentManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new EnvironmentManager();
        }
        return instance;
    }

    public void setPortalWeb(String portalWeb) {
        this.portalWeb = portalWeb;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLoginUrl() {
        var urlFilterFormat = "%s.%s.LoginUrl";
        return getUrl(urlFilterFormat);
    }

    public String getBaseUrl() {
        var urlFilterFormat = "%s.%s.BaseUrl";
        return getUrl(urlFilterFormat);
    }

    private String getUrl(final String urlFilterFormat) {
        jsonPathPortalFilter = String.format(PORTALS_NAME_FILTER, portalWeb);
        jsonPathFilter = String.format(urlFilterFormat,
                jsonPathEnvironmentFilter, jsonPathPortalFilter);
        return getResults(jsonObject, jsonPathFilter).get(index);
    }

    public String getUsername() {
        return getUserType(FILTER_USERNAME);
    }

    public String getPassword() {
        return getUserType(FILTER_PASSWORD);
    }

    private String getUserType(final String filterName) {
        var jsonPathUserFilter = String.format(USERS_TYPE_FILTER, userType);
        jsonPathPortalFilter = String.format(PORTALS_NAME_FILTER, portalWeb);
        jsonPathFilter = String.format("%s.%s.%s.".concat(filterName),
                jsonPathEnvironmentFilter, jsonPathPortalFilter, jsonPathUserFilter);

        return getResults(jsonObject, jsonPathFilter).get(index);
    }
}
